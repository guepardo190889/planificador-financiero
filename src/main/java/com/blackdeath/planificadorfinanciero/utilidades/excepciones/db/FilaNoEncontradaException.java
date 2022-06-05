package com.blackdeath.planificadorfinanciero.utilidades.excepciones.db;

import lombok.Getter;

/**
 * Excepción genérica que indica que no se encontró un registro en la base de
 * datos
 * 
 * @author Seth Karim Luis Martínez
 * @since 01-06-2022
 *
 */
@Getter
public class FilaNoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = -1395031906293535872L;

	/**
	 * Constructor que construye esta excepción a partir de un mensaje
	 * 
	 * @param mensaje
	 * @param codigoError
	 */
	public FilaNoEncontradaException(String mensaje) {
		super(mensaje);
	}
}
