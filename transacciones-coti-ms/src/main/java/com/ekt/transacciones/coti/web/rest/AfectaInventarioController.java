package com.ekt.transacciones.coti.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekt.transacciones.coti.commons.to.MovimientoInventario;
import com.ekt.transacciones.coti.services.facade.IAfectaInventarioFacade;

/**
 * 
 * Controlador web REST para el servicio de afectaci\u00f3n de inventario 
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 *
 */
@RestController
@RequestMapping("/COTI/AfectaInventario")
public class AfectaInventarioController {
	
	/*
	 * Objetos de la clase para procesamiento de peticiones rest
	 */
	@Autowired
	private IAfectaInventarioFacade afectaInventarioFacade;

	/**
	 * 
	 * @param peticion
	 */
	@PostMapping("/peticion")
	public void getRespuestaAfectaInventario(@RequestBody MovimientoInventario peticion) {
		afectaInventarioFacade.afectaInventario(peticion);
	}
	
}
