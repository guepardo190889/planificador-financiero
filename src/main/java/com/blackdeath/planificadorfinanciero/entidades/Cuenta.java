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

import com.blackdeath.planificadorfinanciero.modelos.cuenta.CuentaGuardadoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cuenta o depósito donde se guarda dinero
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
	 * Saldo de esta cuenta
	 */
	@Column(unique = false, nullable = false, updatable = true, precision = 14, scale = 2)
	private BigDecimal saldo;

	/**
	 * Indica si esta cuenta es la opción por defecto entre todas
	 */
	@Column(name = "por_defecto", unique = false, nullable = false, updatable = true, columnDefinition = "boolean default false")
	private Boolean porDefecto;

	/**
	 * Fecha en que se guardó esta cuenta
	 */
	@Column(name = "fecha_guardado", unique = false, nullable = false, updatable = false)
	private Date fechaGuardado;

	/**
	 * {@link Divisa} de esta cuenta
	 */
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "divisa_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Divisa divisa;

	/**
	 * {@link EntidadFinanciera} de esta cuenta
	 */
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "entidad_financiera_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private EntidadFinanciera entidadFinanciera;

	/**
	 * Constructor que inicializa los campos necesarios para guardar esta cuenta
	 * desde una {@link CuentaGuardadoModel}
	 * 
	 * @param cuenta
	 * @param divisa
	 * @param entidadFinanciera
	 */
	public Cuenta(CuentaGuardadoModel cuenta, Divisa divisa, EntidadFinanciera entidadFinanciera) {
		nombre = cuenta.getNombre();
		saldo = cuenta.getSaldo();
		porDefecto = cuenta.getPorDefecto();
		fechaGuardado = new Date();
		this.divisa = divisa;

		if (entidadFinanciera != null) {
			this.entidadFinanciera = entidadFinanciera;
		}
	}

}
