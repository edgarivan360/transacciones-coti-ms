package com.ekt.transacciones.coti.services.facade.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekt.transacciones.coti.commons.message.EktCodigosMensajes;
import com.ekt.transacciones.coti.commons.message.EktGeneradorMensajes;
import com.ekt.transacciones.coti.commons.to.MovimientoInventario;
import com.ekt.transacciones.coti.commons.to.RespuestaMovimientoInventario;
import com.ekt.transacciones.coti.services.facade.IAfectaInventarioFacade;
import com.ekt.transacciones.coti.services.service.IAfectaInventarioClient;
import com.ekt.transacciones.coti.services.service.IAfectaInventarioService;

import feign.RetryableException;

@Service
public class AfectaInventarioFacadeImpl implements IAfectaInventarioFacade {
	
	public static Logger LOG = LoggerFactory.getLogger(AfectaInventarioFacadeImpl.class);
	private final EktGeneradorMensajes generadorMensajes = EktGeneradorMensajes.getInstancia();
	
	@Autowired
	private IAfectaInventarioClient afectaInventarioClient;
	
	@Autowired
	private IAfectaInventarioService afectaInventarioService;

	@Override
	public void afectaInventario(MovimientoInventario peticion) {		
		// Variables auxiliares
		Boolean estatusPeticion = false;
		String jmsMensajeID = null;
		String mensaje = generadorMensajes.build(EktCodigosMensajes.CONEXION_WS_FALLIDA);
		
		// Consumo de WS FueraDeLinea y AfectaInventario
		try {
			RespuestaMovimientoInventario respuestaMovimientoInventario = afectaInventarioClient.getRespuestaAfectaInventario(peticion);
		
			// Validacion consumo de WS
			if(respuestaMovimientoInventario.getEntregado()) {
				jmsMensajeID = afectaInventarioService.enviarMensajeJMS(peticion);
				estatusPeticion = (!jmsMensajeID.isEmpty() ? true : false);
				mensaje = (!jmsMensajeID.isEmpty() ? 
						generadorMensajes.build(EktCodigosMensajes.OK) : 
						generadorMensajes.build(EktCodigosMensajes.ERROR_CONEXION_TIBCO));
			}
		}
		catch(RetryableException e) {
			LOG.error(generadorMensajes.build(EktCodigosMensajes.CONEXION_WS_FALLIDA));
		}
		
		// Guardar peticion sin importar su estatus
		afectaInventarioService.guardarTransaccion(peticion, jmsMensajeID, estatusPeticion, mensaje, new Date());
		LOG.info(generadorMensajes.build(EktCodigosMensajes.TRANSACCION_GUARDADA, peticion.toString()));
	}

}
