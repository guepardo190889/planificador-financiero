package com.blackdeath.planificadorfinanciero.enumeradores;

import lombok.Getter;

/**
 * Enumerador de códigos de error
 * 
 * @author Seth Karim Luis Martínez
 * @since 01-06-2022
 *
 */
@Getter
public enum CodigoError {

	C00001("Divisa no encontrada");
	
	private String descripcion;

	private CodigoError(String descripcion) {
		this.descripcion = descripcion;
	}
}
