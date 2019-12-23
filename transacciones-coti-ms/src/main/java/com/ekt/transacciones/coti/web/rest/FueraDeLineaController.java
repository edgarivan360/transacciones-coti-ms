package com.ekt.transacciones.coti.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ekt.transacciones.coti.commons.to.MovimientoInventario;
import com.ekt.transacciones.coti.commons.to.RespuestaMovimientoInventario;

@RestController
@RequestMapping("/COTI/FueraDeLinea")
public class FueraDeLineaController {
	
	public static Logger LOG = LoggerFactory.getLogger(FueraDeLineaController.class);
	
	@PostMapping("/peticion")
	RespuestaMovimientoInventario getRespuestaFueraDeLinea(@RequestBody MovimientoInventario peticion) {
		RestTemplate clienteFueraDeLinea = new RestTemplate();
		HttpHeaders encabezado = new HttpHeaders();
		encabezado.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MovimientoInventario> peticionHttp = new HttpEntity<>(peticion, encabezado);
		RespuestaMovimientoInventario respuesta = clienteFueraDeLinea.postForObject( "http://localhost:8080/FueraDeLinea/peticion", peticionHttp, RespuestaMovimientoInventario.class);
		LOG.info("response: " + respuesta);
		return respuesta;
	}

}
