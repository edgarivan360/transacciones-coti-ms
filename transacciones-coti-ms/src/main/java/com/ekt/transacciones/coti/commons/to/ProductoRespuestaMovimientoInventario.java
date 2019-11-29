package com.ekt.transacciones.coti.commons.to;

import com.google.gson.Gson;

public class ProductoRespuestaMovimientoInventario {

	private Integer idProducto;
	private Integer ubicacion;
	private Integer existenciaInicial;
	private Integer existenciaFinal;
	
	public ProductoRespuestaMovimientoInventario() {}
	
	public ProductoRespuestaMovimientoInventario(Integer idProducto, Integer ubicacion, Integer existenciaInicial, Integer existenciaFinal) {
		this.idProducto = idProducto;
		this.ubicacion = ubicacion;
		this.existenciaInicial = existenciaInicial;
		this.existenciaFinal = existenciaFinal;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getExistenciaInicial() {
		return existenciaInicial;
	}

	public void setExistenciaInicial(Integer existenciaInicial) {
		this.existenciaInicial = existenciaInicial;
	}

	public Integer getExistenciaFinal() {
		return existenciaFinal;
	}

	public void setExistenciaFinal(Integer existenciaFinal) {
		this.existenciaFinal = existenciaFinal;
	}
	
//	@Override
//	public String toString() {
//		StringBuilder build = new StringBuilder();
//		build.append("{\"idProducto\": ");
//		build.append(idProducto);
//		build.append(", \"ubicacion\": ");
//		build.append(ubicacion);
//		build.append(", \"existenciaInicial\": ");
//		build.append(existenciaInicial);
//		build.append(", \"existenciaFinal\": ");
//		build.append(existenciaFinal);
//		build.append("}");
//		return build.toString();
//	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
