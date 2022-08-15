package com.mateus.jogodaforca;

/**
 * Representa uma exceção genérica ocorrida no jogo
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
