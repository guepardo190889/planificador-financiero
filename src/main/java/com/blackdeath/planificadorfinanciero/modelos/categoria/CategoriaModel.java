package com.blackdeath.planificadorfinanciero.modelos.categoria;

import com.blackdeath.planificadorfinanciero.entidades.Categoria;
import com.blackdeath.planificadorfinanciero.modelos.tipocategoria.TipoCategoriaModel;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoCategoria;

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
	 * Representación del {@link TipoCategoria} que clasifica a esta categoría
	 */
	private TipoCategoriaModel tipo;

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
		tipo = new TipoCategoriaModel(categoria.getTipo());
		descripcion = categoria.getDescripcion();
	}
}
