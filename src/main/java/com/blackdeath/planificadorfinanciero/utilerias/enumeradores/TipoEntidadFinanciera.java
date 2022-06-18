package com.blackdeath.planificadorfinanciero.utilerias.enumeradores;

import java.util.ArrayList;
import java.util.List;

import com.blackdeath.planificadorfinanciero.entidades.EntidadFinanciera;

import lombok.Getter;

/**
 * Tipo, clasificación o categoría de una {@link EntidadFinanciera}
 * <p>
 * Debe ser alguna de las listadas en el <a href=
 * "https://www.gob.mx/shcp/documentos/catalogo-del-sistema-financiero-mexicano">Catálogo
 * del Sistema Financiero Mexicano</>
 * 
 * @author Seth Karim Luis Martínez
 * @since 12-06-2022
 *
 */
@Getter
public enum TipoEntidadFinanciera {
	CASA_BOLSA("Casa de Bolsa"), SOCIEDAD_FINANCIERA_POPULAR("Sociedad Financiera Popular (SOFIPO)"),
	INSTITUCION_BANCA_MULTIPLE("Institución de Banca Múltiple (banco)"),
	ADMINISTRADORA_FONDOS_RETIRO("Administradora de Fondos para el Retiro (AFORE)"),
	INSTITUCION_TECNOLOGIA_FINANCIERA("Institución de Tecnología Financiera (Fintech)");

	/**
	 * Descripción de este tipo de entidad financiera
	 */
	private String descripcion;

	private TipoEntidadFinanciera(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve una lista con las descripciones de todos los tipos de entidades
	 * financieras
	 * 
	 * @return
	 */
	public static List<String> elementos() {
		List<String> tipos = new ArrayList<>();
		for (TipoEntidadFinanciera tipo : values()) {
			tipos.add(tipo.getDescripcion());
		}

		return tipos;
	}
}
