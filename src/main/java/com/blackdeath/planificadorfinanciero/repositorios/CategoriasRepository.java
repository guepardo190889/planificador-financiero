package com.blackdeath.planificadorfinanciero.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackdeath.planificadorfinanciero.entidades.Categoria;

/**
 * Repositorio de acceso a datos para {@link Categoria}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@Repository
public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

	/**
	 * Busca y devuelve una {@link Categoria} por su nombre
	 * 
	 * @param nombre
	 * @return
	 */
	Categoria findByNombre(String nombre);

	/**
	 * Busca y devuelve un listado de con todas las {@link Categoria} ordenadas por
	 * su {@code nombre}
	 * 
	 * @return
	 */
	List<Categoria> findAllByOrderByNombreAsc();

}
