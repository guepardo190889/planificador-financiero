package com.blackdeath.planificadorfinanciero.modelos.cuenta;

import java.math.BigDecimal;

import com.blackdeath.planificadorfinanciero.entidades.Cuenta;
import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.blackdeath.planificadorfinanciero.entidades.EntidadFinanciera;
import com.blackdeath.planificadorfinanciero.modelos.divisa.DivisaModel;
import com.blackdeath.planificadorfinanciero.modelos.entidadfinanciera.EntidadFinancieraModel;

import lombok.Data;

/**
 * Modelo que representa una {@link Cuenta}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@Data
public class CuentaModel {

	/**
	 * Identificador único de esta cuenta
	 */
	private Long id;

	/**
	 * Nombre con el que se identifica esta cuenta
	 */
	private String nombre;

	/**
	 * Saldo de esta cuenta
	 */
	private BigDecimal saldo;

	/**
	 * Indica si esta cuenta es la opción por defecto entre todas
	 */
	private Boolean porDefecto;

	/**
	 * Representación de la {@link Divisa} de esta cuenta
	 */
	private DivisaModel divisa;

	/**
	 * Representación de la {@link EntidadFinanciera} de esta cuenta
	 */
	private EntidadFinancieraModel entidadFinanciera;

	/**
	 * Constructor que inicializa los campos a partir de una {@link Cuenta}
	 * 
	 * @param cuenta
	 */
	public CuentaModel(Cuenta cuenta) {
		id = cuenta.getId();
		nombre = cuenta.getNombre();
		saldo = cuenta.getSaldo();
		porDefecto = cuenta.getPorDefecto();
		divisa = new DivisaModel(cuenta.getDivisa());

		if (cuenta.getEntidadFinanciera() != null) {
			entidadFinanciera = new EntidadFinancieraModel(cuenta.getEntidadFinanciera());
		}
	}

}
