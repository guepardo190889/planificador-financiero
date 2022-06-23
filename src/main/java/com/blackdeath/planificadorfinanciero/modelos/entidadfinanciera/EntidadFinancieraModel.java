/**
 * 
 */
package com.blackdeath.planificadorfinanciero.modelos.entidadfinanciera;

import com.blackdeath.planificadorfinanciero.entidades.EntidadFinanciera;
import com.blackdeath.planificadorfinanciero.modelos.tipoentidadfinanciera.TipoEntidadFinancieraModel;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoEntidadFinanciera;

import lombok.Data;

/**
 * Modelo que representa una {@link EntidadFinanciera}
 * 
 * @author Seth Karim Luis Martínez
 * @since 12-06-2022
 *
 */
@Data
public class EntidadFinancieraModel {

	/**
	 * Identificador único de esta entidad financiera
	 */
	private Long id;

	/**
	 * Nombre con el que se identifica esta entidad financiera
	 */
	private String nombre;

	/**
	 * Descripción de esta entidad financiera
	 */
	private String descripcion;

	/**
	 * Representación del {@link TipoEntidadFinanciera} que clasifica a esta entidad
	 * financiera
	 */
	private TipoEntidadFinancieraModel tipo;

	/**
	 * Constructor que inicializa los campos a partir de una
	 * {@link EntidadFinanciera}
	 * 
	 * @param entidadFinanciera
	 */
	public EntidadFinancieraModel(EntidadFinanciera entidadFinanciera) {
		id = entidadFinanciera.getId();
		nombre = entidadFinanciera.getNombre();
		tipo = new TipoEntidadFinancieraModel(entidadFinanciera.getTipo());
	}

}
