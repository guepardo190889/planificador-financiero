package com.blackdeath.planificadorfinanciero.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blackdeath.planificadorfinanciero.entidades.Cuenta;
import com.blackdeath.planificadorfinanciero.modelos.CuentaGuardadoModel;
import com.blackdeath.planificadorfinanciero.modelos.CuentaModel;
import com.blackdeath.planificadorfinanciero.repositorios.CuentasRepository;

import lombok.RequiredArgsConstructor;

/**
 * Servicio para {@link Cuenta}
 * 
 * @author Seth Karim Luis Martínez
 * @since 24-05-2022
 *
 */
@RequiredArgsConstructor
@Service
public class CuentasService {

	private final CuentasRepository repository;

	/**
	 * Guarda una nueva {@link Cuenta}
	 * 
	 * @param cuentaGuardadoModel
	 * @return
	 */
	public CuentaModel guardar(CuentaGuardadoModel cuentaGuardadoModel) {
		Cuenta cuenta = repository.save(new Cuenta(cuentaGuardadoModel));

		return new CuentaModel(cuenta);
	}

	/**
	 * Busca y devuelve un listado de todas las cuentas
	 * 
	 * @return
	 */
	public List<CuentaModel> buscar() {
		List<Cuenta> cuentas = repository.findAll();

		List<CuentaModel> modelos = new ArrayList<>();

		for (Cuenta cuenta : cuentas) {
			modelos.add(new CuentaModel(cuenta));
		}

		return modelos;
	}

}
