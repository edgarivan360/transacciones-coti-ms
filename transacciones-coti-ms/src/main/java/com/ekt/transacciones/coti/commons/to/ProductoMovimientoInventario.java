package com.ekt.transacciones.coti.commons.to;

import com.google.gson.Gson;

/**
 * 
 * Clase objeto de transferencia para productos asociados a peticiones de movimientos de inventario
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 *
 */
public class ProductoMovimientoInventario {
	
	/*
	 * Atributos de la clase
	 */
	private Integer producto;
	private Integer ubicacion;
	private Integer cantidad;
	private RemateMovimientoInventario remate;
	
	/**
	 * Constructor por defecto de la clase
	 */
	public ProductoMovimientoInventario() {}
	
	/**
	 * Constructor de la clase
	 * @param producto Producto asociado al movimiento de inventario
	 * @param ubicacion Ubicaci\u00f3n donde se situa el producto en cuesti\u00f3n
	 * @param cantidad Cantidad asociada al producto/ubicaci\u00f3n
	 * @param remate Remate (Objeto) asociado al producto/ubicaci\u00f3n (movimiento de inventario en caso de que exista)
	 */
	public ProductoMovimientoInventario(Integer producto, Integer ubicacion, Integer cantidad, RemateMovimientoInventario remate) {
		this.producto = producto;
		this.ubicacion = ubicacion;
		this.cantidad = cantidad;
		this.remate = remate;
	}

	/**
	 * M\u00e9todo para obtener (get) el producto asociado al movimiento de inventario
	 * @return Producto movimiento de inventario
	 */
	public Integer getProducto() {
		return producto;
	}

	/**
	 * M\u00e9todo para asignar (set) el producto asociado al movimiento de inventario
	 * @param producto Producto movimiento de inventario
	 */
	public void setProducto(Integer producto) {
		this.producto = producto;
	}

	/**
	 * M\u00e9todo para obtener (get) la ubicaci\u00f3n donde se situa el producto en cuesti\u00f3n
	 * @return Ubicaci\u00f3n asociada el producto
	 */
	public Integer getUbicacion() {
		return ubicacion;
	}

	/**
	 * M\u00e9todo para asignar (set) la ubicaci\u00f3n donde se situa el producto en cuesti\u00f3n
	 * @param ubicacion Ubicaci\u00f3n asociada el producto
	 */
	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * M\u00e9todo para obtener (get) la cantidad asociada al producto/ubicaci\u00f3n
	 * @return Cantidad producto/ubicaci\u00f3n
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * M\u00e9todo para asignar (set) la cantidad asociada al producto/ubicaci\u00f3n
	 * @param cantidad Cantidad producto/ubicaci\u00f3n
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * M\u00e9todo para obtener (get) el remate asociado al movimiento de inventario en caso de que exista
	 * @return Remate movimiento de inventario
	 */
	public RemateMovimientoInventario getRemate() {
		return remate;
	}

	/**
	 * M\u00e9todo para asignar (set) el remate asociado al movimiento de inventario en caso de que exista
	 * @param remate Remate movimiento de inventario
	 */
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
	
	/**
	 * M\u00e9todo para convertir a formato JSON los objetos de la clase
	 * @return Objeto en formato JSON de tipo cadena
	 */
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
