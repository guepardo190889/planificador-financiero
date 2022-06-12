package com.blackdeath.planificadorfinanciero.modelos.divisa;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.blackdeath.planificadorfinanciero.entidades.Divisa;

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
	@NotNull(message = "Nombre es requerido")
	@NotEmpty(message = "Nombre no puede ser vacío")
	@Size(min = 1, max = 32, message = "Nombre requiere entre 1 y 32 caracteres")
	private String nombre;

	/**
	 * Código de esta divisa
	 */
	@NotNull(message = "Código es requerido")
	@NotEmpty(message = "Código no puede ser vacío")
	@Size(min = 3, max = 3, message = "Código requiere tres caracteres")
	private String codigo;

	/**
	 * Indica si esta divisa es la opción por defecto entre todas
	 */
	@NotNull(message = "Por defecto es requerido")
	private Boolean porDefecto;
}
