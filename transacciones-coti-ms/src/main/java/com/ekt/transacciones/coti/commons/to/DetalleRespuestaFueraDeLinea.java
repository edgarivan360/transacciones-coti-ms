package com.ekt.transacciones.coti.commons.to;

import com.google.gson.Gson;

public class DetalleRespuestaFueraDeLinea {
	
	private Integer tienda;
	private FueraDeLinea peticion;
	
	public DetalleRespuestaFueraDeLinea() {}
	
	public DetalleRespuestaFueraDeLinea(Integer tienda, FueraDeLinea peticion) {
		this.tienda = tienda;
		this.peticion = peticion;
	}
	
	public Integer getTienda() {
		return tienda;
	}

	public void setTienda(Integer tienda) {
		this.tienda = tienda;
	}

	public FueraDeLinea getPeticion() {
		return peticion;
	}

	public void setPeticion(FueraDeLinea peticion) {
		this.peticion = peticion;
	}

//	@Override
//	public String toString() {
//		StringBuilder build = new StringBuilder();
//		build.append("\"detalleRespuesta\": {\"tienda\": ");
//		build.append(tienda);
//		build.append(", \"peticion\": {");
//		build.append(peticion);
//		build.append("}}");
//		return build.toString();
//	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
