package br.com.aceleradora.agil.repositorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import br.com.aceleradora.agil.modelo.Livro;

public class RepositorioDeLivrosEmArquivo implements RepositorioDeLivros {
	private File arquivo;
	
	public RepositorioDeLivrosEmArquivo() {
		arquivo = new File("resources/arquivo.txt");
		
		try {

			if (!arquivo.exists()) {
				
				Livro livro1 = new Livro(1, "Como fazer sentido e bater o martelo", "Alexandro Aolchique", 2017);
				Livro livro2 = new Livro(2, "Código Limpo", "Tio Bob", 2001);
				Livro livro3 = new Livro(3, "Basquete 101", "Hortência Marcari", 2010);
				
				arquivo.createNewFile();
				
				FileWriter fw = new FileWriter(arquivo, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(livro1.toStringFormatadoParaArquivo());
				bw.newLine();
				bw.write(livro2.toStringFormatadoParaArquivo());
				bw.newLine();
				bw.write(livro3.toStringFormatadoParaArquivo());
				bw.newLine();
				bw.close();
				fw.close();
			}		
		} catch(IOException e) {
			throw new RuntimeException("Erro ao criar arquivo inicial com os três livros obrigatórios!", e);
		}
	}
	
	@Override
	public void adicionaLivro(Livro livro) {
		try {
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(livro.toStringFormatadoParaArquivo());
			bw.newLine();
			bw.close();
			fw.close();
		} catch(IOException e) {
			throw new RuntimeException("Erro ao adicionar um novo livro", e);
		}
	}

	@Override
	public List<Livro> getTodosLivros() {
		List<Livro> livros = new ArrayList<>();

		try {
			InputStream fis = new FileInputStream("resources/arquivo.txt");
	        Reader isr = new InputStreamReader(fis);
	        BufferedReader br = new BufferedReader(isr);
	
	        String linha = br.readLine();
	
	        while(linha != null) {
	                String[] split = linha.split(",");
	                
	                String numero = split[0];
	                String titulo = split[1];
	                String autor = split[2];
	                String ano = split[3];
	                String status = split[4];
	                String emprestadoPara = split[5];
	                
	                linha = br.readLine();
	                
	                Livro livro = new Livro(Integer.valueOf(numero), titulo, autor, Integer.valueOf(ano), status, emprestadoPara);
	                livros.add(livro);
	        }
	        br.close();
	        isr.close();
	        fis.close();
		} catch(IOException e) {
			throw new RuntimeException("Erro ao listar todos os livros!", e);
		}
		return livros;
	}

	@Override
	public Livro getLivroPeloNumero(Integer numero) {
		try {
			InputStream fis = new FileInputStream("resources/arquivo.txt");
	        Reader isr = new InputStreamReader(fis);
	        BufferedReader br = new BufferedReader(isr);

	        String linha = br.readLine();

	        while(linha != null) {
	                String[] split = linha.split(",");
	                
	                String numeroLivroDoArquivo = split[0];
	                String titulo = split[1];
	                String autor = split[2];
	                String ano = split[3];
	                String status = split[4];
	                String emprestadoPara = split[5];
	                
	                linha = br.readLine();
	                
	                if(numeroLivroDoArquivo.equals(numero.toString())) {
	                	Livro livro = new Livro(Integer.valueOf(numero), titulo, autor, Integer.valueOf(ano), status, emprestadoPara);
	                	return livro;
	                }
	        }
	        br.close();
	        isr.close();
	        fis.close();
			} catch(IOException e) {
				throw new RuntimeException("Erro ao procurar livro no arquivo!", e);
			}
		throw new RuntimeException("Livro não encontrado!");
	}

	@Override
	public void alugarLivro(Livro livroSelecionadoParaAlugar, String nome) {		
			List<Livro> livros = getTodosLivros();
			
			try {
				
				FileWriter fw = new FileWriter(arquivo, false);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for (Livro livro : livros) {
					if(livro.equals(livroSelecionadoParaAlugar)) {
						livro.setStatus(Livro.INDISPONIVEL);
						livro.setEmprestadoPara(nome);
						livroSelecionadoParaAlugar.setStatus(Livro.INDISPONIVEL);
						livroSelecionadoParaAlugar.setEmprestadoPara(nome);
					}
					bw.write(livro.toStringFormatadoParaArquivo());
					bw.newLine();
				}
				bw.close();
				fw.close();
			} catch(IOException e) {
				throw new RuntimeException("Erro ao alugar o livro!", e);
			}
	}

	@Override
	public void devolverLivro(Livro livroSelecionadoParaDevolver, String nome) {
			List<Livro> livros = getTodosLivros();
			
			try {
				
				FileWriter fw = new FileWriter(arquivo, false);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for (Livro livro : livros) {
					if(livro.equals(livroSelecionadoParaDevolver)) {
						livro.setStatus(Livro.DISPONIVEL);
						livro.setEmprestadoPara(null);
						livroSelecionadoParaDevolver.setStatus(Livro.DISPONIVEL);
						livroSelecionadoParaDevolver.setEmprestadoPara(null);
					}
					bw.write(livro.toStringFormatadoParaArquivo());
					bw.newLine();
				}
				bw.close();
				fw.close();
			} catch(IOException e) {
				throw new RuntimeException("Erro ao devolver o livro!", e);
			}
	}
}
