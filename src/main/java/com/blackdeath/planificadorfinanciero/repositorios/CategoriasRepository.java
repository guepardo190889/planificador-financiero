package com.blackdeath.planificadorfinanciero.repositorios;

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

}
