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
	
	private void doarLivro() {
		int numero;
		String titulo;
		String autor;
		int ano;
		
		System.out.println("Digite o numero do livro: ");
		numero = SCANNER.nextInt();
		SCANNER.nextLine();
		
		System.out.println("Digite o título do livro: ");
		titulo = SCANNER.nextLine();
		
		System.out.println("Digite o autor do livro: ");
		autor = SCANNER.nextLine();
		
		System.out.println("Digite o ano do livro: ");
		ano = SCANNER.nextInt();
		
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
		System.out.println("Opção inválida! Digite novamente");
	}
}
