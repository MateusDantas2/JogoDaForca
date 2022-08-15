package com.mateus.jogodaforca;

import java.util.HashSet;
import java.util.Set;

import com.mateus.jogodaforca.utils.ConsoleUtils;

/**
 * Implementa a lógica de funcionamento do jogo.
 * @author Mateus Dantas
 *
 */
public class Jogo {
	
	private static final int MAX_ERROS = 5;
	
	public void iniciar() throws JogoDaForcaException {
		// Conjunto que armazena as letras já tentadas pelo usuário
		Set<Character> letrasUsadas = new HashSet<Character>();
		
		// Número atual de erros do usuário
		int erros = 0;
		
		// Sorteia uma nova palavra
		Dicionario dicionario = Dicionario.getInstance();
		Palavra palavra = dicionario.proximaPalavra();
		
		System.out.println("Bem vindo ao Jogo da Forca!");
		System.out.println("A palavra tem " + palavra.tamanho() + " letras");
		
		while (true) {
			System.out.println(palavra);
			
			System.out.println();
			
			char letra;
			try {
				System.out.print("Digite uma letra: ");
				
				letra = ConsoleUtils.lerLetra();
				
				if (letrasUsadas.contains(letra)) {
					throw new CaractereInvalidoException("Esta letra já foi utilizada!");
				}
				
				letrasUsadas.add(letra);
				
				if (palavra.possuiLetra(letra)) {
					System.out.println("Você acertou uma letra!");
				} else {
					erros++;
					
					if (erros < MAX_ERROS) {
						System.out.println("Você errou! Você ainda pode errar " + (MAX_ERROS - erros) + " vez(es)");
					}
				}
				
				System.out.println();
				
				if (palavra.acertouPalavra()) {
					System.out.println("Parabéns! Você acertou a palavra completa: " + palavra.getPalavraOriginal());
					System.out.println("Fim do Jogo!");
					break;
				}
				
				if (erros == MAX_ERROS) {
					System.out.println("Você perdeu o jogo! A palavra correta era " + palavra.getPalavraOriginal());
					System.out.println("Fim do jogo!");
					break;
				}
			} catch (CaractereInvalidoException e) {
				System.out.println("Erro: " + e.getMessage());
				System.out.println();
			}
		}
	}
}
