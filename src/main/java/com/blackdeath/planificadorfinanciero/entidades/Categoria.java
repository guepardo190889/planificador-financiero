package com.blackdeath.planificadorfinanciero.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blackdeath.planificadorfinanciero.enumeradores.TipoCategoria;
import com.blackdeath.planificadorfinanciero.modelos.CategoriaGuardadoModel;

import lombok.Data;

/**
 * Categoría que sirve para clasificar a un {@link Movimiento}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@Data
@Table(name = "categorias")
@Entity
public class Categoria {

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
	@Column(unique = false, nullable = false, updatable = false, length = 7)
	private TipoCategoria tipo;

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
	 */
	public Categoria(CategoriaGuardadoModel categoria) {
		nombre = categoria.getNombre();
		tipo = categoria.getTipo();
		descripcion = categoria.getDescripcion();
		fechaGuardado = new Date();
	}
}
