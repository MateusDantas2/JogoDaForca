package com.mateus.jogodaforca.utils;

/**
 * M�todos utilit�rios de n�meros rand�micos
 * @author Mateus Dantas
 *
 */
public class RandomUtils {
	
	/**
	 * Gera um n�mero rand�mico entre min (inclusive) e max. O valor m�ximo que pode ser gerado ser� max-1 
	 * @param min
	 * @param max
	 * @return N�mero rand�mico gerado.
	 */
	public static int gerarNumeroRandomico(int min, int max) {
		int intervalo = max - min;
		return (int) (Math.random() * intervalo) + min;
	}
}
