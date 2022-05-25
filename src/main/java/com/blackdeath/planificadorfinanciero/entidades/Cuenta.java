package com.blackdeath.planificadorfinanciero.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.blackdeath.planificadorfinanciero.modelos.CuentaGuardadoModel;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cuenta, monedero o lugar en donde se guarda dinero
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@NoArgsConstructor
@Data
@Table(name = "cuentas")
@Entity
public class Cuenta implements Serializable {

	private static final long serialVersionUID = -785218259642822988L;

	/**
	 * Identificador único de esta cuenta
	 */
	@Id
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

	/**
	 * Fecha en que se guardó esta cuenta
	 */
	@Column(name = "fecha_guardado", unique = false, nullable = false, updatable = false)
	private Date fechaGuardado;

	/**
	 * {@link Divisa de esta cuenta}
	 */
	@JoinColumn(name = "id_divisa")
	@ManyToOne(fetch = FetchType.LAZY)
	private Divisa divisa;

	/**
	 * Constructor que inicializa los campos necesarios para guardar esta cuenta des
	 * de una {@link CuentaGuardadoModel}
	 * 
	 * @param cuenta
	 */
	public Cuenta(CuentaGuardadoModel cuenta) {
		nombre = cuenta.getNombre();
		balance = cuenta.getBalance();
		fechaGuardado = new Date();
		divisa = new Divisa(cuenta.getDivisaId());
	}

}
