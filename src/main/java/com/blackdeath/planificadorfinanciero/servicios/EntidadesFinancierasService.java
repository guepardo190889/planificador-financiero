package com.blackdeath.planificadorfinanciero.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.blackdeath.planificadorfinanciero.entidades.EntidadFinanciera;
import com.blackdeath.planificadorfinanciero.modelos.entidadfinanciera.EntidadFinancieraActualizadoModel;
import com.blackdeath.planificadorfinanciero.modelos.entidadfinanciera.EntidadFinancieraGuardadoModel;
import com.blackdeath.planificadorfinanciero.repositorios.EntidadesFinancierasRepository;
import com.blackdeath.planificadorfinanciero.utilidades.constantes.Mensajes;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaDuplicadaException;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaNoEncontradaException;

import lombok.RequiredArgsConstructor;

/**
 * Servicio para {@link EntidadFinanciera}
 * 
 * @author Seth Karim Luis Martínez
 * @since 12-06-2022
 *
 */
@RequiredArgsConstructor
@Service
public class EntidadesFinancierasService {

	private final EntidadesFinancierasRepository repository;

	/**
	 * Guarda una nueva {@link EntidadFinanciera}
	 * 
	 * @param entidadFinancieraGuardadoModel
	 * @return
	 */
	public EntidadFinanciera guardar(EntidadFinancieraGuardadoModel entidadFinancieraGuardadoModel) {
		EntidadFinanciera entidadFinancieraEncontrada = repository.findByNombreAndTipo(
				entidadFinancieraGuardadoModel.getNombre(), entidadFinancieraGuardadoModel.getTipo());

		if (entidadFinancieraEncontrada != null) {
			throw new FilaDuplicadaException(Mensajes.GENERICO_REGISTRO_DUPLICADO);
		}

		return repository.save(new EntidadFinanciera(entidadFinancieraGuardadoModel));
	}

	/**
	 * Actualiza una {@link EntidadFinanciera} existente
	 * 
	 * @param id
	 * @param entidadFinancieraActualizadoModel
	 * @return
	 */
	public EntidadFinanciera actualizar(Long id, EntidadFinancieraActualizadoModel entidadFinancieraActualizadoModel) {
		Optional<EntidadFinanciera> entidadFinancieraEncontrada = buscarPorId(id);

		if (entidadFinancieraEncontrada.isPresent()) {
			if (entidadFinancieraActualizadoModel.isNombreNuevo(entidadFinancieraEncontrada.get().getNombre())) {
				EntidadFinanciera entidadFinancieraConNombreCoincidente = repository.findByNombreAndTipo(
						entidadFinancieraActualizadoModel.getNombre(), entidadFinancieraActualizadoModel.getTipo());

				if (entidadFinancieraConNombreCoincidente != null) {
					throw new FilaDuplicadaException(Mensajes.GENERICO_REGISTRO_DUPLICADO);
				}
			}

			entidadFinancieraEncontrada.get().setNombre(entidadFinancieraActualizadoModel.getNombre());
			entidadFinancieraEncontrada.get().setTipo(entidadFinancieraActualizadoModel.getTipo());

			return repository.save(entidadFinancieraEncontrada.get());
		} else {
			throw new FilaNoEncontradaException(Mensajes.GENERICO_REGISTRO_NO_ENCONTRADO);
		}
	}

	/**
	 * Elimina una {@link EntidadFinanciera}
	 * 
	 * @param id
	 * @return
	 */
	public Optional<EntidadFinanciera> eliminar(Long id) {
		Optional<EntidadFinanciera> entidadFinancieraEncontrada = buscarPorId(id);

		if (entidadFinancieraEncontrada.isPresent()) {
			repository.deleteById(id);
		}

		return entidadFinancieraEncontrada;
	}

	/**
	 * Busca y devuelve un listado de todas las {@link EntidadFinanciera}
	 * 
	 * @return
	 */
	public List<EntidadFinanciera> buscarTodos() {
		return repository.findAllByOrderByNombreAscTipoAsc();
	}

	/**
	 * Busca y devuelve una {@link EntidadFinanciera} por su identificador único
	 * 
	 * @param id
	 * @return
	 */
	public Optional<EntidadFinanciera> buscarPorId(Long id) {
		return repository.findById(id);
	}

}
