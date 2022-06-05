package com.blackdeath.planificadorfinanciero.modelos.divisa;

import com.blackdeath.planificadorfinanciero.entidades.Divisa;

import lombok.Data;

/**
 * Modelo de datos que representa una {@link Divisa}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@Data
public class DivisaModel {

	/**
	 * Identificador único de esta divisa
	 */
	private Long id;

	/**
	 * Nombre de esta divisa
	 */
	private String nombre;

	/**
	 * Código de esta divisa
	 */
	private String codigo;

	/**
	 * Constructor que inicializa los campos a partir de una {@link Divisa}
	 * 
	 * @param divisa
	 */
	public DivisaModel(Divisa divisa) {
		id = divisa.getId();
		nombre = divisa.getNombre();
		codigo = divisa.getCodigo();
	}
}
