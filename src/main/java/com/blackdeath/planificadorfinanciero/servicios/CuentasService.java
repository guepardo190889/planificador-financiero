package com.blackdeath.planificadorfinanciero.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blackdeath.planificadorfinanciero.entidades.Cuenta;
import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.blackdeath.planificadorfinanciero.entidades.EntidadFinanciera;
import com.blackdeath.planificadorfinanciero.modelos.cuenta.CuentaActualizadoModel;
import com.blackdeath.planificadorfinanciero.modelos.cuenta.CuentaGuardadoModel;
import com.blackdeath.planificadorfinanciero.repositorios.CuentasRepository;
import com.blackdeath.planificadorfinanciero.repositorios.DivisasRepository;
import com.blackdeath.planificadorfinanciero.repositorios.EntidadesFinancierasRepository;
import com.blackdeath.planificadorfinanciero.utilidades.constantes.Mensajes;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaDuplicadaException;
import com.blackdeath.planificadorfinanciero.utilidades.excepciones.db.FilaNoEncontradaException;

import lombok.RequiredArgsConstructor;

/**
 * Servicio para {@link Cuenta}
 * 
 * @author Seth Karim Luis Martínez
 * @since 24-05-2022
 *
 */
@RequiredArgsConstructor
@Service
public class CuentasService {

	private final CuentasRepository repository;
	private final DivisasRepository divisaRepository;
	private final EntidadesFinancierasRepository entidadFinancieraRepository;

	/**
	 * Guarda una nueva {@link Cuenta}
	 * 
	 * @param cuentaGuardadoModel
	 * @return
	 */
	@Transactional
	public Cuenta guardar(CuentaGuardadoModel cuentaGuardadoModel) {
		Cuenta cuentaEncontrada = repository.findByNombre(cuentaGuardadoModel.getNombre());

		if (cuentaEncontrada != null) {
			throw new FilaDuplicadaException(Mensajes.GENERICO_REGISTRO_DUPLICADO);
		}

		Divisa divisa = divisaRepository.getReferenceById(cuentaGuardadoModel.getDivisaId());
		EntidadFinanciera entidadFinanciera = cuentaGuardadoModel.getEntidadFinancieraId() != null
				? entidadFinancieraRepository.getReferenceById(cuentaGuardadoModel.getEntidadFinancieraId())
				: null;

		Cuenta cuentaGuardada = repository.save(new Cuenta(cuentaGuardadoModel, divisa, entidadFinanciera));

		if (cuentaGuardada.getPorDefecto()) {
			repository.hacerPorDefecto(cuentaGuardada.getId());
		}

		return buscarPorId(cuentaGuardada.getId()).get();
	}

	/**
	 * Actualiza una {@link Cuenta} existente
	 * 
	 * @param id
	 * @param cuenta
	 * @return
	 */
	public Cuenta actualizar(Long id, CuentaActualizadoModel cuenta) {
		Optional<Cuenta> cuentaEncontrada = buscarPorId(id);

		if (cuentaEncontrada.isPresent()) {
			Cuenta cuentaConNombreCoincidente = repository.findByNombre(cuenta.getNombre());

			if (cuentaConNombreCoincidente == null) {
				cuentaEncontrada.get().setNombre(cuenta.getNombre());
				cuentaEncontrada.get().setSaldo(cuenta.getSaldo());
				cuentaEncontrada.get().setPorDefecto(cuenta.getPorDefecto());

				Cuenta cuentaGuardada = repository.save(cuentaEncontrada.get());

				if (cuentaGuardada.getPorDefecto()) {
					repository.hacerPorDefecto(cuentaGuardada.getId());
				}

				return cuentaGuardada;
			} else {
				throw new FilaDuplicadaException(Mensajes.GENERICO_REGISTRO_DUPLICADO);
			}
		} else {
			throw new FilaNoEncontradaException(Mensajes.GENERICO_REGISTRO_NO_ENCONTRADO);
		}
	}

	/**
	 * Elimina una {@link Cuenta}
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Cuenta> eliminar(Long id) {
		Optional<Cuenta> cuentaEncontrada = buscarPorId(id);

		if (cuentaEncontrada.isPresent()) {
			repository.deleteById(id);
		}

		return cuentaEncontrada;
	}

	/**
	 * Busca y devuelve un listado de todas las {@link Cuenta}
	 * 
	 * @return
	 */
	public List<Cuenta> buscarTodos() {
		return repository.findAllByOrderByNombreAsc();
	}

	/**
	 * Busca y devuelve una {@link Cuenta} por su identificador único
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Cuenta> buscarPorId(Long id) {
		return repository.findById(id);
	}

}
