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

import com.blackdeath.planificadorfinanciero.entidades.Categoria;
import com.blackdeath.planificadorfinanciero.modelos.categoria.CategoriaActualizadoModel;
import com.blackdeath.planificadorfinanciero.modelos.categoria.CategoriaGuardadoModel;
import com.blackdeath.planificadorfinanciero.modelos.categoria.CategoriaModel;
import com.blackdeath.planificadorfinanciero.servicios.CategoriasService;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.LlaveRespuesta;
import com.blackdeath.planificadorfinanciero.utilidades.constantes.Mensajes;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaDuplicadaException;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaNoEncontradaException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * Controlador para {@link Categoria}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-06-2022
 *
 */
@Log4j2
@CrossOrigin(origins = { "http://localhost:4200" })
@RequiredArgsConstructor
@RequestMapping("/api/v1/categorias")
@RestController
public class CategoriasController {

	private final CategoriasService service;

	/**
	 * Guarda una {@link Categoria}
	 * 
	 * @param categoria
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> guardar(@NotNull @Valid @RequestBody CategoriaGuardadoModel categoria,
			BindingResult bindingResult) {
		Map<String, Object> response = new HashMap<>();

		if (bindingResult.hasErrors()) {
			List<String> errores = bindingResult.getFieldErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());

			response.put(LlaveRespuesta.ERRORES, errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			Categoria categoriaGuardada = service.guardar(categoria);

			return new ResponseEntity<CategoriaModel>(new CategoriaModel(categoriaGuardada), HttpStatus.CREATED);
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
	 * Actualiza una {@link Categoria}
	 * 
	 * @param categoria
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@NotNull @PathVariable Long id,
			@NotNull @Valid @RequestBody CategoriaActualizadoModel categoria, BindingResult bindingResult) {
		Map<String, Object> response = new HashMap<>();

		if (bindingResult.hasErrors()) {
			List<String> errores = bindingResult.getFieldErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());

			response.put(LlaveRespuesta.ERRORES, errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			Categoria categoriaActualizada = service.actualizar(id, categoria);

			return new ResponseEntity<CategoriaModel>(new CategoriaModel(categoriaActualizada), HttpStatus.OK);
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
	 * Elimina una {@link Categoria}
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@NotNull @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			Optional<Categoria> categoriaEliminada = service.eliminar(id);

			if (categoriaEliminada.isPresent()) {
				return new ResponseEntity<CategoriaModel>(new CategoriaModel(categoriaEliminada.get()), HttpStatus.OK);
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
	 * Busca y devuelve un listado de todas las {@link Categoria} guardadas
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> buscarTodos() {
		try {
			List<Categoria> categoriasEncontradas = service.buscarTodos();

			List<CategoriaModel> modelos = new ArrayList<>();

			for (Categoria categoriaEncontrada : categoriasEncontradas) {
				modelos.add(new CategoriaModel(categoriaEncontrada));
			}

			return new ResponseEntity<List<CategoriaModel>>(modelos, HttpStatus.OK);

		} catch (DataAccessException dae) {
			log.error(dae, dae);

			Map<String, Object> response = new HashMap<>();

			response.put(LlaveRespuesta.ERROR, Mensajes.GENERICO_ERROR_CONSULTA);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Busca una {@link Categoria} por su id.
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
			Optional<Categoria> categoriaEncontrada = service.buscarPorId(id);

			if (categoriaEncontrada.isPresent()) {
				return new ResponseEntity<CategoriaModel>(new CategoriaModel(categoriaEncontrada.get()), HttpStatus.OK);
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
