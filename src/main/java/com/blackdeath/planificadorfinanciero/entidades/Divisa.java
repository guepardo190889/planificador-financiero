package com.blackdeath.planificadorfinanciero.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blackdeath.planificadorfinanciero.modelos.divisa.DivisaGuardadoModel;

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
	 * Nombre de esta entidad usado como llave
	 */
	public static final String LLAVE = "divisa";

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
	 * Símbolo de esta divisa
	 */
	@Column(unique = false, nullable = false, updatable = true, length = 1)
	private String simbolo;

	/**
	 * Fecha en que se guardó esta divisa
	 */
	@Column(name = "fecha_guardado", unique = false, nullable = false, updatable = false)
	private Date fechaGuardado;

	/**
	 * Indica si esta divisa es la opción por defecto entre todas
	 */
	@Column(name = "por_defecto", unique = false, nullable = false, updatable = true, columnDefinition = "default column false")
	private Boolean porDefecto;

	/**
	 * Constructor que inicializa campos necesarios para guardar esta divisa desde
	 * una {@link DivisaGuardadoModel}
	 * 
	 * @param divisa
	 */
	public Divisa(DivisaGuardadoModel divisa) {
		nombre = divisa.getNombre();
		codigo = divisa.getCodigo();
		simbolo = divisa.getSimbolo();
		porDefecto = divisa.getPorDefecto();
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

	/**
	 * Indica si esta divisa es la opción por defecto entre todas
	 * 
	 * @return
	 */
	public boolean isPorDefecto() {
		return porDefecto;
	}
}
