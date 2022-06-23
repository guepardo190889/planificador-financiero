package com.blackdeath.planificadorfinanciero.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.blackdeath.planificadorfinanciero.entidades.Categoria;
import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.blackdeath.planificadorfinanciero.modelos.categoria.CategoriaActualizadoModel;
import com.blackdeath.planificadorfinanciero.modelos.categoria.CategoriaGuardadoModel;
import com.blackdeath.planificadorfinanciero.repositorios.CategoriasRepository;
import com.blackdeath.planificadorfinanciero.utilidades.constantes.Mensajes;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaDuplicadaException;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaNoEncontradaException;

import lombok.RequiredArgsConstructor;

/**
 * Servicio para {@link Categoria}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@RequiredArgsConstructor
@Service
public class CategoriasService {

	private final CategoriasRepository repository;

	/**
	 * Guarda una nueva {@link Divisa}
	 * 
	 * @param categoriaGuardadoModel
	 * @return
	 */
	public Categoria guardar(CategoriaGuardadoModel categoriaGuardadoModel) {
		Categoria categoriaEncontrada = repository.findByNombre(categoriaGuardadoModel.getNombre());

		if (categoriaEncontrada != null) {
			throw new FilaDuplicadaException(Mensajes.GENERICO_REGISTRO_DUPLICADO);
		}

		return repository.save(new Categoria(categoriaGuardadoModel));
	}

	/**
	 * Actualiza una {@link Categoria} existente
	 * 
	 * @param id
	 * @param categoria
	 * @return
	 */
	public Categoria actualizar(Long id, CategoriaActualizadoModel categoria) {
		Optional<Categoria> categoriaEncontrada = buscarPorId(id);

		if (categoriaEncontrada.isPresent()) {
			Categoria categoriaConNombreCoincidente = repository.findByNombre(categoria.getNombre());

			if (categoriaConNombreCoincidente == null) {
				categoriaEncontrada.get().setNombre(categoria.getNombre());
				categoriaEncontrada.get().setTipo(categoria.getTipo());
				categoriaEncontrada.get().setDescripcion(categoria.getDescripcion());

				return repository.save(categoriaEncontrada.get());
			} else {
				throw new FilaDuplicadaException(Mensajes.GENERICO_REGISTRO_DUPLICADO);
			}
		} else {
			throw new FilaNoEncontradaException(Mensajes.GENERICO_REGISTRO_NO_ENCONTRADO);
		}
	}

	/**
	 * Devuelve una listado con todas las {@link Categoria}
	 * 
	 * @return
	 */
	public List<Categoria> buscarTodos() {
		return repository.findAllByOrderByNombreAsc();
	}

	/**
	 * Busca y devuelve una {@link Categoria} por su identificador único
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Categoria> buscarPorId(Long id) {
		return repository.findById(id);
	}

	/**
	 * Elimina una {@link Categoria}
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Categoria> eliminar(Long id) {
		Optional<Categoria> categoriaEncontrada = buscarPorId(id);

		if (categoriaEncontrada.isPresent()) {
			repository.deleteById(id);
		}

		return categoriaEncontrada;
	}

}
