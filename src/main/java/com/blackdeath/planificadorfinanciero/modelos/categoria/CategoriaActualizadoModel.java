package com.blackdeath.planificadorfinanciero.modelos.categoria;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.blackdeath.planificadorfinanciero.entidades.Categoria;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoCategoria;

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
	@NotNull(message = "Nombre es requerido")
	@NotEmpty(message = "Nombre no puede ser vacío")
	@Size(min = 1, max = 32, message = "Nombre requiere entre 1 y 32 caracteres")
	private String nombre;

	/**
	 * {@link TipoCategoria} que clasifica a esta categoría
	 */
	@NotNull(message = "Tipo de categoría es requerido")
	private TipoCategoria tipo;

	/**
	 * {@link Categoria} a la que pertenece esta categoría
	 */
	@Min(value = 1, message = "Identificador único de categoría debe ser positivo")
	private Long categoriaId;

	/**
	 * Descripción de esta categoría
	 */
	@Size(max = 128, message = "Descripción debe ser de máximo 128 caracteres")
	private String descripcion;

	/**
	 * Verifica si el {@code nombre} que se va a actualizar para esta categoría es
	 * diferente al nombre actual. Si los nombres son iguales se devuelve
	 * {@code false}, de lo contrario {@code true}
	 * <p>
	 * 
	 * @param nombreActual
	 * @return {@code true} si el nombre es nuevo, de lo contrario {@code false}
	 */
	public boolean isNombreNuevo(String nombreActual) {
		return !nombre.equals(nombreActual);
	}

}
