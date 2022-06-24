package com.blackdeath.planificadorfinanciero.utilerias.enumeradores;

import lombok.Getter;

/**
 * Tipo de categoría
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@Getter
public enum TipoCategoria {
	INGRESO("Ingreso"), EGRESO("Egreso");

	/**
	 * Descripción de este tipo de categoría
	 */
	private String descripcion;

	private TipoCategoria(String descripcion) {
		this.descripcion = descripcion;
	}
}
