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

	
	
}
