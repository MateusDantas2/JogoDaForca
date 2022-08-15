package com.mateus.jogodaforca.utils;

/**
 * Métodos utilitários de números randômicos
 * @author Mateus Dantas
 *
 */
public class RandomUtils {
	
	/**
	 * Gera um número randômico entre min (inclusive) e max. O valor máximo que pode ser gerado será max-1 
	 * @param min
	 * @param max
	 * @return Número randômico gerado.
	 */
	public static int gerarNumeroRandomico(int min, int max) {
		int intervalo = max - min;
		return (int) (Math.random() * intervalo) + min;
	}
}
