package com.ekt.transacciones.coti.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * Clase para configuraci\u00f3n general de conexi\u00f3n a TIBCO. Definici\u00f3n de usuarios, contrase\u00f1as, colas y hosts
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 *
 */
@ConfigurationProperties(prefix="spring.boot.config.tibco")
public class ConexionTibcoConfig {
	
	/*
	 * Par\u00e1metros comunicaci\u00f3n servicio TIBCO para peticiones y consumos de mensajes hacias las colas de Petici\u00f3n, Respuesta y Notificaci\u00f3n
	 */
	private String hostCOTI;
	private String puerto01;
	private String usuarioCOTI;
	private String contrasenaCOTI;
	private String colaPeticion;
	private String colaRespuesta;
	private String colaNotificacion;
	
	/**
	 * M\u00e9todo para obtener (get) host del servicio TIBCO para las colas de Petici\u00f3n, Respuesta y Notificaci\u00f3n
	 * @return Host del servicio TIBCO
	 */
	public String getHostCOTI() {
		return hostCOTI;
	}

	/**
	 * M\u00e9todo para asignar (set) host del servicio TIBCO para las colas de Petici\u00f3n, Respuesta y Notificaci\u00f3n
	 * @param hostCOTI Host del servicio TIBCO 
	 */
	public void setHostCOTI(String hostCOTI) {
		this.hostCOTI = hostCOTI;
	}

	/**
	 * M\u00e9todo para obtener (get) puerto \u00fanico del servicio TIBCO para las colas de Petici\u00f3n, Respuesta y Notificaci\u00f3n
	 * @return Puerto del servicio TIBCO
	 */
	public String getPuerto01() {
		return puerto01;
	}

	/**
	 * M\u00e9todo para asignar (set) puerto \u00fanico del servicio TIBCO para las colas de Petici\u00f3n, Respuesta y Notificaci\u00f3n
	 * @param puerto01 Puerto del servicio TIBCO 
	 */
	public void setPuerto01(String puerto01) {
		this.puerto01 = puerto01;
	}

	/**
	 * M\u00e9todo para obtener (get) usuario \u00fanico del servicio TIBCO para las colas de Petici\u00f3n, Respuesta y Notificaci\u00f3n
	 * @return Usuario del servicio TIBCO
	 */
	public String getUsuarioCOTI() {
		return usuarioCOTI;
	}

	/**
	 * M\u00e9todo para asignar (set) usuario \u00fanico del servicio TIBCO para las colas de Petici\u00f3n, Respuesta y Notificaci\u00f3n
	 * @param usuarioCOTI Usuario del servicio TIBCO 
	 */
	public void setUsuarioCOTI(String usuarioCOTI) {
		this.usuarioCOTI = usuarioCOTI;
	}

	/**
	 * M\u00e9todo para obtener (get) contrase\u00f1a \u00fanica del servicio TIBCO para las colas de Petici\u00f3n, Respuesta y Notificaci\u00f3n
	 * @return Contrase\u00f1a del servicio TIBCO
	 */
	public String getContrasenaCOTI() {
		return contrasenaCOTI;
	}

	/**
	 * M\u00e9todo para asignar (set) contrase\u00f1a \u00fanica del servicio TIBCO para las colas de Petici\u00f3n, Respuesta y Notificaci\u00f3n
	 * @param contrasenaCOTI Contrase\u00f1a del servicio TIBCO 
	 */
	public void setContrasenaCOTI(String contrasenaCOTI) {
		this.contrasenaCOTI = contrasenaCOTI;
	}

	/**
	 * M\u00e9todo para obtener (get) cola de Petici\u00f3n del servicio TIBCO
	 * @return Cola de Petici\u00f3n del servicio TIBCO
	 */
	public String getColaPeticion() {
		return colaPeticion;
	}

	/**
	 * M\u00e9todo para asignar (set) cola de Petici\u00f3n del servicio TIBCO
	 * @param colaPeticion Cola de Petici\u00f3n del servicio TIBCO 
	 */
	public void setColaPeticion(String colaPeticion) {
		this.colaPeticion = colaPeticion;
	}

	/**
	 * M\u00e9todo para obtener (get) cola de Respuesta del servicio TIBCO
	 * @return Cola de Respuesta del servicio TIBCO
	 */
	public String getColaRespuesta() {
		return colaRespuesta;
	}

	/**
	 * M\u00e9todo para asignar (set) cola de Respuesta del servicio TIBCO
	 * @param colaRespuesta Cola de Respuesta del servicio TIBCO 
	 */
	public void setColaRespuesta(String colaRespuesta) {
		this.colaRespuesta = colaRespuesta;
	}

	/**
	 * M\u00e9todo para obtener (get) cola de Notificaci\u00f3n del servicio TIBCO
	 * @return Cola de Notificaci\u00f3n del servicio TIBCO
	 */
	public String getColaNotificacion() {
		return colaNotificacion;
	}

	/**
	 * M\u00e9todo para asignar (set) cola de Notificaci\u00f3n del servicio TIBCO
	 * @param colaNotificacion Cola de Notificaci\u00f3n del servicio TIBCO 
	 */
	public void setColaNotificacion(String colaNotificacion) {
		this.colaNotificacion = colaNotificacion;
	}

	/*
	 * Par\u00e1metros comunicaci\u00f3n servicio TIBCO para consumos de mensajes hacia la colas de consumo de mensajes no delegados por COTI
	 */
	private String hostTiendas;	
	private String puerto05;
	private String puerto06;
	private String puerto07;
	private String puerto08;
	private String usuarioTiendas;
	private String contrasenaTiendas;
	private String cola01;
	private String cola02;
	private String cola03;
	private String cola04;

