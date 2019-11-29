package com.ekt.transacciones.coti.services.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekt.transacciones.coti.commons.to.MovimientoInventario;
import com.ekt.transacciones.coti.config.ConexionTibcoConfig;
import com.ekt.transacciones.coti.config.ConexionTibcoService;
import com.ekt.transacciones.coti.model.Peticion;
import com.ekt.transacciones.coti.persistence.repositories.IPeticionRepository;
import com.ekt.transacciones.coti.services.service.IAfectaInventarioService;

@Service
public class AfectaInventarioServiceImpl implements IAfectaInventarioService {
	
	@Autowired
	private ConexionTibcoConfig conexionTibcoConfig;
	
	@Autowired
	private ConexionTibcoService conexionTibcoService;
	
	@Autowired
	private IPeticionRepository peticionRepository;
	
	public void guardarTransaccion(MovimientoInventario peticion, String idMensajeTibco, Boolean estatus, String mensaje, Date fecha) {
		peticionRepository.save(new Peticion(peticion.getIdMovimientoCOTI(), idMensajeTibco, peticion.toString(), estatus, mensaje, fecha));
	}
	
	public void borrarTransaccion(Integer idMovimientoCOTI) {
		peticionRepository.deleteById(idMovimientoCOTI);
	}
	
	public String enviarMensajeJMS(MovimientoInventario peticion) {
		String jmsMensajeID = null;
		conexionTibcoService.setHost(conexionTibcoConfig.getHostCOTI());
		conexionTibcoService.setPuerto(conexionTibcoConfig.getPuerto01());
		conexionTibcoService.setUsuario(conexionTibcoConfig.getUsuarioCOTI());
		conexionTibcoService.setContrasena(conexionTibcoConfig.getContrasenaCOTI());
		conexionTibcoService.setCola(conexionTibcoConfig.getColaPeticion());
		if(conexionTibcoService.conectar()) {
			jmsMensajeID = conexionTibcoService.enviarMensaje(peticion.toString(), peticion.getTienda());
			conexionTibcoService.cerrarConexion();
		}
		return jmsMensajeID;
	}

}
