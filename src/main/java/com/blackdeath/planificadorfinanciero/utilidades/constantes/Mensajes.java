package com.blackdeath.planificadorfinanciero.utilidades.constantes;

/**
 * Clase de utilería con los mensajes que puede mandar esta aplicación
 * 
 * @author Seth Karim Luis Martínez
 * @since 03-06-2022
 *
 */
public class Mensajes {

	public static final String GENERICO_ERROR_CONSULTA = "Ocurrió un error al realizar la consulta";
	public static final String GENERICO_ERROR_GUARDADO = "Ocurrió un error al realizar el guardado";
	public static final String GENERICO_ERROR_ACTUALIZADO = "Ocurrió un error al realizar el actualizado";
	public static final String GENERICO_ERROR_ELIMINADO = "Ocurrió un error al realizar el eliminado";

	public static final String GENERICO_EXITO_CONSULTA = "Consulta realizada exitosamente";
	public static final String GENERICO_EXITO_GUARDADO = "Guardado realizado exitosamente";
	public static final String GENERICO_EXITO_ACTUALIZADO = "Actualizado realizado exitosamente";
	public static final String GENERICO_EXITO_ELIMINADO = "Eliminado realizado exitosamente";

	public static final String GENERICO_REGISTRO_NO_ENCONTRADO = "No se encontró el registro";
	public static final String GENERICO_REGISTRO_DUPLICADO = "El registro ya existe";

	/**
	 * Constructor privado para evitar que esta clase sea instanciada
	 */
	private Mensajes() {
		super();
	}
}
