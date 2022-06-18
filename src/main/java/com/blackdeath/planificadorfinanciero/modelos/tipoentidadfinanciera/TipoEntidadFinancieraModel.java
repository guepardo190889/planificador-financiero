package com.blackdeath.planificadorfinanciero.modelos.tipoentidadfinanciera;

import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoEntidadFinanciera;

import lombok.Data;

/**
 * Modelo que representa un {@link TipoEntidadFinanciera}
 * 
 * @author Seth Karim Luis Martínez
 * @since 18-06-2022
 *
 */
@Data
public class TipoEntidadFinancieraModel {

	/**
	 * {@code name} de este tipo de entidad financiera
	 */
	private String nombre;

	/**
	 * Descripción de este tipo de entidad financiera
	 */
	private String descripcion;

	/**
	 * Constructor que inicializa los campos a partir de u
	 * {@link TipoEntidadFinanciera}
	 * 
	 * @param tipoEntidadFinanciera
	 */
	public TipoEntidadFinancieraModel(TipoEntidadFinanciera tipoEntidadFinanciera) {
		nombre = tipoEntidadFinanciera.name();
		descripcion = tipoEntidadFinanciera.getDescripcion();
	}
}
