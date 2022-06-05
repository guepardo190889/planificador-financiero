package com.blackdeath.planificadorfinanciero.utilidades.excepciones.db;

/**
 * Excepción genérica que indica que el registro ya se encuentra en la base de
 * datos
 * 
 * @author Seth Karim Luis Martínez
 * @since 04-06-2022
 *
 */
public class FilaDuplicadaException extends RuntimeException {

	private static final long serialVersionUID = -2444999250309625533L;

	/**
	 * Constructor que construye esta excepción a partir de un mensaje
	 * 
	 * @param mensaje
	 * @param codigoError
	 */
	public FilaDuplicadaException(String mensaje) {
		super(mensaje);
	}
}
