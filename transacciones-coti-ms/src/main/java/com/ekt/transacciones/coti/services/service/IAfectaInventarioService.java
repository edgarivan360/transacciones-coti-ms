package com.ekt.transacciones.coti.services.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.ekt.transacciones.coti.commons.to.MovimientoInventario;

@Service
public interface IAfectaInventarioService {
	
	public void guardarTransaccion(MovimientoInventario peticion, String idMensajeTibco, Boolean estatus, String mensaje, Date fecha);
	
	public void borrarTransaccion(Integer idMovimientoCOTI);
	
	public String enviarMensajeJMS(MovimientoInventario peticion);

}
