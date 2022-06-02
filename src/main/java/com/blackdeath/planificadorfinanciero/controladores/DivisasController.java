package com.blackdeath.planificadorfinanciero.controladores;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin(origins = { "http://localhost:4200" })
@RequiredArgsConstructor
@RequestMapping("/api/v1/divisas")
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

	/**
	 * Busca y devuelve una {@link Divisa} por su id.
	 * <p>
	 * En caso que no se encuentre se devuelve un {@link HttpStatus#NOT_FOUND}
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public DivisaModel buscarPorId(@NotNull @PathVariable Long id) {
		return service.buscarPorId(id);
	}
}
