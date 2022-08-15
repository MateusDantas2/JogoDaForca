package com.mateus.jogodaforca;

/**
 * Exce��o que indica que o caractere digitado � inv�lido por algum motivo.
 * @author Mateus Dantas
 *
 */
public class CaractereInvalidoException extends JogoDaForcaException {
	
	public CaractereInvalidoException(String message) {
		super(message);
	}
}
