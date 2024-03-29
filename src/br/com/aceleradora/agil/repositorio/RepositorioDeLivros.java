package br.com.aceleradora.agil.repositorio;

import java.util.List;

import br.com.aceleradora.agil.modelo.Livro;

public interface RepositorioDeLivros {
	
	void adicionaLivro(Livro livro);
	
	List<Livro> getTodosLivros();
	
	Livro getLivroPeloNumero(Integer numero);
	
	void alugarLivro(Livro livroSelecionadoParaAlugar, String nome);
	
	void devolverLivro(Livro livroSelecionadoParaDevolver, String nome);
}
