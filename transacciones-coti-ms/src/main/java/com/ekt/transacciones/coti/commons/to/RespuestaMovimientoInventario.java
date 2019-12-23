package com.ekt.transacciones.coti.commons.to;

import com.google.gson.Gson;

/**
 * 
 * Clase objeto de transferencia para respuestas a peticiones de movimientos de inventario
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 *
 */
public class RespuestaMovimientoInventario {
	
	/*
	 * Atributos de la clase
	 */
	private Boolean entregado;
	private Integer tipoResultado;
	private String mensaje;
	private DetalleRespuestaMovimientoInventario detalleRespuesta;
	
	/**
	 * Constructor por defecto de la clase
	 */
	public RespuestaMovimientoInventario() {}
	
	/**
	 * Constructor de la clase
	 * @param entregado Estatus de la respuesta a la petici\u00f3n de movimiento de inventario
	 * @param tipoResultado Tipo de respuesta a la petici\u00f3n de movimiento de inventario (correcto, error procesamiento, error comunicaci\u00f3n)
	 * @param mensaje Mensaje descriptivo asociado al tipo de respuesta
	 * @param detalleRespuesta Objeto con los detalles de respuesta a la petici\u00f3n de movimiento de inventario
	 */
	public RespuestaMovimientoInventario(Boolean entregado, Integer tipoResultado, String mensaje, DetalleRespuestaMovimientoInventario detalleRespuesta) {
		this.entregado = entregado;
		this.tipoResultado = tipoResultado;
		this.mensaje = mensaje;
		this.detalleRespuesta = detalleRespuesta;
	}

	/**
	 * M\u00e9todo para obtener (get) el estatus de la respuesta a la petici\u00f3n de movimiento de inventario
	 * @return Estatus respuesta a petici\u00f3n de movimiento de inventario
	 */
	public Boolean getEntregado() {
		return entregado;
	}

	/**
	 * M\u00e9todo para asignar (set) el estatus de la respuesta a la petici\u00f3n de movimiento de inventario
	 * @param entregado Estatus respuesta a petici\u00f3n de movimiento de inventario
	 */
	public void setEntregado(Boolean entregado) {
		this.entregado = entregado;
	}

	/**
	 * M\u00e9todo para obtener (get) el tipo de respuesta a la petici\u00f3n de movimiento de inventario
	 * @return Tipo respuesta a petici\u00f3n de movimiento de inventario
	 */
	public Integer getTipoResultado() {
		return tipoResultado;
	}

	/**
	 * M\u00e9todo para asignar (set) el tipo de respuesta a la petici\u00f3n de movimiento de inventario
	 * @param tipoResultado Tipo respuesta a petici\u00f3n de movimiento de inventario
	 */
	public void setTipoResultado(Integer tipoResultado) {
		this.tipoResultado = tipoResultado;
	}

	/**
	 * M\u00e9todo para obtener (get) el mensaje descriptivo asociado al tipo de respuesta
	 * @return Mensaje tipo de respuesta
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * M\u00e9todo para asignar (set) el mensaje descriptivo asociado al tipo de respuesta
	 * @param mensaje Mensaje tipo de respuesta
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * M\u00e9todo para obtener (get) el objeto con los detalles de respuesta a la petici\u00f3n de movimiento de inventario
	 * @return Detalles respuesta a petici\u00f3n de movimiento de inventario
	 */
	public DetalleRespuestaMovimientoInventario getDetalleRespuesta() {
		return detalleRespuesta;
	}

	/**
	 * M\u00e9todo para asignar (set) el objeto con los detalles de respuesta a la petici\u00f3n de movimiento de inventario
	 * @param detalleRespuesta Detalles respuesta a petici\u00f3n de movimiento de inventario
	 */
	public void setDetalleRespuesta(DetalleRespuestaMovimientoInventario detalleRespuesta) {
		this.detalleRespuesta = detalleRespuesta;
	}

//	@Override
//	public String toString() {
//		StringBuilder build = new StringBuilder();
//		build.append("\"respuesta\": {\"entregado\": ");
//		build.append(entregado);
//		build.append(", \"tipoResultado\": ");
//		build.append(tipoResultado);
//		build.append(", \"mensaje\": \"");
//		build.append(mensaje);
//		build.append("\", ");
//		build.append(detalleRespuesta);
//		build.append("}");
//		return build.toString();
//	}
	
	/**
	 * M\u00e9todo para convertir a formato JSON los objetos de la clase
	 * @return Objeto en formato JSON de tipo cadena
	 */
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}

