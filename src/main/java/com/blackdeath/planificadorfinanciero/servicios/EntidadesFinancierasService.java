package com.blackdeath.planificadorfinanciero.servicios;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
	 * @param cuentaGuardadoModel
	 * @return
	 */
	public EntidadFinanciera guardar(EntidadFinancieraGuardadoModel entidadFinancieraGuardadoModel) {
		EntidadFinanciera entidadFinancieraEncontrada = repository
				.findByNombre(entidadFinancieraGuardadoModel.getNombre());

		if (entidadFinancieraEncontrada != null) {
			throw new FilaDuplicadaException(Mensajes.GENERICO_REGISTRO_DUPLICADO);
		}

		return repository.save(new EntidadFinanciera(entidadFinancieraGuardadoModel));
	}

	/**
	 * Actualiza una {@link EntidadFinanciera} existente
	 * 
	 * @param id
	 * @param entidadFinanciera
	 * @return
	 */
	public EntidadFinanciera actualizar(@NotNull Long id,
			@NotNull @Valid EntidadFinancieraActualizadoModel entidadFinanciera) {
		Optional<EntidadFinanciera> entidadFinancieraEncontrada = buscarPorId(id);

		if (entidadFinancieraEncontrada.isPresent()) {
			EntidadFinanciera entidadFinancieraConNombreCoincidente = repository
					.findByNombre(entidadFinanciera.getNombre());

			if (entidadFinancieraConNombreCoincidente == null) {
				entidadFinancieraEncontrada.get().setNombre(entidadFinanciera.getNombre());
				entidadFinancieraEncontrada.get().setDescripcion(entidadFinanciera.getDescripcion());
				entidadFinancieraEncontrada.get().setTipo(entidadFinanciera.getTipo());

				return repository.save(entidadFinancieraEncontrada.get());
			} else {
				throw new FilaDuplicadaException(Mensajes.GENERICO_REGISTRO_DUPLICADO);
			}
		} else {
			throw new FilaNoEncontradaException(Mensajes.GENERICO_REGISTRO_NO_ENCONTRADO);
		}
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
