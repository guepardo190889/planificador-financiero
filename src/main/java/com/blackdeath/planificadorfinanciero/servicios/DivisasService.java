package com.blackdeath.planificadorfinanciero.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.blackdeath.planificadorfinanciero.modelos.divisa.DivisaActualizadoModel;
import com.blackdeath.planificadorfinanciero.modelos.divisa.DivisaGuardadoModel;
import com.blackdeath.planificadorfinanciero.repositorios.DivisasRepository;
import com.blackdeath.planificadorfinanciero.utilidades.constantes.Mensajes;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaDuplicadaException;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaNoEncontradaException;

import lombok.RequiredArgsConstructor;

/**
 * Servicio para {@link Divisa}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@RequiredArgsConstructor
@Service
public class DivisasService {

	private final DivisasRepository repository;

	/**
	 * Guarda una nueva {@link Divisa}
	 * 
	 * @param divisaGuardadoModel
	 * @return
	 */
	public Divisa guardar(DivisaGuardadoModel divisaGuardadoModel) {
		Divisa divisaEncontrada = repository.findByCodigo(divisaGuardadoModel.getCodigo());

		if (divisaEncontrada != null) {
			throw new FilaDuplicadaException(Mensajes.GENERICO_REGISTRO_DUPLICADO);
		}

		Divisa divisaGuardada = repository.save(new Divisa(divisaGuardadoModel));

		if (divisaGuardada.getPorDefecto()) {
			repository.actualizarPorDefectoFalsoExcepto(divisaGuardada.getId());
		}

		return divisaGuardada;
	}

	/**
	 * Actualiza una {@link Divisa} existente
	 * 
	 * @param id
	 * @param divisa
	 * @return
	 */
	public Divisa actualizar(Long id, DivisaActualizadoModel divisa) {
		Optional<Divisa> divisaEncontrada = buscarPorId(id);

		if (divisaEncontrada.isPresent()) {
			Divisa divisaConCodigoCoincidente = repository.findByCodigo(divisa.getCodigo());

			if (divisaConCodigoCoincidente == null) {
				divisaEncontrada.get().setNombre(divisa.getNombre());
				divisaEncontrada.get().setCodigo(divisa.getCodigo());
				divisaEncontrada.get().setPorDefecto(divisa.getPorDefecto());

				Divisa divisaGuardada = repository.save(divisaEncontrada.get());

				if (divisaGuardada.getPorDefecto()) {
					repository.actualizarPorDefectoFalsoExcepto(divisaGuardada.getId());
				}

				return divisaGuardada;
			} else {
				throw new FilaDuplicadaException(Mensajes.GENERICO_REGISTRO_DUPLICADO);
			}
		} else {
			throw new FilaNoEncontradaException(Mensajes.GENERICO_REGISTRO_NO_ENCONTRADO);
		}
	}

	/**
	 * Busca y devuelve un listado con todas las divisas
	 * 
	 * @return
	 */
	public List<Divisa> buscarTodos() {
		return repository.findAllByOrderByNombreAsc();
	}

	/**
	 * Busca y devuelve una divisa por su identificador único
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Divisa> buscarPorId(Long id) {
		return repository.findById(id);
	}

	/**
	 * Elimina una {@link Divisa}
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Divisa> eliminar(Long id) {
		Optional<Divisa> divisaEncontrada = buscarPorId(id);

		if (divisaEncontrada.isPresent()) {
			repository.deleteById(id);
		}

		return divisaEncontrada;
	}

}
