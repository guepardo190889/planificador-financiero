/**
 * 
 */
package com.blackdeath.planificadorfinanciero.modelos;

import javax.validation.constraints.NotEmpty;

import com.blackdeath.planificadorfinanciero.entidades.Categoria;
import com.blackdeath.planificadorfinanciero.enums.TipoCategoria;
import com.sun.istack.NotNull;

import lombok.Data;

/**
 * Modelo de datos que contiene los datos necesarios para guardar una
 * {@link Categoria}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@Data
public class CategoriaGuardadoModel {

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
