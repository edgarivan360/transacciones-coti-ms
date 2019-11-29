package com.ekt.transacciones.coti.services.service;

import org.springframework.stereotype.Service;

@Service
public interface IConsumidorTibcoService extends Runnable {
	
	public void obtenerMensajesTibco();

}
