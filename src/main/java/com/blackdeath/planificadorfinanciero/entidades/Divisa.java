package com.blackdeath.planificadorfinanciero.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blackdeath.planificadorfinanciero.modelos.DivisaGuardadoModel;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Divisa o moneda
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 */
@NoArgsConstructor
@Data
@Table(name = "divisas")
@Entity
public class Divisa implements Serializable {

	private static final long serialVersionUID = -6949771166570269658L;

	/**
	 * Nombre de esta entidad
	 */
	public static final String NOMBRE = "divisa";

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
	@Column(unique = true, nullable = false, updatable = true, length = 32)
	private String nombre;

	/**
	 * Código de esta divisa
	 */
	@Column(unique = true, nullable = false, updatable = true, length = 3)
	private String codigo;

	/**
	 * Fecha en que se guardó esta divisa
	 */
	@Column(name = "fecha_guardado", unique = false, nullable = false, updatable = false)
	private Date fechaGuardado;

	/**
	 * Constructor que inicializa campos necesarios para guardar esta divisa desde
	 * una {@link DivisaGuardadoModel}
	 * 
	 * @param divisa
	 */
	public Divisa(DivisaGuardadoModel divisa) {
		nombre = divisa.getNombre();
		codigo = divisa.getCodigo();
		fechaGuardado = new Date();
	}

	/**
	 * Constructor que asigna el identificador único de esta divisa
	 * 
	 * @param id
	 */
	public Divisa(Long id) {
		this.id = id;
	}
}
