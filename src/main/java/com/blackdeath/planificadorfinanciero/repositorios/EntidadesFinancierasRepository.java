package com.blackdeath.planificadorfinanciero.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackdeath.planificadorfinanciero.entidades.EntidadFinanciera;
import com.blackdeath.planificadorfinanciero.utilerias.enumeradores.TipoEntidadFinanciera;

/**
 * Repositorio de acceso a datos para {@link EntidadFinanciera}
 * 
 * @author Seth Karim Luis Martínez
 * @since 12-06-2022
 *
 */
@Repository
public interface EntidadesFinancierasRepository extends JpaRepository<EntidadFinanciera, Long> {

	/**
	 * Busca y devuelve una {@link EntidadFinanciera} por su {@code nombre} y
	 * {@code tipo}
	 * 
	 * @param nombre
	 * @param tipo
	 * @return
	 */
	EntidadFinanciera findByNombreAndTipo(String nombre, TipoEntidadFinanciera tipo);

	/**
	 * Busca y devuelve un listado con todas las {@link EntidadFinanciera} ordenadas
	 * por su @cod {@code tipo} y {@code nombre}
	 * 
	 * @return
	 */
	List<EntidadFinanciera> findAllByOrderByNombreAscTipoAsc();
}
