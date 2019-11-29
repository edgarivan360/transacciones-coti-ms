package com.ekt.transacciones.coti.services.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ekt.transacciones.coti.commons.to.MovimientoInventario;
import com.ekt.transacciones.coti.commons.to.RespuestaMovimientoInventario;

@FeignClient(name = "AfectaInventario", url = "${spring.boot.config.manhattan.endpoint.afectaInventario}")
public interface IAfectaInventarioClient {
	
	@PostMapping(value = "/peticion")
	RespuestaMovimientoInventario getRespuestaAfectaInventario(@RequestBody MovimientoInventario peticion);

}
