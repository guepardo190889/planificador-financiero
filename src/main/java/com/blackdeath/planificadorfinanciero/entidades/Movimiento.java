package com.blackdeath.planificadorfinanciero.entidades;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoMovimiento;

import lombok.Data;

/**
 * Entidad que representa un movimiento financiero
 * 
 * @author Seth Karim Luis Martínez
 * @since 06-05-2022
 *
 */
@Data
@Table(name = "movimientos")
@Entity
public class Movimiento {

	/**
	 * Identificador único de este movimiento
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, updatable = false)
	private Long id;

	/**
	 * Monto de este movimiento
	 */
	@Column(unique = false, nullable = false, updatable = true, precision = 19, scale = 2)
	private BigDecimal monto;

	/**
	 * {@link TipoMovimiento} que clasifica a este movimiento
	 */
	@Enumerated(EnumType.STRING)
	@Column(unique = false, nullable = false, updatable = true, length = 7)
	private TipoMovimiento tipo;

	/**
	 * Fecha en que se realiza este movimiento
	 */
	@Column(unique = false, nullable = false, updatable = true)
	private Date fecha;

	/**
	 * Descripción corta de este movimiento
	 */
	@Column(name = "descripcion_corta", unique = false, nullable = false, updatable = true, length = 128)
	private String descripcionCorta;

	/**
	 * Descripción larga de este movimiento
	 */
	@Column(name = "descripcion_larga", unique = false, nullable = true, updatable = true, length = 512)
	private String descripcionLarga;

}
