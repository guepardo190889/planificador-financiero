package com.blackdeath.planificadorfinanciero.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blackdeath.planificadorfinanciero.entidades.Cuenta;

/**
 * Repositorio de acceso a datos para {@link Cuenta}
 * 
 * @author Seth Karim Luis Martínez
 * @since 24-05-2022
 *
 */
@Repository
public interface CuentasRepository extends JpaRepository<Cuenta, Long> {

	/**
	 * Busca y devuelve una {@link Cuenta} por su {@code nombre}
	 * 
	 * @param nombre
	 * @return
	 */
	Cuenta findByNombre(String nombre);

	/**
	 * Busca y devuelve una {@link Cuenta} por su {@code nombre} y
	 * {@code entidadFinancieraId}
	 * 
	 * @param nombre
	 * @param entidadFinancieraId
	 * @return
	 */
	Cuenta findByNombreAndEntidadFinanciera_Id(String nombre, Long entidadFinancieraId);

	/**
	 * Busca y devuelve un listado con todas las {@link Cuenta} ordenadas por su
	 * {@code nombre}
	 * 
	 * @return
	 */
	List<Cuenta> findAllByOrderByNombreAsc();

	@Transactional
	@Modifying
	@Query("update Cuenta c set c.porDefecto = false where c.id not in (:id)")
	void hacerPorDefecto(@Param("id") Long id);

}
