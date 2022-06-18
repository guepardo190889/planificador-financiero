package com.blackdeath.planificadorfinanciero.modelos.cuenta;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.blackdeath.planificadorfinanciero.entidades.Cuenta;
import com.blackdeath.planificadorfinanciero.entidades.Divisa;

import lombok.Data;

/**
 * Modelo que contiene los datos necesarios para actualizar una {@link Cuenta}
 * 
 * @author Seth Karim Luis Martínez
 * @since 12-06-2022
 *
 */
@Data
public class CuentaActualizadoModel {

	/**
	 * Nombre con el que se identifica esta cuenta
	 */
	@NotNull(message = "Nombre es requerido")
	@NotEmpty(message = "Nombre no puede ser vacío")
	@Size(min = 1, max = 32, message = "Nombre requiere entre 1 y 32 caracterest")
	private String nombre;

	/**
	 * Saldo de esta cuenta
	 */
	@NotNull(message = "Saldo es requerido")
	@Min(value = 0, message = "El saldo debe ser positivo")
	private BigDecimal saldo;

	/**
	 * Indica si esta cuenta es la opción por defecto entre todas
	 */
	@NotNull(message = "Por defecto es requerido")
	private Boolean porDefecto;

	/**
	 * Identificador único de la {@link Divisa} de esta cuenta
	 */
	@NotNull(message = "Identificador único de divisa es requerido")
	@Min(value = 1, message = "Identificador único de divisa debe ser positivo")
	private Long divisaId;

}