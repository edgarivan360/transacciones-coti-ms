package com.ekt.transacciones.coti.commons.to;

import com.google.gson.Gson;

public class RemateMovimientoInventario {
	
	private String codigoRemate;
	private String codigoUnico;
	private Double costo;
	private Integer tiendaOrigen;
	
	public RemateMovimientoInventario() {}
	
	public RemateMovimientoInventario(String codigoRemate, String codigoUnico, Double costo, Integer tiendaOrigen) {
		this.codigoRemate = codigoRemate;
		this.codigoUnico = codigoUnico;
		this.costo = costo;
		this.tiendaOrigen = tiendaOrigen;
	}

	public String getCodigoRemate() {
		return codigoRemate;
	}

	public void setCodigoRemate(String codigoRemate) {
		this.codigoRemate = codigoRemate;
	}

	public String getCodigoUnico() {
		return codigoUnico;
	}

	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Integer getTiendaOrigen() {
		return tiendaOrigen;
	}

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
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
