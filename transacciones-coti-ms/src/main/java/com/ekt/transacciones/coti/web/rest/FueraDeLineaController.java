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

import com.ekt.transacciones.coti.commons.to.FueraDeLinea;
import com.ekt.transacciones.coti.commons.to.RespuestaFueraDeLinea;

@RestController
@RequestMapping("/COTI/FueraDeLinea")
public class FueraDeLineaController {
	
	public static Logger LOG = LoggerFactory.getLogger(FueraDeLineaController.class);
	
	@PostMapping("/peticion")
	RespuestaFueraDeLinea getRespuestaFueraDeLinea(@RequestBody FueraDeLinea peticion) {
		RestTemplate clienteFueraDeLinea = new RestTemplate();
		HttpHeaders encabezado = new HttpHeaders();
		encabezado.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<FueraDeLinea> peticionHttp = new HttpEntity<>(peticion, encabezado);
		RespuestaFueraDeLinea respuesta = clienteFueraDeLinea.postForObject( "http://localhost:8080/FueraDeLinea/peticion", peticionHttp, RespuestaFueraDeLinea.class);
		LOG.info("response: " + respuesta);
		return respuesta;
	}

}
