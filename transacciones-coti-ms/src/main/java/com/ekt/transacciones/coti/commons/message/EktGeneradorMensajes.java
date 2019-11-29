package com.ekt.transacciones.coti.commons.message;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Clase para generar mensajes basados en los c\u00f3digos EktCodigosMensajes
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 * @see com.ekt.transacciones.coti.commons.message.EktCodigosMensajes
 *
 */
public final class EktGeneradorMensajes {
	
	/*
	 * Objetos y atributos de la clase
	 */
	private static final Logger LOG = LoggerFactory.getLogger(EktGeneradorMensajes.class);

	private static final String PROP_PREFIJO = "com.ekt.transacciones.mensajes.codigo.";
	private static final String LLAVE_APERTURA = "{";
	private static final String LLAVE_CIERRE = "}";
	
	private static EktGeneradorMensajes instancia;

	private Properties props = new Properties();
	
	/**
	 * Constructor por defecto de la clase
	 */
	private EktGeneradorMensajes() {}
	
	/**
	 * M\u00e9todo est\u00e1tico para obtener la instancia de la clase acorde a un archivo de configuraci\u00f3n (properties)
	 * @return Instancia de la clase
	 */
	public static EktGeneradorMensajes getInstancia() {
		if (instancia == null) {
			instancia = new EktGeneradorMensajes();
			try {
				instancia.props.load(EktGeneradorMensajes.class.getClassLoader()
						.getResourceAsStream("ekt-transacciones-mensajes.properties"));
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return instancia;
	}
	
	/**
	 * M\u00e9todo para generar los mensajes asociados a las operaciones realizadas con base al archivo de configuraci\u00f3n (properties) y los c\u00f3digos establecidos en el enumerador 
	 * @param codigo C\u00f3digo asociado al mensaje que se generar\u00e1
	 * @param args Argumentos utilizados por el mensaje a mostrar
	 * @return Cadena con el mensaje final asociado a la operaci\u00f3n realizada
	 */
	public String build(EktCodigosMensajes codigo, String... args) {
		String cadena = props.getProperty(new StringBuilder(PROP_PREFIJO).append(codigo.getCodigo()).toString());
		String cadenaNueva = reemplazarArgumentos(cadena, args);
		return cadenaNueva;
	}
	
	/**
	 * M\u00e9todo para reemplezar argumentos en mensajes est\u00e1ndar (comodines) del archivo de configuraci\u00f3n (properties) 
	 * @param cadena Cadena inicial con comodines a ser reemplazados
	 * @param args Argumentos utilizados por el mensaje a mostrar (reemplazo de comodines)
	 * @return Cadena con el mensaje final (comodines reemplazados)
	 */
	private String reemplazarArgumentos(String cadena, String[] args) {
		if (args != null) {
			int i = 0;
			for(String arg : args) {
				cadena = StringUtils.replace(cadena,
						new StringBuilder(LLAVE_APERTURA).append(i).append(LLAVE_CIERRE).toString(), arg, -1);
				i++;
			}
		}
		return cadena;
	}

}
