package com.blackdeath.planificadorfinanciero.controladores;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.blackdeath.planificadorfinanciero.entidades.EntidadFinanciera;
import com.blackdeath.planificadorfinanciero.modelos.entidadfinanciera.EntidadFinancieraActualizadoModel;
import com.blackdeath.planificadorfinanciero.modelos.entidadfinanciera.EntidadFinancieraGuardadoModel;
import com.blackdeath.planificadorfinanciero.modelos.entidadfinanciera.EntidadFinancieraModel;
import com.blackdeath.planificadorfinanciero.servicios.EntidadesFinancierasService;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.LlaveRespuesta;
import com.blackdeath.planificadorfinanciero.utilidades.constantes.Mensajes;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaDuplicadaException;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaNoEncontradaException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * Controlador para {@link EntidadFinanciera}
 * 
 * @author Seth Karim Luis Martínez
 * @since 12-06-2022
 *
 */
@Log4j2
@CrossOrigin(origins = { "http://localhost:4200" })
@RequiredArgsConstructor
@RequestMapping("/api/v1/entidades-financieras")
@RestController
public class EntidadesFinancierasController {

	private final EntidadesFinancierasService service;

	/**
	 * Guarda una {@link EntidadFinanciera}
	 * 
	 * @param entidadFinanciera
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> guardar(@NotNull @Valid @RequestBody EntidadFinancieraGuardadoModel entidadFinanciera,
			BindingResult bindingResult) {
		Map<String, Object> response = new HashMap<>();

		if (bindingResult.hasErrors()) {
			List<String> errores = bindingResult.getFieldErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());

			response.put(LlaveRespuesta.ERRORES, errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			EntidadFinanciera entidadFinancieraGuardada = service.guardar(entidadFinanciera);

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_EXITO_GUARDADO);
			response.put(LlaveRespuesta.ENTIDAD_FINANCIERA_INDIVIDUAL,
					new EntidadFinancieraModel(entidadFinancieraGuardada));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

		} catch (DataAccessException dae) {
			log.error(dae, dae);

			response.put(LlaveRespuesta.ERROR, Mensajes.GENERICO_ERROR_GUARDADO);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (FilaDuplicadaException fde) {
			log.error(fde, fde);

			response.put(LlaveRespuesta.ERRORES, Arrays.asList(fde.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
		}
	}

	/**
	 * Actualiza una {@link EntidadFinanciera}
	 * 
	 * @param entidadFinanciera
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@NotNull @PathVariable Long id,
			@NotNull @Valid @RequestBody EntidadFinancieraActualizadoModel entidadFinanciera,
			BindingResult bindingResult) {
		Map<String, Object> response = new HashMap<>();

		if (bindingResult.hasErrors()) {
			List<String> errores = bindingResult.getFieldErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());

			response.put(LlaveRespuesta.ERRORES, errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			EntidadFinanciera entidadFinancieraActualizada = service.actualizar(id, entidadFinanciera);

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_EXITO_ACTUALIZADO);
			response.put(LlaveRespuesta.ENTIDAD_FINANCIERA_INDIVIDUAL,
					new EntidadFinancieraModel(entidadFinancieraActualizada));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (DataAccessException dae) {
			log.error(dae, dae);

			response.put(LlaveRespuesta.ERROR, Mensajes.GENERICO_ERROR_ACTUALIZADO);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (FilaNoEncontradaException fnee) {
			log.error(fnee, fnee);

			response.put(LlaveRespuesta.ERROR, fnee.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		} catch (FilaDuplicadaException fde) {
			log.error(fde, fde);

			response.put(LlaveRespuesta.ERRORES, Arrays.asList(fde.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
		}
	}

	/**
	 * Elimina una {@link EntidadFinanciera}
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@NotNull @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			Optional<EntidadFinanciera> entidadFinancieraEliminada = service.eliminar(id);

			if (entidadFinancieraEliminada.isPresent()) {
				response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_EXITO_ELIMINADO);
				response.put(LlaveRespuesta.ENTIDAD_FINANCIERA_INDIVIDUAL,
						new EntidadFinancieraModel(entidadFinancieraEliminada.get()));

				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			} else {
				response.put(LlaveRespuesta.ERROR, Mensajes.GENERICO_REGISTRO_NO_ENCONTRADO);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException dae) {
			log.error(dae, dae);

			response.put(LlaveRespuesta.ERROR, Mensajes.GENERICO_ERROR_ELIMINADO);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Busca y devuelve un listado de todas las {@link EntidadFinanciera} guardadas
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> buscarTodos() {
		Map<String, Object> response = new HashMap<>();

		try {
			List<EntidadFinanciera> entidadesFinancierasEncontradas = service.buscarTodos();

			List<EntidadFinancieraModel> modelos = new ArrayList<>();

			for (EntidadFinanciera entidadFinancieraEncontrada : entidadesFinancierasEncontradas) {
				modelos.add(new EntidadFinancieraModel(entidadFinancieraEncontrada));
			}

			response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_EXITO_CONSULTA);
			response.put(LlaveRespuesta.ENTIDAD_FINANCIERA_MULTIPLE, modelos);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		} catch (DataAccessException dae) {
			log.error(dae, dae);

			response.put(LlaveRespuesta.ERROR, Mensajes.GENERICO_ERROR_CONSULTA);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Busca una {@link EntidadFinanciera} por su id.
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
			Optional<EntidadFinanciera> entidadFinancieraEncontrada = service.buscarPorId(id);

			if (entidadFinancieraEncontrada.isPresent()) {
				response.put(LlaveRespuesta.MENSAJE, Mensajes.GENERICO_EXITO_CONSULTA);
				response.put(LlaveRespuesta.ENTIDAD_FINANCIERA_INDIVIDUAL,
						new EntidadFinancieraModel(entidadFinancieraEncontrada.get()));

				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			} else {
				response.put(LlaveRespuesta.ERROR, Mensajes.GENERICO_REGISTRO_NO_ENCONTRADO);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException dae) {
			log.error(dae, dae);

			response.put(LlaveRespuesta.ERROR, Mensajes.GENERICO_ERROR_CONSULTA);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
