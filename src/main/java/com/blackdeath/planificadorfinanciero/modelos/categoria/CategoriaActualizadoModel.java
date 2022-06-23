package com.blackdeath.planificadorfinanciero.modelos.categoria;

import javax.validation.constraints.NotEmpty;

import com.blackdeath.planificadorfinanciero.entidades.Categoria;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoCategoria;
import com.sun.istack.NotNull;

import lombok.Data;

/**
 * Modelo de datos que contiene los datos necearios para actualizar una
 * {@link Categoria}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-06-2022
 *
 */
@Data
public class CategoriaActualizadoModel {

	/**
	 * Nombre con el que se identifica esta categoría
	 */
	@NotNull
	@NotEmpty
	private String nombre;

	/**
	 * {@link TipoCategoria} que clasifica a esta categoría
	 */
	@NotNull
	private TipoCategoria tipo;

	/**
	 * Descripción de esta categoría
	 */
	private String descripcion;

}
