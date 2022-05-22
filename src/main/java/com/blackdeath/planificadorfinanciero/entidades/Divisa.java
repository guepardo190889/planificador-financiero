package com.blackdeath.planificadorfinanciero.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Divisa o moneda
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 */
@Data
@Table
@Entity
public class Divisa {

	/**
	 * Identificador único de esta divisa
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, updatable = false)
	private Long id;

	/**
	 * Nombre de esta divisa
	 */
	@Column(unique = true, nullable = false, updatable = false, length = 16)
	private String nombre;

	/**
	 * Abreviación de esta divisa
	 */
	@Column(unique = true, nullable = false, updatable = false, length = 3)
	private String abreviacion;
}
