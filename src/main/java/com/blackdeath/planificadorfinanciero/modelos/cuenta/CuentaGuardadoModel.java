package com.blackdeath.planificadorfinanciero.modelos.cuenta;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.blackdeath.planificadorfinanciero.entidades.Cuenta;
import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.blackdeath.planificadorfinanciero.entidades.EntidadFinanciera;
import com.blackdeath.planificadorfinanciero.utilidades.constantes.Constantes;

import lombok.Data;

/**
 * Modelo que contiene los datos necesarios para guardar una {@link Cuenta}
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
	@NotNull(message = "Nombre es requerido")
	@NotEmpty(message = "Nombre no puede ser vacío")
	@Size(min = 1, max = 32, message = "Nombre requiere entre 1 y 32 caracterest")
	private String nombre;

	/**
	 * Saldo de esta cuenta
	 */
	@NotNull(message = "Saldo es requerido")
	@Min(value = Constantes.MINIMO_SALDO, message = "El saldo debe ser mayor o igual a -999,999,999,999")
	@Max(value = Constantes.MAXIMO_SALDO, message = "El saldo debe ser menor o igual a 999,999,999,999")
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

	/**
	 * Identificador único de la {@link EntidadFinanciera de esta cuenta}
	 */
	@Min(value = 1, message = "Identificador único de entidad financiera debe ser positivo")
	private Long entidadFinancieraId;

}
