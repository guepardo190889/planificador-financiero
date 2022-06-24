package com.blackdeath.planificadorfinanciero.modelos.tipocategoria;

import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoCategoria;

import lombok.Data;

/**
 * Modelo que respresenta un {@link TipoCategoria}
 * 
 * @author Seth Karim Luis Martínez
 * @since 24-06-2022
 *
 */
@Data
public class TipoCategoriaModel {

	/**
	 * {@code name} de este tipo de entidad financiera
	 */
	private String nombre;

	/**
	 * Descripción de este tipo de entidad financiera
	 */
	private String descripcion;

	/**
	 * Constructor que inicializa los campos a partir de u {@link TipoCategoria}
	 * 
	 * @param tipoEntidadFinanciera
	 */
	public TipoCategoriaModel(TipoCategoria tipoCategoria) {
		nombre = tipoCategoria.name();
		descripcion = tipoCategoria.getDescripcion();
	}
}
