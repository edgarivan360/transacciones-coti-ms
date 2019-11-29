package com.ekt.transacciones.coti.commons.to;

import com.google.gson.Gson;

public class ProductoMovimientoInventario {
	
	private Integer producto;
	private Integer ubicacion;
	private Integer cantidad;
	private RemateMovimientoInventario remate;
	
	public ProductoMovimientoInventario() {}
	
	public ProductoMovimientoInventario(Integer producto, Integer ubicacion, Integer cantidad, RemateMovimientoInventario remate) {
		this.producto = producto;
		this.ubicacion = ubicacion;
		this.cantidad = cantidad;
		this.remate = remate;
	}

	public Integer getProducto() {
		return producto;
	}

	public void setProducto(Integer producto) {
		this.producto = producto;
	}

	public Integer getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public RemateMovimientoInventario getRemate() {
		return remate;
	}

	public void setRemate(RemateMovimientoInventario remate) {
		this.remate = remate;
	}
	
//	@Override
//	public String toString() {
//		StringBuilder build = new StringBuilder();
//		build.append("{\"producto\": ");
//		build.append(producto);
//		build.append(", \"ubicacion\": ");
//		build.append(ubicacion);
//		build.append(", \"cantidad\": ");
//		build.append(cantidad);
//		build.append(", ");
//		build.append(remate);
//		build.append("}");
//		return build.toString();
//	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
