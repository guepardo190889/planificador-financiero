package com.blackdeath.planificadorfinanciero.modelos;

import javax.validation.constraints.NotEmpty;

import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.sun.istack.NotNull;

import lombok.Data;

/**
 * Modelo de datos que contiene los datos necesarios para guardar una
 * {@link Divisa}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@Data
public class DivisaGuardadoModel {

	/**
	 * Nombre de esta divisa
	 */
	@NotNull
	@NotEmpty
	private String nombre;

	/**
	 * Abreviación de esta divisa
	 */
	@NotNull
	@NotEmpty
	private String abreviacion;

}
