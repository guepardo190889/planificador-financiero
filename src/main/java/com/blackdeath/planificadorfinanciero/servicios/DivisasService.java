package com.blackdeath.planificadorfinanciero.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.blackdeath.planificadorfinanciero.modelos.DivisaGuardadoModel;
import com.blackdeath.planificadorfinanciero.modelos.DivisaModel;
import com.blackdeath.planificadorfinanciero.repositorios.DivisasRepository;

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
	public DivisaModel guardar(DivisaGuardadoModel divisaGuardadoModel) {
		Divisa divisaGuardada = repository.save(new Divisa(divisaGuardadoModel));

		return new DivisaModel(divisaGuardada);
	}

	/**
	 * Busca y devuelve un listado con todas las divisas
	 * 
	 * @return
	 */
	public List<DivisaModel> buscar() {
		List<Divisa> divisasEncontradas = repository.findAll();

		List<DivisaModel> modelos = new ArrayList<>();

		for (Divisa divisaEncontrada : divisasEncontradas) {
			modelos.add(new DivisaModel(divisaEncontrada));
		}

		return modelos;
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

}
