package com.blackdeath.planificadorfinanciero.modelos;

import com.blackdeath.planificadorfinanciero.entidades.Categoria;
import com.blackdeath.planificadorfinanciero.enums.TipoCategoria;

import lombok.Data;

/**
 * Modelo de datos para una {@link Categoria}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@Data
public class CategoriaModel {

	/**
	 * Identificador único de esta categoría
	 */
	private Long id;

	/**
	 * Nombre con el que se identifica esta categoría
	 */
	private String nombre;

	/**
	 * {@link TipoCategoria} que clasifica a esta categoría
	 */
	private TipoCategoria tipo;

	/**
	 * Descripción de esta categoría
	 */
	private String descripcion;

	/**
	 * Constructor que inicializa campos a partir de una {@link Categoria}
	 * 
	 * @param categoria
	 */
	public CategoriaModel(Categoria categoria) {
		id = categoria.getId();
		nombre = categoria.getNombre();
		tipo = categoria.getTipo();
		descripcion = categoria.getDescripcion();
	}
}
