package com.mateus.jogodaforca;

/**
 * Representa uma exce��o gen�rica ocorrida no jogo
 * @author Mateus Dantas
 *
 */
public class JogoDaForcaException extends Exception {
	
	public JogoDaForcaException(String message) {
		super(message);
	}
	
	public JogoDaForcaException(String message, Throwable cause) {
		super(message, cause);
	}
}
