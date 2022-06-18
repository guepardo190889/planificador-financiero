package com.blackdeath.planificadorfinanciero.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackdeath.planificadorfinanciero.modelos.tipoentidadfinanciera.TipoEntidadFinancieraModel;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoEntidadFinanciera;

/**
 * Controlador para {@link TipoEntidadFinanciera}
 * 
 * @author Seth Karim Luis Martínez
 * @since 17-06-2022
 *
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api/v1/tipos-entidades-financieras")
@RestController
public class TiposEntidadesFinancierasController {

	/**
	 * Busca y devuelve un listado de todas las {@link TipoEntidadFinanciera}
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> buscarTodos() {
		List<TipoEntidadFinancieraModel> tiposEntidadesFinancieras = new ArrayList<>();

		for (TipoEntidadFinanciera tipoEntidadFinanciera : TipoEntidadFinanciera.values()) {
			tiposEntidadesFinancieras.add(new TipoEntidadFinancieraModel(tipoEntidadFinanciera));
		}

		return new ResponseEntity<List<TipoEntidadFinancieraModel>>(tiposEntidadesFinancieras, HttpStatus.OK);
	}
}
