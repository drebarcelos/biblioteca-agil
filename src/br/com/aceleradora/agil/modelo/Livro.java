package br.com.aceleradora.agil.modelo;

import java.util.Objects;

/**
 * Classe que representa a moldura de um livro
 * 
 * @author Andressa Barcelos
 *
 */

public class Livro {
	public static final String DISPONIVEL = "Dispon�vel";
	public static final String INDISPONIVEL = "Indispon�vel";
	private Integer numero;
	private String titulo;
	private String autor;
	private Integer ano;
	private String status;
	private String emprestadoPara;
	
	/**
	 * Construtor para inicializar o objeto Livro a partir do numero, titulo, autor e ano.
	 * 
	 * @param numero
	 * @param titulo
	 * @param autor
	 * @param ano
	 * 
	 */
	
	public Livro(Integer numero, String titulo, String autor, Integer ano) {
		this.numero = numero;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.status = DISPONIVEL;
		this.emprestadoPara = null;
	}
	
	public Livro(Integer numero, String titulo, String autor, Integer ano, String status,
			String emprestadoPara) {
		this.numero = numero;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.status = status;
		this.emprestadoPara = emprestadoPara;
	}

	public Boolean isDisponivel() {
		if(this.status.equals(DISPONIVEL)) {
			return true;
		} return false;
	}
	
	public Boolean isIndiponivel(){
		return !isDisponivel();
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Integer getAno() {
		return ano;
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmprestadoPara() {
		if(this.emprestadoPara == null) {
			return " ";
		}
		return emprestadoPara;
	}

	public void setEmprestadoPara(String emprestadoPara) {
		this.emprestadoPara = emprestadoPara;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, autor, emprestadoPara, numero, status, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(autor, other.autor)
				&& Objects.equals(emprestadoPara, other.emprestadoPara) && Objects.equals(numero, other.numero)
				&& Objects.equals(status, other.status) && Objects.equals(titulo, other.titulo);
	}

	@Override
    public String toString() {
        return "\nN�mero: " + this.numero + "\nT�tulo: " + this.titulo + "\nAutor: " + this.autor + "\nAno: " + this.ano +
        		"\nStatus: " + this.status + "\nEmprestado para: " + getEmprestadoPara();
    }
	
	public String toStringFormatadoParaArquivo() {
		return this.numero + "," + this.titulo + "," + this.autor + "," + this.ano + "," + this.status + "," + getEmprestadoPara();
	}
}
