package com.blackdeath.planificadorfinanciero.controladores;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackdeath.planificadorfinanciero.entidades.Movimiento;
import com.blackdeath.planificadorfinanciero.modelos.movimiento.MovimientoGuardadoModel;
import com.blackdeath.planificadorfinanciero.modelos.movimiento.MovimientoModel;
import com.blackdeath.planificadorfinanciero.servicios.MovimientosService;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.LlaveRespuesta;
import com.blackdeath.planificadorfinanciero.utilidades.constantes.Mensajes;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaDuplicadaException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * Controlador para {@link Movimiento}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-06-2022
 *
 */
@Log4j2
@CrossOrigin(origins = { "http://localhost:4200" })
@RequiredArgsConstructor
@RequestMapping("/api/v1/movimiento")
@RestController
public class MovimientosController {

	private final MovimientosService service;

	/**
	 * Guarda un {@link Movimiento}
	 * 
	 * @param movimiento
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> guardar(@NotNull @Valid @RequestBody MovimientoGuardadoModel movimiento,
			BindingResult bindingResult) {
		Map<String, Object> response = new HashMap<>();

		if (bindingResult.hasErrors()) {
			List<String> errores = bindingResult.getFieldErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());

			response.put(LlaveRespuesta.ERRORES, errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			Movimiento movimientoGuardado = service.guardar(movimiento);

			return new ResponseEntity<MovimientoModel>(new MovimientoModel(movimientoGuardado), HttpStatus.CREATED);
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

}
