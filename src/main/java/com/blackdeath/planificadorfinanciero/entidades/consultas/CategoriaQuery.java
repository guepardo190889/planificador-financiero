package com.blackdeath.planificadorfinanciero.entidades.consultas;

import com.blackdeath.planificadorfinanciero.entidades.Categoria;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoCategoria;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase que representa una {@link Categoria} con los datos necesarios para ser
 * listados de forma jerárquica
 * 
 * @author Seth Karim Luis Martínez
 * @since 04-07-2022
 *
 */
@AllArgsConstructor
@Data
public class CategoriaQuery {

	private Long id;
	private String nombre;
	private TipoCategoria tipo;
	private String descripcion;
	private Long categoriaPadreId;

}
