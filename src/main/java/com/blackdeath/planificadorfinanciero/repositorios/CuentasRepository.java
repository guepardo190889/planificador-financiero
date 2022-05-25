/**
 * 
 */
package com.blackdeath.planificadorfinanciero.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
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

}
