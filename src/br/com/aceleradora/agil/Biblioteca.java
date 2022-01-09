package br.com.aceleradora.agil;

import java.util.Scanner;

public class Biblioteca {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final int OPCAO_INICIAL = 1;
	private static final int OPCAO_SAIR = 0;
	
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
		default:
			opcaoInvalida();
			break;
		}	
	}
	
	private void sair() {
		System.out.println("Programa finalizado com sucesso!");
		System.exit(0);
	}
	
	private void opcaoInvalida() {
		System.out.println("Opção inválida! Digite novamente");
	}
}
