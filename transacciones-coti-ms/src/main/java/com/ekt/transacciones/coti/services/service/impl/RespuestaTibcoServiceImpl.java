package com.ekt.transacciones.coti.services.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekt.transacciones.coti.commons.message.EktCodigosMensajes;
import com.ekt.transacciones.coti.commons.message.EktGeneradorMensajes;
import com.ekt.transacciones.coti.commons.to.RespuestaMovimientoInventario;
import com.ekt.transacciones.coti.config.ConexionTibcoConfig;
import com.ekt.transacciones.coti.config.ConexionTibcoService;
import com.ekt.transacciones.coti.model.Peticion;
import com.ekt.transacciones.coti.persistence.repositories.IPeticionRepository;
import com.ekt.transacciones.coti.services.service.IConsumidorTibcoService;
import com.google.gson.Gson;

@Service
public class RespuestaTibcoServiceImpl implements IConsumidorTibcoService {
	
	public static Logger LOG = LoggerFactory.getLogger(RespuestaTibcoServiceImpl.class);
	private final EktGeneradorMensajes generadorMensajes = EktGeneradorMensajes.getInstancia();
	
	@Autowired
	private ConexionTibcoConfig conexionTibcoConfig;
	
	@Autowired
	private ConexionTibcoService conexionTibcoService;

	@Autowired
	private IPeticionRepository peticionRepository;
	
	@Override
	public void obtenerMensajesTibco() {
		Integer idMovimientoCOTI;
		conexionTibcoService.setHost(conexionTibcoConfig.getHostCOTI());
		conexionTibcoService.setPuerto(conexionTibcoConfig.getPuerto01());
		conexionTibcoService.setUsuario(conexionTibcoConfig.getUsuarioCOTI());
		conexionTibcoService.setContrasena(conexionTibcoConfig.getContrasenaCOTI());
		conexionTibcoService.setCola(conexionTibcoConfig.getColaRespuesta());
		try {
			while(true) {
				Optional<RespuestaMovimientoInventario> respuesta = Optional.empty();
				if(conexionTibcoService.conectar()) {
					respuesta = Optional.ofNullable(new Gson().fromJson(conexionTibcoService.recibirMensaje(), RespuestaMovimientoInventario.class));
					conexionTibcoService.cerrarConexion();
				}
				idMovimientoCOTI = (respuesta.isPresent() ? respuesta.get().getDetalleRespuesta().getPeticion().getIdMovimientoCOTI() : null);
				Optional<Peticion> consulta = Optional.ofNullable(peticionRepository.obtenerMensajeProcesado(idMovimientoCOTI));
				if(consulta.isPresent()) {
					peticionRepository.deleteById(idMovimientoCOTI);
					LOG.info(generadorMensajes.build(EktCodigosMensajes.TRANSACCION_BORRADA, respuesta.get().getDetalleRespuesta().getPeticion().toString()));
				}
				Thread.sleep(10000);
			}
		}
		catch(InterruptedException e) {
			LOG.warn(generadorMensajes.build(EktCodigosMensajes.INTERRUPCION_GENERAL_PROCESO));
		}
		catch(BeanCreationException e) {}
	}

	@Override
	public void run() {
		obtenerMensajesTibco();
	}
	
}
