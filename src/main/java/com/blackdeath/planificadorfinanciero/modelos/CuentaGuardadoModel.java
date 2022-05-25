package com.blackdeath.planificadorfinanciero.modelos;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.blackdeath.planificadorfinanciero.entidades.Cuenta;
import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.sun.istack.NotNull;

import lombok.Data;

/**
 * Modelo de datos que contiene los datos necesarios para guardar una
 * {@link Cuenta}
 * 
 * @author Seth Karim Luis Martínez
 * @since 24-05-2022
 *
 */
@Data
public class CuentaGuardadoModel {

	/**
	 * Nombre con el que se identifica esta cuenta
	 */
	@NotNull
	@NotEmpty
	private String nombre;

	/**
	 * Balance de esta cuenta
	 */
	@NotNull
	@Min(0)
	private BigDecimal balance;

	/**
	 * Identificador único de la {@link Divisa} de esta cuenta
	 */
	@NotNull
	@Min(1)
	private Long divisaId;

}
