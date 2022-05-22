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
public interface DivisaRepository extends JpaRepository<Divisa, Long> {

}
