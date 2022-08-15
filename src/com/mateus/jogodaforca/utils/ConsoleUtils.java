package com.mateus.jogodaforca.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mateus.jogodaforca.CaractereInvalidoException;
import com.mateus.jogodaforca.JogoDaForcaException;

/**
 * Métodos utilitários de console
 * @author Mateus Dantas
 *
 */
public class ConsoleUtils {
	
	/**
	 * Lê uma letra do console
	 * 
	 * @return Letra lida
	 * @throws CaractereInvalidoException
	 *             Pode ser lançaada em três casos: se nada for digitado, se mais
	 *             de uma letra for digitada e se o caractere digitado não for
	 *             uma letra de A a Z
	 * @throws {@link IOException} Se houver algum problema de I/O relacionado à
	 *         leitura do console
	 */
	public static char lerLetra() throws JogoDaForcaException {
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));

			String linha = reader.readLine();
			
			if (linha.trim().isEmpty()) {
				throw new CaractereInvalidoException("Nenhuma letra foi digitada!");
			}
			
			if (linha.length() > 1) {
				throw new CaractereInvalidoException("Apenas uma letra deve ser digitada!");
			}
			
			char letra = linha.toUpperCase().charAt(0);
			
			if (!Character.isLetter(letra)) {
				throw new CaractereInvalidoException("Apenas letras devem ser digitadas!");
			}
			
			return letra;
			
		} catch (IOException e) {
			throw new JogoDaForcaException("Problema ao ler caractere do teclado.", e);
		}
	}
}
