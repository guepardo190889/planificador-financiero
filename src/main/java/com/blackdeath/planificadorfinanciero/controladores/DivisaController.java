package com.blackdeath.planificadorfinanciero.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.blackdeath.planificadorfinanciero.modelos.DivisaModel;
import com.blackdeath.planificadorfinanciero.servicios.DivisaService;

import lombok.RequiredArgsConstructor;

/**
 * Controlador para {@link Divisa}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@RequiredArgsConstructor
@RestController("/divisas")
public class DivisaController {

	private final DivisaService service;

	@GetMapping
	public List<DivisaModel> buscar() {
		return service.buscar();
	}
}
