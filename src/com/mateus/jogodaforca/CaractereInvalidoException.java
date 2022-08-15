package com.mateus.jogodaforca;

/**
 * Exceção que indica que o caractere digitado é inválido por algum motivo.
 * @author Mateus Dantas
 *
 */
public class CaractereInvalidoException extends JogoDaForcaException {
	
	public CaractereInvalidoException(String message) {
		super(message);
	}
}
