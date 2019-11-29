package com.ekt.transacciones.coti.commons.to;

import com.google.gson.Gson;

public class RespuestaFueraDeLinea {
	
	private Boolean entregado;
	private Integer tipoResultado;
	private String mensaje;
	private DetalleRespuestaFueraDeLinea detalleRespuesta;
	
	public RespuestaFueraDeLinea() {}
	
	public RespuestaFueraDeLinea(Boolean entregado, Integer tipoResultado, String mensaje, DetalleRespuestaFueraDeLinea detalleRespuesta) {
		this.entregado = entregado;
		this.tipoResultado = tipoResultado;
		this.mensaje = mensaje;
		this.detalleRespuesta = detalleRespuesta;	
	}

	public Boolean getEntregado() {
		return entregado;
	}

	public void setEntregado(Boolean entregado) {
		this.entregado = entregado;
	}

	public Integer getTipoResultado() {
		return tipoResultado;
	}

	public void setTipoResultado(Integer tipoResultado) {
		this.tipoResultado = tipoResultado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public DetalleRespuestaFueraDeLinea getDetalleRespuesta() {
		return detalleRespuesta;
	}

	public void setDetalleRespuesta(DetalleRespuestaFueraDeLinea detalleRespuesta) {
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
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
