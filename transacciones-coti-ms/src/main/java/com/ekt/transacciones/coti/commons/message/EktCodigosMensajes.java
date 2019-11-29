package com.ekt.transacciones.coti.commons.message;

/**
 * 
 * Enumerador para los mensajes utilizados para las conexiones, obtenci\u00f3n de mensajes, transacciones realizadas, entre otros
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 *
 */
public enum EktCodigosMensajes {
	
	/**
	 * Transacci\u00f3n completada
	 */
	OK(0),
	/**
	 * Conexi\u00f3n con TIBCO establecida correctamente
	 */
	CONEXION_TIBCO_ESTABLECIDA(10),
	/**
	 * Conexi\u00f3n con TIBCO fallida
	 */
	CONEXION_TIBCO_FALLIDA(20),
	/**
	 * Conexi\u00f3n con TIBCO finalizada correctamente
	 */
	CONEXION_TIBCO_FINALIZADA(30),
	/**
	 * Conexi\u00f3n con TIBCO ya ha sido cerrada previamente
	 */
	CONEXION_TIBCO_YA_CERRADA(40),
	/**
	 * No se tienen mensajes a la salida (env\u00edo) o a la entrada (recepci\u00f3n) 
	 */
	NO_HAY_MENSAJES(50),
	/**
	 * Etiqueta de mensaje enviado
	 */
	MENSAJE_ENVIADO(60),
	/**
	 * Etiqueta de mensaje recibido
	 */
	MENSAJE_RECIBIDO(70),
	/**
	 * Error al intentar enviar mensajes a TIBCO 
	 */
	IMPOSIBLE_ENVIAR_MENSAJES(80),
	/**
	 * Error al intentar recibir mensajes desde TIBCO 
	 */
	IMPOSIBLE_RECIBIR_MENSAJES(90),
	/**
	 * Error de conexi\u00f3n con TIBCO 
	 */
	ERROR_CONEXION_TIBCO(100),
	/**
	 * Error de conexi\u00f3n a los WebServices de Manhattan 
	 */
	CONEXION_WS_FALLIDA(200),
	/**
	 * Interrupci\u00f3n de hilos de recepci\u00f3n de mensajes desde TIBCO 
	 */
	INTERRUPCION_GENERAL_PROCESO(210),
	/**
	 * Transacci\u00f3n guardada en base de datos en memoria (sin importar el estatus de la misma) 
	 */
	TRANSACCION_GUARDADA(300),
	/**
	 * Transacci\u00f3n borrada en base de datos en memoria (siempre y cuando ya haya sido procesada por todos los sistemas externos) 
	 */
	TRANSACCION_BORRADA(310);
	
	/*
	 * Atributos del enumerador
	 */
	private final Integer codigo;
	
	/**
	 * Constructor del enumerador para generar objetos
	 * @param codigo C\u00f3digo asociado al mensaje que se generar\u00e1
	 */
	private EktCodigosMensajes(Integer codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * M\u00e9todo para obtener el valor del C\u00f3digo asociado a un objeto del enumerador
	 * @return C\u00f3digo asociado al mensaje que se generar\u00e1
	 */
	public Integer getCodigo() {
		return codigo;
	}
	
	/**
	 * M\u00e9todo para obtener objetos de tipo enumerador de la propia clase
	 * @param codigo C\u00f3digo asociado al mensaje que se generar\u00e1
	 * @return Objeto de tipo enumerador de la propia clase
	 */
	public static EktCodigosMensajes buscarPorCodigo(Integer codigo) {
		
		for(EktCodigosMensajes msj : EktCodigosMensajes.values()) {
			if(msj.codigo == codigo) {
				return msj;
			}
		}
		
		return null;
		
	}

}
