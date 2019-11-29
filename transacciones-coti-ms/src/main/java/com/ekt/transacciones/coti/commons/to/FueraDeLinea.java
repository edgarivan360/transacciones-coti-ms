package com.ekt.transacciones.coti.commons.to;

import com.google.gson.Gson;

public class FueraDeLinea {
	
	private Integer tienda;
	private Boolean activar;
	
	public FueraDeLinea() {}
	
	public FueraDeLinea(Integer tienda, Boolean activar) {
		this.tienda = tienda;
		this.activar = activar;
	}
	
	public Integer getTienda() {
		return tienda;
	}

	public void setTienda(Integer tienda) {
		this.tienda = tienda;
	}

	public Boolean getActivar() {
		return activar;
	}

	public void setActivar(Boolean activar) {
		this.activar = activar;
	}

//	@Override
//	public String toString() {
//		StringBuilder build = new StringBuilder();
//		build.append("\"fueraDeLinea\": {\"tienda\": ");
//		build.append(tienda);
//		build.append(", \"activar\": ");
//		build.append(activar);
//		build.append("}");
//		return build.toString();
//	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
