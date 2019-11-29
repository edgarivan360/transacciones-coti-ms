package com.ekt.transacciones.coti.services.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ekt.transacciones.coti.commons.to.FueraDeLinea;
import com.ekt.transacciones.coti.commons.to.RespuestaFueraDeLinea;

@FeignClient(name = "FueraDeLinea", url = "${spring.boot.config.manhattan.endpoint.fueraDeLinea}")
public interface IFueraDeLineaClient {

	@PostMapping(value = "/peticion")
	RespuestaFueraDeLinea getRespuestaFueraDeLinea(@RequestBody FueraDeLinea peticion);
	
}
