package com.ekt.transacciones.coti.services.facade;

import org.springframework.stereotype.Service;

import com.ekt.transacciones.coti.commons.to.MovimientoInventario;

@Service
public interface IAfectaInventarioFacade {
	
	public void afectaInventario(MovimientoInventario peticion);

}
