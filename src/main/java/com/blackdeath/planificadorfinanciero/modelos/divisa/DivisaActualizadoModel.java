package com.blackdeath.planificadorfinanciero.modelos.divisa;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.sun.istack.NotNull;

import lombok.Data;

/**
 * Modelo de datos que contiene los datos necesarios para actualizar una
 * {@link Divisa}
 * 
 * @author Seth Karim Luis Martínez
 * @since 04-06-2022
 *
 */
@Data
public class DivisaActualizadoModel {

	/**
	 * Nombre de esta divisa
	 */
	@NotNull
	@NotEmpty(message = "Nombre es requerido")
	@Size(min = 1, max = 32, message = "Nombre requiere entre uno y treinta y dos caracteres")
	private String nombre;

	/**
	 * Código de esta divisa
	 */
	@NotNull
	@NotEmpty(message = "Código es requerido")
	@Size(min = 3, max = 3, message = "Código requiere tres caracteres")
	private String codigo;

	/**
	 * Símbolo de esta divisa
	 */
	@NotNull
	@NotEmpty(message = "Símbolo es erquerido")
	@Size(min = 1, max = 1)
	private String simbolo;

	/**
	 * Indica si esta divisa es la opción por defecto entre todas
	 */
	@NotNull
	private Boolean porDefecto;

}
