/**
 * 
 */
package com.blackdeath.planificadorfinanciero.modelos.entidadfinanciera;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.blackdeath.planificadorfinanciero.entidades.EntidadFinanciera;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoEntidadFinanciera;

import lombok.Data;

/**
 * Modelo que contiene los datos necesarios para actualizar una
 * {@link EntidadFinanciera}
 * 
 * @author Seth Karim Luis Martínez
 * @since 12-06-2022
 *
 */
@Data
public class EntidadFinancieraActualizadoModel {

	/**
	 * Nombre con el que se identifica esta entidad financiera
	 */
	@NotNull(message = "Nombre es requerido")
	@NotEmpty(message = "Nombre no puede ser vacío")
	@Size(min = 1, max = 64, message = "Nombre requiere entre 1 y 64 caracteres")
	private String nombre;

	/**
	 * {@link TipoEntidadFinanciera} que clasifica a esta entidad financiera
	 */
	private TipoEntidadFinanciera tipo;

	/**
	 * Verifica si el {@code nombre} que se va a actualizar para esta entidad
	 * financiera es diferente al nombre actual. Si los nombres son iguales se
	 * devuelve {@code false}, de lo contrario {@code true}
	 * <p>
	 * 
	 * @param nombreActual
	 * @return {@code true} si el nombre es nuevo, de lo contrario {@code false}
	 */
	public boolean isNombreNuevo(String nombreActual) {
		return !nombre.equals(nombreActual);
	}
}
