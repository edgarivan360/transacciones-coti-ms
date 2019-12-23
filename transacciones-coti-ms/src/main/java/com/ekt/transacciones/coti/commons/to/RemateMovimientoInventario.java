package com.ekt.transacciones.coti.commons.to;

import com.google.gson.Gson;

/**
 * 
 * Clase objeto de transferencia para remates existentes en productos/movimientos de inventario (peticiones)
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 *
 */
public class RemateMovimientoInventario {
	
	/*
	 * Atributos de la clase
	 */
	private String codigoRemate;
	private String codigoUnico;
	private Double costo;
	private Integer tiendaOrigen;
	
	/**
	 * Constructor por defecto de la clase
	 */
	public RemateMovimientoInventario() {}
	
	/**
	 * Constructor por defecto de la clase
	 * @param codigoRemate C\u00f3digo del remate asociado al movimiento de inventario
	 * @param codigoUnico ID \u00fanico del remate asociado al movimiento de inventario
	 * @param costo Costo asociado al remate
	 * @param tiendaOrigen Tienda asociada al remate 
	 */
	public RemateMovimientoInventario(String codigoRemate, String codigoUnico, Double costo, Integer tiendaOrigen) {
		this.codigoRemate = codigoRemate;
		this.codigoUnico = codigoUnico;
		this.costo = costo;
		this.tiendaOrigen = tiendaOrigen;
	}

	/**
	 * M\u00e9todo para obtener (get) el c\u00f3digo del remate asociado al movimiento de inventario
	 * @return C\u00f3digo remate
	 */
	public String getCodigoRemate() {
		return codigoRemate;
	}

	/**
	 * M\u00e9todo para asignar (set) el c\u00f3digo del remate asociado al movimiento de inventario
	 * @param codigoRemate C\u00f3digo remate
	 */
	public void setCodigoRemate(String codigoRemate) {
		this.codigoRemate = codigoRemate;
	}

	/**
	 * M\u00e9todo para obtener (get) el ID \u00fanico del remate asociado al movimiento de inventario
	 * @return ID \u00fanico remate
	 */
	public String getCodigoUnico() {
		return codigoUnico;
	}

	/**
	 * M\u00e9todo para asignar (set) el ID \u00fanico del remate asociado al movimiento de inventario
	 * @param codigoUnico ID \u00fanico remate
	 */
	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	/**
	 * M\u00e9todo para obtener (get) el costo asociado al remate
	 * @return Costo remate
	 */
	public Double getCosto() {
		return costo;
	}

	/**
	 * M\u00e9todo para asignar (set) el costo asociado al remate
	 * @param costo Costo remate
	 */
	public void setCosto(Double costo) {
		this.costo = costo;
	}

	/**
	 * M\u00e9todo para obtener (get) la tienda asociada al remate
	 * @return Tienda remate
	 */
	public Integer getTiendaOrigen() {
		return tiendaOrigen;
	}

	/**
	 * M\u00e9todo para asignar (set) la tienda asociada al remate
	 * @param tiendaOrigen Tienda remate
	 */
	public void setTiendaOrigen(Integer tiendaOrigen) {
		this.tiendaOrigen = tiendaOrigen;
	}
	
//	@Override
//	public String toString() {
//		StringBuilder build = new StringBuilder();
//		build.append("\"remate\": {\"codigoRemate\": \"");
//		build.append(codigoRemate);
//		build.append("\", \"codigoUnico\": \"");
//		build.append(codigoUnico);
//		build.append("\", \"costo\": ");
//		build.append(costo);
//		build.append(", \"tiendaOrigen\": ");
//		build.append(tiendaOrigen);
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