	/**
	 * M\u00e9todo para obtener (get) host del servicio TIBCO para las colas de consumo de mensajes no delegados por COTI
	 * @return Host del servicio TIBCO
	 */
	public String getHostTiendas() {
		return hostTiendas;
	}

	/**
	 * M\u00e9todo para asignar (set) host del servicio TIBCO para las colas de consumo de mensajes no delegados por COTI
	 * @param hostTiendas Host del servicio TIBCO 
	 */
	public void setHostTiendas(String hostTiendas) {
		this.hostTiendas = hostTiendas;
	}

	/**
	 * M\u00e9todo para obtener (get) uno de los puertos del servicio TIBCO para las colas de consumo de mensajes no delegados por COTI
	 * @return Puerto del servicio TIBCO
	 */
	public String getPuerto05() {
		return puerto05;
	}

	public void setPuerto05(String puerto05) {
		this.puerto05 = puerto05;
	}

	/**
	 * M\u00e9todo para obtener (get) uno de los puertos del servicio TIBCO para las colas de consumo de mensajes no delegados por COTI
	 * @return Puerto del servicio TIBCO
	 */
	public String getPuerto06() {
		return puerto06;
	}

	public void setPuerto06(String puerto06) {
		this.puerto06 = puerto06;
	}
	
	/**
	 * M\u00e9todo para obtener (get) uno de los puertos del servicio TIBCO para las colas de consumo de mensajes no delegados por COTI
	 * @return Puerto del servicio TIBCO
	 */
	public String getPuerto07() {
		return puerto07;
	}

	public void setPuerto07(String puerto07) {
		this.puerto07 = puerto07;
	}

	/**
	 * M\u00e9todo para obtener (get) uno de los puertos del servicio TIBCO para las colas de consumo de mensajes no delegados por COTI
	 * @return Puerto del servicio TIBCO
	 */
	public String getPuerto08() {
		return puerto08;
	}

	public void setPuerto08(String puerto08) {
		this.puerto08 = puerto08;
	}

	/**
	 * M\u00e9todo para obtener (get) usuario \u00fanico del servicio TIBCO para las colas de consumo de mensajes no delegados por COTI
	 * @return Usuario del servicio TIBCO
	 */
	public String getUsuarioTiendas() {
		return usuarioTiendas;
	}

	/**
	 * M\u00e9todo para asignar (set) usuario \u00fanico del servicio TIBCO para las colas de consumo de mensajes no delegados por COTI
	 * @param usuarioTiendas Usuario del servicio TIBCO 
	 */
	public void setUsuarioTiendas(String usuarioTiendas) {
		this.usuarioTiendas = usuarioTiendas;
	}

	/**
	 * M\u00e9todo para obtener (get) contrase\u00f1a \u00fanica del servicio TIBCO para las colas de consumo de mensajes no delegados por COTI
	 * @return Contrase\u00f1a del servicio TIBCO
	 */
	public String getContrasenaTiendas() {
		return contrasenaTiendas;
	}

	/**
	 * M\u00e9todo para asignar (set) contrase\u00f1a \u00fanica del servicio TIBCO para las colas de consumo de mensajes no delegados por COTI
	 * @param contrasenaTiendas Contrase\u00f1a del servicio TIBCO 
	 */
	public void setContrasenaTiendas(String contrasenaTiendas) {
		this.contrasenaTiendas = contrasenaTiendas;
	}

	/**
	 * M\u00e9todo para obtener (get) una de las colas de consumo del servicio TIBCO para los mensajes no delegados por COTI
	 * @return Cola de consumo de mensajes del servicio TIBCO
	 */
	public String getCola01() {
		return cola01;
	}

	/**
	 * M\u00e9todo para asignar (set) una de las colas de consumo del servicio TIBCO para los mensajes no delegados por COTI
	 * @param cola01 Cola de consumo de mensajes del servicio TIBCO
	 */
	public void setCola01(String cola01) {
		this.cola01 = cola01;
	}

	/**
	 * M\u00e9todo para obtener (get) una de las colas de consumo del servicio TIBCO para los mensajes no delegados por COTI
	 * @return Cola de consumo de mensajes del servicio TIBCO
	 */
	public String getCola02() {
		return cola02;
	}

	/**
	 * M\u00e9todo para asignar (set) una de las colas de consumo del servicio TIBCO para los mensajes no delegados por COTI
	 * @param cola02 Cola de consumo de mensajes del servicio TIBCO
	 */
	public void setCola02(String cola02) {
		this.cola02 = cola02;
	}

	/**
	 * M\u00e9todo para obtener (get) una de las colas de consumo del servicio TIBCO para los mensajes no delegados por COTI
	 * @return Cola de consumo de mensajes del servicio TIBCO
	 */
	public String getCola03() {
		return cola03;
	}

	/**
	 * M\u00e9todo para asignar (set) una de las colas de consumo del servicio TIBCO para los mensajes no delegados por COTI
	 * @param cola03 Cola de consumo de mensajes del servicio TIBCO
	 */
	public void setCola03(String cola03) {
		this.cola03 = cola03;
	}

	/**
	 * M\u00e9todo para obtener (get) una de las colas de consumo del servicio TIBCO para los mensajes no delegados por COTI
	 * @return Cola de consumo de mensajes del servicio TIBCO
	 */
	public String getCola04() {
		return cola04;
	}

	/**
	 * M\u00e9todo para asignar (set) una de las colas de consumo del servicio TIBCO para los mensajes no delegados por COTI
	 * @param cola04 Cola de consumo de mensajes del servicio TIBCO
	 */
	public void setCola04(String cola04) {
		this.cola04 = cola04;
	}

}
