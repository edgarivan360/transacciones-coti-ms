package com.ekt.transacciones.coti.commons.to;

import java.util.List;

import com.google.gson.Gson;

public class MovimientoInventario {
	
	private Integer tienda;
	private String fecha;
	private Integer tipoOperacion;
	private String tipoMovimiento;
	private Integer idMovimientoCOTI;
	private String referencia;
	private List<ProductoMovimientoInventario> productos;
	
	public MovimientoInventario() {}
		
	public MovimientoInventario(Integer tienda, String fecha, Integer tipoOperacion, String tipoMovimiento, Integer idMovimientoCOTI, String referencia, List<ProductoMovimientoInventario> productos) {
		this.tienda = tienda;
		this.fecha = fecha;
		this.tipoOperacion = tipoOperacion;
		this.tipoMovimiento = tipoMovimiento;
		this.idMovimientoCOTI = idMovimientoCOTI;
		this.referencia = referencia;
		this.productos = productos;
	}
	
	public Integer getTienda() {
		return tienda;
	}

	public void setTienda(Integer tienda) {
		this.tienda = tienda;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(Integer tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Integer getIdMovimientoCOTI() {
		return idMovimientoCOTI;
	}

	public void setIdMovimientoCOTI(Integer idMovimientoCOTI) {
		this.idMovimientoCOTI = idMovimientoCOTI;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public List<ProductoMovimientoInventario> getProductos() {
		return productos;
	}

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
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
