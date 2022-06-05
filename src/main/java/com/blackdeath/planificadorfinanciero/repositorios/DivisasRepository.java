package com.blackdeath.planificadorfinanciero.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
	 * Actualiza el {@code porDefecto} a {@code false} de toda las {@link Divisa} a
	 * excepción del {@code id} indicado
	 * 
	 * @param id
	 */
	@Modifying
	@Query("update Divisa d set d.porDefecto = false where d.id = :id")
	void actualizarPorDefectoFalsoExcepto(@Param("id") Long id);
}
