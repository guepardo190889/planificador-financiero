package com.blackdeath.planificadorfinanciero.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blackdeath.planificadorfinanciero.entidades.Cuenta;
import com.blackdeath.planificadorfinanciero.modelos.CuentaGuardadoModel;
import com.blackdeath.planificadorfinanciero.modelos.CuentaModel;
import com.blackdeath.planificadorfinanciero.servicios.CuentasService;

import lombok.RequiredArgsConstructor;

/**
 * Controlador para {@link Cuenta}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RequiredArgsConstructor
@RequestMapping("/api/v1/cuentas")
@RestController
public class CuentasController {

	private final CuentasService service;

	/**
	 * Guarda una {@link Cuenta}
	 * 
	 * @param cuenta
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public CuentaModel guardar(@Valid @RequestBody CuentaGuardadoModel cuenta) {
		return service.guardar(cuenta);
	}

	/**
	 * Busca y devuelve un listado de todas las {@link Cuenta} guardadas
	 * 
	 * @return
	 */
	@GetMapping
	public List<CuentaModel> buscar() {
		return service.buscar();
	}
}
