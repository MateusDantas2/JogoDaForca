package com.mateus.jogodaforca;

import java.util.HashSet;
import java.util.Set;

/**
 * Representa a palavra sorteada.
 * @author Mateus Dantas
 *
 */
public class Palavra {
	
	private static final char CARACTERE_SECRETO = '_';
	
	/**
	 * Palavra que ser� sorteada
	 */
	private String palavraOriginal;
	
	private Set<Character> caracteresEncontrados = new HashSet<Character>();
	
	/**
	 * Construtor.
	 * @param palavraOriginal Palavra sorteada
	 */
	public Palavra(String palavraOriginal) {
		this.palavraOriginal = palavraOriginal.toUpperCase();
	}
	
	/** 
	 * Retorna a palavra. Se o jogador ainda n�o descobriu determinada letra, o {@link #CARACTERE_SECRETO}
	 * � mostrado no lugar dela.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// Utiliza um StringBuilder para evitar a concatena��o de strings
		StringBuilder sb = new StringBuilder();
		
		// Converte a palabra em um array de caracteres
		char[] letrasArray = palavraOriginal.toCharArray();
		
		for (int i = 0; i < letrasArray.length; i++) {
			char c = letrasArray[i];
			
			// Checa se o caracetere est� presente na lista de caracteres encontrados
			if (caracteresEncontrados.contains(c)) {
				// Se est�, significa que o usu�rio j� o identificou, portanto ele pode ser mostrado
				sb.append(c);
			} else {
				// Caso contr�rio, o CARACTERE_SECRETO � exibido no lugar
				sb.append(CARACTERE_SECRETO);
			}
			
			sb.append(" ");
		}
		// Converte o StringBuffer para string e retorna (remove o espa�o em branco do fim).
		return sb.toString().trim();
	}
	
	/**
	 * Obt�m o tamanho da palavra
	 * @return Tamanho da palavra
	 */
	public int tamanho() {
		return palavraOriginal.length();
	}
	
	/**
	 * Verifica se a letra fornecida existe na palavra
	 * @param letra Letra fornecida pelo jogador
	 * @return true se a letra existir e false se n�o existir
	 */
	public boolean possuiLetra(char letra) {
		if (palavraOriginal.indexOf(letra) > -1) {
			caracteresEncontrados.add(letra);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Verifica se o jogador acertou a palavra inteira.
	 * @return true se acertou e false se n�o acertou
	 */
	public boolean acertouPalavra() {
		char[] letrasArray = palavraOriginal.toCharArray();
		
		Set<Character> letras = letras = new HashSet<Character>();
		
		// Adiciona todos os caracteres da palavra no conjunto. Se o caractere for repetido, ele
		// n�o ser� adicionado (conjuntos n�o permitem elementos repetidos
		for (int i = 0; i < letrasArray.length; i++) {
			letras.add(letrasArray[i]);
		}
		
		return letras.equals(caracteresEncontrados);
	}
	
	/**
	 * Obt�m a palavra sorteada.
	 * @return Palavra sorteada
	 */
	public String getPalavraOriginal() {
		return palavraOriginal;
	}
}
