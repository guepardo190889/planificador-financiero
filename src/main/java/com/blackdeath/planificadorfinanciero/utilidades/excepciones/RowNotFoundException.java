package com.blackdeath.planificadorfinanciero.utilidades.excepciones;

import com.blackdeath.planificadorfinanciero.enumeradores.CodigoError;

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
public class RowNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1395031906293535872L;

	/**
	 * Identificador único del error
	 */
	private CodigoError codigoError;

	/**
	 * Constructor que construye esta excepción a partir de un mensaje y un código
	 * de error
	 * 
	 * @param mensaje
	 * @param codigoError
	 */
	public RowNotFoundException(String mensaje, CodigoError codigoError) {
		super(mensaje);
		this.codigoError = codigoError;
	}
}
