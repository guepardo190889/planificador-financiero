package com.blackdeath.planificadorfinanciero.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.blackdeath.planificadorfinanciero.modelos.categoria.CategoriaGuardadoModel;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoCategoria;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Categoría que sirve para clasificar a un {@link Movimiento}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@NoArgsConstructor
@Data
@Table(name = "categorias")
@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 7540550502037628981L;

	/**
	 * Identificador único de esta categoría
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, updatable = false)
	private Long id;

	/**
	 * Nombre con el que se identifica esta categoría
	 */
	@Column(unique = false, nullable = false, updatable = true, length = 32)
	private String nombre;

	/**
	 * {@link TipoCategoria} que clasifica a esta categoría
	 */
	@Enumerated(EnumType.STRING)
	@Column(unique = false, nullable = false, updatable = true, length = 7)
	private TipoCategoria tipo;

	/**
	 * {@link Categoria} a la que pertenece esta categoría
	 */
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "categoria_padre_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoriaPadre;

	/**
	 * Descripción de esta categoría
	 */
	@Column(unique = false, nullable = true, updatable = true, length = 128)
	private String descripcion;

	/**
	 * Fecha en que se guardó esta categoría
	 */
	@Column(unique = false, nullable = false, updatable = false)
	private Date fechaGuardado;

	/**
	 * Constructor que inicializa campos desde una {@link CategoriaGuardadoModel}
	 * 
	 * @param categoria
	 * @param categoriaPadre
	 */
	public Categoria(CategoriaGuardadoModel categoria, Categoria categoriaPadre) {
		nombre = categoria.getNombre();
		tipo = categoria.getTipo();
		descripcion = categoria.getDescripcion();
		fechaGuardado = new Date();
		this.categoriaPadre = categoriaPadre;
	}
}
