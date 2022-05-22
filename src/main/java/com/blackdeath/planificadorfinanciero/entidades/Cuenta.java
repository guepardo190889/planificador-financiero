package com.blackdeath.planificadorfinanciero.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Cuenta, monedero o lugar en donde se guarda dinero
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
public class Cuenta {

	/**
	 * Identificador único de esta cuenta
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, updatable = false)
	private Long id;

	/**
	 * Nombre con el que se identifica esta cuenta
	 */
	@Column(unique = true, nullable = false, updatable = true, length = 32)
	private String nombre;

	/**
	 * Balance de esta cuenta
	 */
	@Column(unique = false, nullable = false, updatable = true, precision = 19, scale = 2)
	private BigDecimal balance;
}
