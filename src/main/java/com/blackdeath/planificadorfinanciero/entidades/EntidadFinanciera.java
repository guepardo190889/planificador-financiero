package com.blackdeath.planificadorfinanciero.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blackdeath.planificadorfinanciero.modelos.entidadfinanciera.EntidadFinancieraGuardadoModel;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoEntidad;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad financiera donde es posible aperturar una cuenta y administrar
 * dinero.
 * 
 * @author Seth Karim Luis Martínez
 * @since 12-06-2022
 *
 */
@NoArgsConstructor
@Data
@Table(name = "entidades_financieras")
@Entity
public class EntidadFinanciera implements Serializable {
	private static final long serialVersionUID = 470921138317573482L;

	/**
	 * Identificador único de esta entidad financiera
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, updatable = false)
	private Long id;

	/**
	 * Nombre con el que se identifica esta entidad financiera
	 */
	@Column(unique = true, nullable = false, updatable = true, length = 64)
	private String nombre;

	/**
	 * Descripción de esta entidad financiera
	 */
	@Column(unique = false, nullable = true, updatable = true, length = 128)
	private String descripcion;

	/**
	 * {@link TipoEntidad} que clasifica a esta entidad financiera
	 */
	@Enumerated(EnumType.STRING)
	@Column(unique = false, nullable = true, updatable = true, length = 64)
	private TipoEntidad tipo;

	/**
	 * Fecha en que se guardó esta cuenta
	 */
	@Column(name = "fecha_guardado", unique = false, nullable = false, updatable = false)
	private Date fechaGuardado;

	/**
	 * Constructor que inicializa los campos necesrios para guardar esta entidad
	 * financiera desde una {@link EntidadFinancieraGuardadoModel}
	 * 
	 * @param entidadFinanciera
	 */
	public EntidadFinanciera(EntidadFinancieraGuardadoModel entidadFinanciera) {
		nombre = entidadFinanciera.getNombre();
		descripcion = entidadFinanciera.getDescripcion();
		tipo = entidadFinanciera.getTipo();
		fechaGuardado = new Date();
	}

}
