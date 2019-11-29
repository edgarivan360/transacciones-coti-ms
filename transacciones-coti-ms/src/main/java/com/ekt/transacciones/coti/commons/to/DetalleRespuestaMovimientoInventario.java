package com.ekt.transacciones.coti.commons.to;

import java.util.List;

import com.google.gson.Gson;

public class DetalleRespuestaMovimientoInventario {
	
	private Integer tienda;
	private List<ProductoRespuestaMovimientoInventario> productos;
	private MovimientoInventario peticion;
	
	public DetalleRespuestaMovimientoInventario() {}
	
	public DetalleRespuestaMovimientoInventario(Integer tienda, List<ProductoRespuestaMovimientoInventario> productos, MovimientoInventario peticion) {
		this.tienda = tienda;
		this.productos = productos;
		this.peticion = peticion;
	}

	public Integer getTienda() {
		return tienda;
	}

	public void setTienda(Integer tienda) {
		this.tienda = tienda;
	}
	
	public List<ProductoRespuestaMovimientoInventario> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoRespuestaMovimientoInventario> productos) {
		this.productos = productos;
	}

	public MovimientoInventario getPeticion() {
		return peticion;
	}

	public void setPeticion(MovimientoInventario peticion) {
		this.peticion = peticion;
	}

//	@Override
//	public String toString() {
//		StringBuilder build = new StringBuilder();
//		build.append("\"detalleRespuesta\": {\"tienda\": ");
//		build.append(tienda);
//		build.append(", \"productos\":");
//		build.append(productos);
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
