package com.blackdeath.planificadorfinanciero.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blackdeath.planificadorfinanciero.entidades.Categoria;
import com.blackdeath.planificadorfinanciero.entidades.Divisa;
import com.blackdeath.planificadorfinanciero.modelos.CategoriaGuardadoModel;
import com.blackdeath.planificadorfinanciero.modelos.CategoriaModel;
import com.blackdeath.planificadorfinanciero.repositorios.CategoriasRepository;

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
	 * @param divisa
	 * @return
	 */
	public CategoriaModel guardar(CategoriaGuardadoModel divisa) {
		Categoria categoriaGuardada = repository.save(new Categoria(divisa));

		return new CategoriaModel(categoriaGuardada);
	}

	/**
	 * Devuelve una listado con todas las categorías
	 * 
	 * @return
	 */
	public List<CategoriaModel> buscar() {
		List<Categoria> categorias = repository.findAll();

		List<CategoriaModel> modelos = new ArrayList<>();

		for (Categoria categoria : categorias) {
			modelos.add(new CategoriaModel(categoria));
		}

		return modelos;
	}

}
