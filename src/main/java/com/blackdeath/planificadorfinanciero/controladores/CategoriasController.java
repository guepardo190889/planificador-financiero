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

import com.blackdeath.planificadorfinanciero.entidades.Categoria;
import com.blackdeath.planificadorfinanciero.modelos.CategoriaGuardadoModel;
import com.blackdeath.planificadorfinanciero.modelos.CategoriaModel;
import com.blackdeath.planificadorfinanciero.servicios.CategoriasService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/categorias")
@RestController
public class CategoriasController {

	private final CategoriasService service;

	/**
	 * Guarda una {@link Categoria}
	 * 
	 * @param categoria
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public CategoriaModel guardar(@Valid @RequestBody CategoriaGuardadoModel categoria) {
		return service.guardar(categoria);
	}

	/**
	 * Busca y devuelve un listado de todas las {@link Categoria} guardadas
	 * 
	 * @return
	 */
	@GetMapping
	public List<CategoriaModel> buscar() {
		return service.buscar();
	}
}
