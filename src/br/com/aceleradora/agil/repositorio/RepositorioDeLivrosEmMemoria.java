package br.com.aceleradora.agil.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.com.aceleradora.agil.modelo.Livro;

public class RepositorioDeLivrosEmMemoria implements RepositorioDeLivros {
	private List<Livro> livros;
	
	public RepositorioDeLivrosEmMemoria() {
		livros = new ArrayList<Livro>();
		
		Livro livro1 = new Livro(1, "Como fazer sentido e bater o martelo", "Alexandro Aolchique", 2017);
		Livro livro2 = new Livro(2, "Código Limpo", "Tio Bob", 2001);
		Livro livro3 = new Livro(3, "Basquete 101", "Hortência Marcari", 2010);
		
		this.livros.add(livro1);
		this.livros.add(livro2);
		this.livros.add(livro3);
	}

	@Override
	public void adicionaLivro(Livro livro) {
		this.livros.add(livro);
	}
	
	@Override
	public List<Livro> getTodosLivros() {
		return livros;
	}
	
	public Livro getLivroPeloNumero(Integer numero) {
		for (Livro livro : livros) {
			if(livro.getNumero().equals(numero)) {
				return livro;
			}
		}
		throw new RuntimeException("Livro não encontrado!");
	}

	@Override
	public void alugarLivro(Livro livroSelecionadoParaAlugar, String nome) {
		livroSelecionadoParaAlugar.setStatus(Livro.INDISPONIVEL);
		livroSelecionadoParaAlugar.setEmprestadoPara(nome);
	}

	@Override
	public void devolverLivro(Livro livroSelecionadoParaDevolver, String nome) {
		livroSelecionadoParaDevolver.setStatus(Livro.DISPONIVEL);
		livroSelecionadoParaDevolver.setEmprestadoPara(null);		
	}	
}
