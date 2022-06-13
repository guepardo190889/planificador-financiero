package com.blackdeath.planificadorfinanciero.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blackdeath.planificadorfinanciero.entidades.Divisa;

/**
 * Repositorio de acceso a datos para {@link Divisa}
 * 
 * @author Seth Karim Luis Martínez
 * @since 22-05-2022
 *
 */
@Repository
public interface DivisasRepository extends JpaRepository<Divisa, Long> {

	/**
	 * Busca y devuelve una {@link Divisa} por su {@code codigo}
	 * 
	 * @param codigo
	 * @return
	 */
	Divisa findByCodigo(String codigo);

	/**
	 * Busca y devuelve un listado con toda las {@link Divisa} ordenadas por su
	 * {@code nombre}
	 * 
	 * @return
	 */
	List<Divisa> findAllByOrderByNombreAsc();

	/**
	 * Actualiza el {@code porDefecto} a {@code false} de toda las {@link Divisa} a
	 * excepción del {@code id} indicado
	 * 
	 * @param id
	 */
	@Transactional
	@Modifying
	@Query("update Divisa d set d.porDefecto = false where d.id not in (:id)")
	void hacerPorDefecto(@Param("id") Long id);
}
