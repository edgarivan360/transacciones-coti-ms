package com.ekt.transacciones.coti.commons.to;

import java.util.List;

import com.google.gson.Gson;

/**
 * 
 * Clase objeto de transferencia para detalles de respuestas a peticiones de movimientos de inventario
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 *
 */
public class DetalleRespuestaMovimientoInventario {
	
	/*
	 * Atributos de la clase
	 */
	private Integer tienda;
	private List<ProductoRespuestaMovimientoInventario> productos;
	private MovimientoInventario peticion;
	
	/**
	 * Constructor por defecto de la clase
	 */
	public DetalleRespuestaMovimientoInventario() {}
	
	/**
	 * Constructor de la clase
	 * @param tienda ID de la tienda asociada al movimiento de inventario
	 * @param productos Lista de productos asociados al movimiento de inventario
	 * @param peticion Petici\u00f3n original (MovimientoInventario) 
	 */
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
	
	/**
	 * M\u00e9todo para convertir a formato JSON los objetos de la clase
	 * @return Objeto en formato JSON de tipo cadena
	 */
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
