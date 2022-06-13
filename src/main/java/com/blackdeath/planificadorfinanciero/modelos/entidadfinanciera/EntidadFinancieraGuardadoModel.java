package com.blackdeath.planificadorfinanciero.modelos.entidadfinanciera;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.blackdeath.planificadorfinanciero.entidades.EntidadFinanciera;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoEntidad;

import lombok.Data;

/**
 * Modelo que contiene los datos necesarios para guardar una
 * {@link EntidadFinanciera}
 * 
 * @author Seth Karim Luis Martínez
 * @since 12-06-2022
 *
 */
@Data
public class EntidadFinancieraGuardadoModel {

	/**
	 * Nombre con el que se identifica esta entidad financiera
	 */
	@NotNull(message = "Nombre es requerido")
	@NotEmpty(message = "Nombre no puede ser vacío")
	@Size(min = 1, max = 64, message = "Nombre requiere entre 1 y 64 caracteres")
	private String nombre;

	/**
	 * Descripción de esta entidad financiera
	 */
	@Size(min = 1, max = 128, message = "Descripción requiere entre 1 y 128 caracteres")
	private String descripcion;

	/**
	 * {@link TipoEntidad} que clasifica a esta entidad financiera
	 */
	private TipoEntidad tipo;

}
