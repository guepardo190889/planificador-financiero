package com.blackdeath.planificadorfinanciero.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.blackdeath.planificadorfinanciero.modelos.DivisaModel;
import com.blackdeath.planificadorfinanciero.repositorios.DivisaRepository;

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
public class DivisaService {

	private final DivisaRepository repository;

	/**
	 * Devuelve una lista con todas las divisas
	 * 
	 * @return
	 */
	public List<DivisaModel> buscar() {
		List<Divisa> divisas = repository.findAll();

		List<DivisaModel> modelos = new ArrayList<>();

		for (Divisa divisa : divisas) {
			modelos.add(new DivisaModel(divisa));
		}

		return modelos;
	}

}
