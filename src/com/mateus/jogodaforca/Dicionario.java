package com.mateus.jogodaforca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mateus.jogodaforca.utils.RandomUtils;

/**
 * Encapsula a lógica que lê as palavras disponíveis para o jogo e faz o sorteio.
 * Esta classe implementa o design pattern singleton.
 */
public class Dicionario {
	
	private static final String ARQUIVO_DICIONARIO = "dicionario.txt";
	
	private static Dicionario instance;
	
	private List<String> palavras = new ArrayList<String>();
	
	/**
	 * Construtor
	 */
	private Dicionario() {
		carregarPalavras();
	}
	
	/**
	 * Obtém a instância da classe
	 * @return Retorna sempre a mesma instância da classe
	 */
	public static Dicionario getInstance() {
		if (instance == null) {
			instance = new Dicionario();
		}
		return instance;
	}
	
	/**
	 * Lê as palavras dos arquivos e as coloca na lista de palavras.
	 */
	public void carregarPalavras() {
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File(ARQUIVO_DICIONARIO));
			
			while (scanner.hasNextLine()) {
				palavras.add(scanner.nextLine().trim());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
	
	/**
	 * Sorteia uma palavra para ser utilizada no jogo.
	 * @return A palavra sorteada
	 * @throws JogoDaForcaException Caso nenhuma palavra tenha sido cadastrada.
	 */
	public Palavra proximaPalavra() throws JogoDaForcaException {
		
		if (palavras.size() == 0) {
			throw new JogoDaForcaException("Nenhuma palavra foi encontrada!");
		}
		
		// Gera um número randomico entre 0 e o tamanho da lista de palavras
		int pos = RandomUtils.gerarNumeroRandomico(0, palavras.size());
		
		// Cria um objeto palavra utilizando a palavra sorteada
		Palavra palavra = new Palavra(palavras.get(pos));
		
		return palavra;
	}
}
