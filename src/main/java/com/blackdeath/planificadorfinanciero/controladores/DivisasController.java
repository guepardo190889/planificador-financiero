package com.blackdeath.planificadorfinanciero.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.blackdeath.planificadorfinanciero.modelos.DivisaGuardadoModel;
import com.blackdeath.planificadorfinanciero.modelos.DivisaModel;
import com.blackdeath.planificadorfinanciero.servicios.DivisasService;

import lombok.RequiredArgsConstructor;

/**
 * Controlador para {@link Divisa}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@RequiredArgsConstructor
@RequestMapping("/divisas")
@RestController
public class DivisasController {

	private final DivisasService service;

	/**
	 * Guarda una {@link Divisa}
	 * 
	 * @param divisa
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public DivisaModel guardar(@Valid @RequestBody DivisaGuardadoModel divisa) {
		return service.guardar(divisa);
	}

	/**
	 * Busca y devuelve un listado de todas las {@link Divisa} guardadas
	 * 
	 * @return
	 */
	@GetMapping
	public List<DivisaModel> buscar() {
		return service.buscar();
	}
}
