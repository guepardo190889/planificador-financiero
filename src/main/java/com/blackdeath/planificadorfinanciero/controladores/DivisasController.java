package com.blackdeath.planificadorfinanciero.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.blackdeath.planificadorfinanciero.modelos.divisa.DivisaActualizadoModel;
import com.blackdeath.planificadorfinanciero.modelos.divisa.DivisaGuardadoModel;
import com.blackdeath.planificadorfinanciero.modelos.divisa.DivisaModel;
import com.blackdeath.planificadorfinanciero.servicios.DivisasService;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.LlaveRespuesta;
import com.blackdeath.planificadorfinanciero.utilidades.constantes.Mensajes;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaDuplicadaException;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaNoEncontradaException;

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
	@PostMapping
	public ResponseEntity<?> guardar(@NotNull @Valid @RequestBody DivisaGuardadoModel divisa,
			BindingResult bindingResult) {
		Map<String, Object> response = new HashMap<>();

		if (bindingResult.hasErrors()) {
			List<String> errores = bindingResult.getFieldErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());

			response.put(LlaveRespuesta.ERROR, errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			Divisa divisaGuardada = service.guardar(divisa);

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_EXITO_GUARDADO);
			response.put(LlaveRespuesta.DIVISA_INDIVIDUAL, new DivisaModel(divisaGuardada));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (DataAccessException dae) {
			log.error(dae, dae);

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_ERROR_GUARDADO);
			response.put(LlaveRespuesta.ERROR, dae.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (FilaDuplicadaException fde) {
			log.error(fde, fde);

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_REGISTRO_DUPLICADO);
			response.put(LlaveRespuesta.ERROR, fde.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
		}
	}

	/**
	 * Actualiza una {@link Divisa}
	 * 
	 * @param divisa
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@NotNull @PathVariable Long id,
			@NotNull @Valid @RequestBody DivisaActualizadoModel divisa) {
		Map<String, Object> response = new HashMap<>();

		try {
			Divisa divisaActualizada = service.actualizar(id, divisa);

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_EXITO_ACTUALIZADO);
			response.put(LlaveRespuesta.DIVISA_INDIVIDUAL, new DivisaModel(divisaActualizada));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (DataAccessException dae) {
			log.error(dae, dae);

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_ERROR_ACTUALIZADO);
			response.put(LlaveRespuesta.ERROR, dae.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (FilaNoEncontradaException fnee) {
			log.error(fnee, fnee);

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_REGISTRO_NO_ENCONTRADO);
			response.put(LlaveRespuesta.ERROR, fnee.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Elimina una {@link Divisa}
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@NotNull @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			Optional<Divisa> divisaEliminada = service.eliminar(id);

			if (divisaEliminada.isPresent()) {
				response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_EXITO_ELIMINADO);
				response.put(LlaveRespuesta.DIVISA_INDIVIDUAL, new DivisaModel(divisaEliminada.get()));

				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			} else {
				response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_REGISTRO_NO_ENCONTRADO);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException dae) {
			log.error(dae, dae);

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_ERROR_ELIMINADO);
			response.put(LlaveRespuesta.ERROR, dae.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Busca y devuelve un listado de todas las {@link Divisa} guardadas
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> buscarTodos() {
		Map<String, Object> response = new HashMap<>();

		try {
			List<Divisa> divisasEncontradas = service.buscarTodos();

			List<DivisaModel> modelos = new ArrayList<>();

			for (Divisa divisaEncontrada : divisasEncontradas) {
				modelos.add(new DivisaModel(divisaEncontrada));
			}

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_EXITO_CONSULTA);
			response.put(LlaveRespuesta.DIVISA_MULTIPLE, modelos);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		} catch (DataAccessException dae) {
			log.error(dae, dae);

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_ERROR_CONSULTA);
			response.put(LlaveRespuesta.ERROR, dae.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Busca una {@link Divisa} por su id.
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
				response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_REGISTRO_NO_ENCONTRADO);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_EXITO_CONSULTA);
			response.put(LlaveRespuesta.DIVISA_INDIVIDUAL, new DivisaModel(divisaEncontrada.get()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (DataAccessException dae) {
			log.error(dae, dae);

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_ERROR_CONSULTA);
			response.put(LlaveRespuesta.ERROR, dae.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
