package com.ekt.transacciones.coti.commons.to;

import java.util.List;

import com.google.gson.Gson;

/**
 * 
 * Clase objeto de transferencia para peticiones de movimientos de inventario
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 *
 */
public class MovimientoInventario {
	
	/*
	 * Atributos de la clase
	 */
	private Integer tienda;
	private String fecha;
	private Integer tipoOperacion;
	private String tipoMovimiento;
	private Integer idMovimientoCOTI;
	private String referencia;
	private List<ProductoMovimientoInventario> productos;
	
	/**
	 * Constructor por defecto de la clase
	 */
	public MovimientoInventario() {}
	
	/**
	 * Constructor de la clase
	 * @param tienda ID de la tienda asociada al movimiento de inventario
	 * @param fecha Fecha del movimiento de inventario
	 * @param tipoOperacion Tipo de operaci\u00f3n asociada al movimiento de inventario
	 * @param tipoMovimiento Tipo de movimiento de inventario
	 * @param idMovimientoCOTI ID \u00fanico de movimiento de inventario
	 * @param referencia Referencia asociada al movimiento de inventario
	 * @param productos Lista de productos asociados al movimiento de inventario
	 */
	public MovimientoInventario(Integer tienda, String fecha, Integer tipoOperacion, String tipoMovimiento, Integer idMovimientoCOTI, String referencia, List<ProductoMovimientoInventario> productos) {
		this.tienda = tienda;
		this.fecha = fecha;
		this.tipoOperacion = tipoOperacion;
		this.tipoMovimiento = tipoMovimiento;
		this.idMovimientoCOTI = idMovimientoCOTI;
		this.referencia = referencia;
		this.productos = productos;
	}
	
	/**
	 * M\u00e9todo para obtener (get) el ID de la tienda asociada al movimiento de inventario
	 * @return ID de tienda
	 */
	public Integer getTienda() {
		return tienda;
	}

	/**
	 * M\u00e9todo para asignar (set) el ID de la tienda asociada al movimiento de inventario
	 * @param tienda ID de tienda
	 */
	public void setTienda(Integer tienda) {
		this.tienda = tienda;
	}

	/**
	 * M\u00e9todo para obtener (get) la fecha del movimiento de inventario
	 * @return Fecha movimiento de inventario
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * M\u00e9todo para asignar (set) la fecha del movimiento de inventario
	 * @param fecha Fecha movimiento de inventario
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * M\u00e9todo para obtener (get) el tipo de operaci\u00f3n asociada al movimiento de inventario
	 * @return Tipo operaci\u00f3n
	 */
	public Integer getTipoOperacion() {
		return tipoOperacion;
	}

	/**
	 * M\u00e9todo para asignar (set) el tipo de operaci\u00f3n asociada al movimiento de inventario
	 * @param tipoOperacion Tipo operaci\u00f3n
	 */
	public void setTipoOperacion(Integer tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	/**
	 * M\u00e9todo para obtener (get) el tipo de movimiento de inventario
	 * @return Tipo movimiento de inventario
	 */
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	/**
	 * M\u00e9todo para asignar (set) el tipo de movimiento de inventario
	 * @param tipoMovimiento Tipo movimiento de inventario
	 */
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	/**
	 * M\u00e9todo para obtener (get) el ID \u00fanico de movimiento de inventario
	 * @return ID \u00fanico movimiento de inventario
	 */
	public Integer getIdMovimientoCOTI() {
		return idMovimientoCOTI;
	}

	/**
	 * M\u00e9todo para asignar (set) el ID \u00fanico de movimiento de inventario
	 * @param tipoMovimientoCOTI ID \u00fanico movimiento de inventario
	 */
	public void setIdMovimientoCOTI(Integer idMovimientoCOTI) {
		this.idMovimientoCOTI = idMovimientoCOTI;
	}

	/**
	 * M\u00e9todo para obtener (get) la referencia asociada al movimiento de inventario
	 * @return Referencia movimiento de inventario
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * M\u00e9todo para asignar (set) la referencia asociada al movimiento de inventario
	 * @param referencia Referencia movimiento de inventario
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * M\u00e9todo para obtener (get) la lista de productos asociados al movimiento de inventario
	 * @return Lista de productos
	 */
	public List<ProductoMovimientoInventario> getProductos() {
		return productos;
	}

	/**
	 * M\u00e9todo para asignar (set) la lista de productos asociados al movimiento de inventario
	 * @param productos Lista de productos
	 */
	public void setProductos(List<ProductoMovimientoInventario> productos) {
		this.productos = productos;
	}

//	@Override
//	public String toString() {
//		StringBuilder build = new StringBuilder();
//		build.append("\"movimientoInventario\": {\"tienda\": ");
//		build.append(tienda);
//		build.append(", \"fecha\": \"");
//		build.append(fecha);
//		build.append("\", \"tipoOperacion\": ");
//		build.append(tipoOperacion);
//		build.append(", \"tipoMovimiento\": \"");
//		build.append(tipoMovimiento);
//		build.append("\", \"idMovimientoCOTI\": ");
//		build.append(idMovimientoCOTI);
//		build.append(", \"referencia\": \"");
//		build.append(referencia);
//		build.append("\", \"productos\":");
//		build.append(productos);
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
