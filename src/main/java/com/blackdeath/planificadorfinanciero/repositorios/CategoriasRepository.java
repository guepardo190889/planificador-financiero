package com.blackdeath.planificadorfinanciero.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blackdeath.planificadorfinanciero.entidades.Categoria;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoCategoria;

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
	 * Busca y devuelve una {@link Categoria} que concida con los parámetros
	 * {@code nombre} y {@code tipo}; se omite la categoría cuyo identificador único
	 * coincida con {@code id}
	 * 
	 * @param nombre
	 * @param tipo
	 * @param id
	 * @return
	 */
	@Query("SELECT c FROM Categoria c WHERE c.nombre = :nombre AND c.tipo = :tipo AND c.id <> (:id)")
	Categoria buscarCategoriaDuplicada(String nombre, TipoCategoria tipo, Long id);

	/**
	 * Busca y devuelve una {@link Categoria} que concida con los parámetros
	 * {@code nombre} y {@code tipo}
	 * 
	 * @param nombre
	 * @param tipo
	 * @return
	 */
	@Query("SELECT c FROM Categoria c WHERE c.nombre = :nombre AND c.tipo = :tipo")
	Categoria buscarCategoriaDuplicada(String nombre, TipoCategoria tipo);

	/**
	 * Busca y devuelve un listado de con todas las {@link Categoria} ordenadas por
	 * su {@code nombre}
	 * 
	 * @return
	 */
	List<Categoria> findAllByOrderByCategoria_IdAscNombreAsc();

}
