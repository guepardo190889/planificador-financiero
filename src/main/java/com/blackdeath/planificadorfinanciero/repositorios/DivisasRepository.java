package com.blackdeath.planificadorfinanciero.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
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
}
