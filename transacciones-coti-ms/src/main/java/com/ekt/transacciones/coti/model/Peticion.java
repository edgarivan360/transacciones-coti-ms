package com.ekt.transacciones.coti.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.google.gson.Gson;

/**
 * 
 * Clase para modelar los datos de las peticiones (transacciones) almacenadas una base de datos en memoria
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 *
 */
@Entity(name="Peticion")
@Table(name="PETICION")
public class Peticion implements Serializable {

	/*
	 * ID serializaci\u00f3n clase/entidad
	 */
	private static final long serialVersionUID = 1215643243;
	
	/*
	 * Atributos de la entidad Peticion / Campos de la tabla PETICION
	 */
	@Id
	@Column(name="IDMOVIMIENTOCOTI")
	private Integer idMovimientoCOTI;
	@Column(name="IDMENSAJETIBCO", nullable = true)
	private String idMensajeTibco;
	@Lob
	@Column(name="PETICION")
	private String peticion;
	@Column(name="ESTATUSPETICION")
	private Boolean estatus;
	@Column(name="MENSAJE")
	private String mensaje;
	@Column(name="FECHAPETICION")
	private Date fecha;
	
	/**
	 * Constructor por defecto de la clase
	 */
	public Peticion() {}
	
	/**
	 * Constructor de la clase
	 * @param idMovimientoCOTI ID \u00fanico de movimiento (transacci\u00f3n) en COTI
	 * @param idMensajeTibco ID de mensaje generado para el servicio de TIBCO
	 * @param peticion Contenido de la petici\u00f3n a transaccionar
	 * @param estatus Estatus de la petici\u00f3n (VERDADERO si fue exitosa la transacci\u00f3n, FALSO en caso contrario)
	 * @param mensaje Mensaje asociado al estatus de la transacci\u00f3n 
	 * @param fecha Fecha en la que se proces\u00f3 la transacci\u00f3n
	 */
	public Peticion(Integer idMovimientoCOTI, String idMensajeTibco, String peticion, Boolean estatus, String mensaje, Date fecha) {
		this.idMovimientoCOTI = idMovimientoCOTI;
		this.idMensajeTibco = idMensajeTibco;
		this.peticion = peticion;
		this.estatus = estatus;
		this.mensaje = mensaje;	
		this.fecha = fecha;
	}

	/**
	 * M\u00e9todo para obtener (get) el ID de movimiento COTI
	 * @return ID movimiento COTI
	 */
	public Integer getIdMovimientoCOTI() {
		return idMovimientoCOTI;
	}

	/**
	 * M\u00e9todo para asignar (set) el ID de movimiento COTI
	 * @param idMovimientoCOTI ID movimiento COTI
	 */
	public void setIdMovimientoCOTI(Integer idMovimientoCOTI) {
		this.idMovimientoCOTI = idMovimientoCOTI;
	}

	/**
	 * M\u00e9todo para obtener (get) el ID de mensaje TIBCO
	 * @return ID mensaje TIBCO
	 */
	public String getIdMensajeTibco() {
		return idMensajeTibco;
	}

	/**
	 * M\u00e9todo para asignar (set) el ID de mensaje TIBCO
	 * @param idMensajeTibco ID mensaje TIBCO
	 */
	public void setIdMensajeTibco(String idMensajeTibco) {
		this.idMensajeTibco = idMensajeTibco;
	}

	/**
	 * M\u00e9todo para obtener (get) el contenido de la petici\u00f3n a transaccionar
	 * @return Contenido de la petici\u00f3n a transaccionar
	 */
	public String getPeticion() {
		return peticion;
	}

	/**
	 * M\u00e9todo para asignar (set) el contenido de la petici\u00f3n a transaccionar
	 * @param peticion Contenido de la petici\u00f3n a transaccionar
	 */
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}

	/**
	 * M\u00e9todo para obtener (get) el estatus de la transacci\u00f3n
	 * @return Estatus de la transacci\u00f3n
	 */
	public Boolean getEstatus() {
		return estatus;
	}

	/**
	 * M\u00e9todo para asignar (set) el estatus de la transacci\u00f3n
	 * @param estatus Estatus de la transacci\u00f3n
	 */
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	
	/**
	 * M\u00e9todo para obtener (get) el mensaje asociado al estatus de la transacci\u00f3n
	 * @return Mensaje asociado al estatus de la transacci\u00f3n
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * M\u00e9todo para asignar (set) el mensaje asociado al estatus de la transacci\u00f3n
	 * @param mensaje Mensaje asociado al estatus de la transacci\u00f3n
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * M\u00e9todo para obtener (get) la fecha de procesamiento de la transacci\u00f3n
	 * @return Fecha de procesamiento de la transacci\u00f3n
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * M\u00e9todo para asignar (set) la fecha de procesamiento de la transacci\u00f3n
	 * @param fecha Fecha de procesamiento de la transacci\u00f3n
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * M\u00e9todo para convertir a formato JSON los objetos de la clase
	 * @return Objeto en formato JSON de tipo cadena
	 */
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
