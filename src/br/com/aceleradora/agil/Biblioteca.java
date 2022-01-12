package br.com.aceleradora.agil;

import java.util.Scanner;

import br.com.aceleradora.agil.modelo.Livro;
import br.com.aceleradora.agil.repositorio.RepositorioDeLivros;
import br.com.aceleradora.agil.repositorio.RepositorioDeLivrosEmMemoria;

public class Biblioteca {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final int OPCAO_INICIAL = 1;
	private static final int OPCAO_SAIR = 0;
	private RepositorioDeLivros repositorioDeLivros;
	
	public Biblioteca() {
		this.repositorioDeLivros = new RepositorioDeLivrosEmMemoria();
	}
	
	public void iniciar() {
		int opcao = OPCAO_INICIAL;
		
		while(opcao != OPCAO_SAIR) {
			imprimeMenu();
			opcao = getOpcaoDigitada();
			SCANNER.nextLine();
			executaOpcaoEscolhida(opcao);
		}
	}
	
	private void imprimeMenu() {
		System.out.println("Digite (0) para sair do MENU");
		System.out.println("Digite (1) para retirar um livro");
		System.out.println("Digite (2) para devolver um livro");
		System.out.println("Digite (3) para doar um livro");
		System.out.println("Digite (4) para listar todos os livros");
	}
	
	private int getOpcaoDigitada() {
		return SCANNER.nextInt();
	}
	
	private void executaOpcaoEscolhida(int opcao) {
		switch (opcao) {
		case 0:
			sair();
			break;
		case 1:
			retirarLivro();
			break;
		case 2:
			devolverLivro();
			break;
		case 3:
			doarLivro();
			break;
		case 4:
			listarLivros();
			break;
		default:
			opcaoInvalida();
			break;
		}	
	}
	
	private void sair() {
		System.out.println("Programa finalizado com sucesso!");
		System.exit(0);
	}
	
	private void retirarLivro() {

		System.out.println("\nDigite o numero do livro que deseja alugar: ");
		Integer numero = SCANNER.nextInt();
		SCANNER.nextLine();
		
		Livro livroSelecionadoParaAlugar = repositorioDeLivros.getLivroPeloNumero(numero);
		System.out.println("\nLivro selecionado: " + livroSelecionadoParaAlugar);
		
		System.out.println("\nDigite seu nome: ");
		String nome = SCANNER.nextLine();
		
		livroSelecionadoParaAlugar.setStatus("Indisponivel");
		livroSelecionadoParaAlugar.setEmprestadoPara(nome);
		
		System.out.println("\nLivro " + livroSelecionadoParaAlugar.getTitulo() + " alugado por " + livroSelecionadoParaAlugar.getEmprestadoPara()
		+ " com sucesso!\n" + livroSelecionadoParaAlugar);
	}
	
	private void devolverLivro() {
		
		System.out.println("Digite o numero do livro que deseja devolver: ");
		Integer numero = SCANNER.nextInt();
		
		Livro livroSelecionadoParaDevolver = repositorioDeLivros.getLivroPeloNumero(numero);
		System.out.println("\nLivro selecionado: " + livroSelecionadoParaDevolver);
		
		livroSelecionadoParaDevolver.setStatus("Disponivel");
		livroSelecionadoParaDevolver.setEmprestadoPara(null);
		
		System.out.println("\nLivro " + livroSelecionadoParaDevolver.getTitulo() + " devolvido com sucesso!\n" + livroSelecionadoParaDevolver);
	}
	
	private void doarLivro() {
		
		System.out.println("Digite o numero do livro: ");
		Integer numero = SCANNER.nextInt();
		SCANNER.nextLine();
		
		System.out.println("Digite o t�tulo do livro: ");
		String titulo = SCANNER.nextLine();
		
		System.out.println("Digite o autor do livro: ");
		String autor = SCANNER.nextLine();
		
		System.out.println("Digite o ano do livro: ");
		Integer ano = SCANNER.nextInt();
		
		Livro livro = new Livro(numero, titulo, autor, ano);
		repositorioDeLivros.adicionaLivro(livro);
		
		System.out.println(livro);
	}
	
	private void listarLivros() {
		System.out.println("Lista de livros: ");
		repositorioDeLivros.getTodosLivros().forEach(livro -> {
			System.out.println(livro);
		});
	}
	
	private void opcaoInvalida() {
		System.out.println("Op��o inv�lida! Digite novamente");
	}
}
