package com.blackdeath.planificadorfinanciero.utilerias.enumeradores;

import java.util.Map;

import org.springframework.http.ResponseEntity;

/**
 * Clase de utilería con constantes que representan las llaves de todas los
 * {@link Map} que se devuelven en un {@link ResponseEntity}
 * 
 * @author Seth Karim Luis Martínez
 * @since 04-06-2022
 *
 */
public class LlaveRespuesta {

	public static final String MENSAJE = "mensaje";
	public static final String RESPUESTA = "respuesta";
	public static final String ERROR = "error";
	public static final String ERRORES = "errores";

	public static final String DIVISA_INDIVIDUAL = "divisa";
	public static final String DIVISA_MULTIPLE = "divisas";

	/**
	 * Constructor privado para evitar que esta clase sea instanciada
	 */
	private LlaveRespuesta() {
		super();
	}
}
