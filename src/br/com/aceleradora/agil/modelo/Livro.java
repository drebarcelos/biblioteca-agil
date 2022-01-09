package br.com.aceleradora.agil.modelo;

import java.util.Objects;

/**
 * Classe que representa a moldura de um livro
 * 
 * @author Andressa Barcelos
 *
 */

public class Livro {
	private int numero;
	private String titulo;
	private String autor;
	private int ano;
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
	
	public Livro(int numero, String titulo, String autor, int ano) {
		this.numero = numero;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.status = "Disponível";
		this.emprestadoPara = null;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
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
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmprestadoPara() {
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
		return ano == other.ano && Objects.equals(autor, other.autor)
				&& Objects.equals(emprestadoPara, other.emprestadoPara) && numero == other.numero
				&& Objects.equals(status, other.status) && Objects.equals(titulo, other.titulo);
	}
	
	@Override
    public String toString() {
        return "\nNúmero: " + this.numero + "\nTítulo: " + this.titulo + "\nAutor: " + this.autor + "\nAno: " + this.ano +
        		"\nStatus: " + this.status + "\nEmprestado para: " + this.emprestadoPara;
    }
}
