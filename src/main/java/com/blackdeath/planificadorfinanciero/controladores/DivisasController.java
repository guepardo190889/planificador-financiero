package com.blackdeath.planificadorfinanciero.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.blackdeath.planificadorfinanciero.utilidades.constantes.Mensajes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * Controlador para {@link Divisa}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@Log4j2
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
	public ResponseEntity<?> buscarPorId(@NotNull @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			Optional<Divisa> divisaEncontrada = service.buscarPorId(id);

			if (!divisaEncontrada.isPresent()) {
				response.put("mensaje", Mensajes.DIVISA_NO_ENCONTRADA);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			response.put("mensaje", Mensajes.GENERICO_EXITO_CONSULTA);
			response.put("respuesta", new DivisaModel(divisaEncontrada.get()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (DataAccessException dae) {
			log.error(dae, dae);

			response.put("mensaje", Mensajes.GENERICO_ERROR_CONSULTA);
			response.put("error", dae.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
