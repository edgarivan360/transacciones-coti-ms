package com.ekt.transacciones.coti.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ekt.transacciones.coti.config.ConexionTibcoConfig;
import com.ekt.transacciones.coti.config.ConexionTibcoService;
import com.ekt.transacciones.coti.services.service.IConsumidorTibcoService;
import com.ekt.transacciones.coti.services.service.impl.RespuestaTibcoServiceImpl;

/**
 * 
 * Clase principal para inicializaci\u00f3n del microservicio
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.ekt.transacciones.coti")
@EntityScan(basePackages = "com.ekt.transacciones.coti.model")
@EnableJpaRepositories(basePackages = "com.ekt.transacciones.coti.persistence.repositories")
@EnableFeignClients(basePackages = "com.ekt.transacciones.coti.services")
public class TransaccionesCotiMsApplication implements CommandLineRunner {
	
	/**
	 * M\u00e9todo para generar bean asociado a la clase ConexionTibcoConfig
	 * @return Bean/Instancia de tipo ConexionTibcoConfig
	 * @see com.ekt.transacciones.coti.config.ConexionTibcoConfig
	 */
	@Bean
	public ConexionTibcoConfig getConexionTibcoConfig() {
		return new ConexionTibcoConfig();
	}
	
	/**
	 * M\u00e9todo para generar bean asociado a la clase ConexionTibcoService. Se utiliza el scope "prototype" para generar una instancia por bean, ya que \u00e9stos tienen diferentes par\u00e1metros de configuraci\u00f3n
	 * @return Bean/Instancia de tipo ConexionTibcoService
	 * @see com.ekt.transacciones.coti.config.ConexionTibcoService
	 */
	@Bean
	@Scope(value="prototype")
	public ConexionTibcoService getConexionTibcoService() {
		return new ConexionTibcoService();
	}
	
	/**
	 * M\u00e9todo para generar bean asociado a la interface IConsumidorTibcoService.
	 * @return Bean/Instancia de tipo RespuestaTibcoServiceImpl
	 * @see com.ekt.transacciones.coti.services.service.IConsumidorTibcoService
	 * @see com.ekt.transacciones.coti.services.service.impl.RespuestaTibcoServiceImpl
	 */
	@Bean
	public IConsumidorTibcoService getRespuestaTibcoServiceImpl() {
		return new RespuestaTibcoServiceImpl();
	}

	/**
	 * M\u00e9todo para iniciar hilos que realizar\u00e1n el consumo de mensajes de TIBCO una vez iniciado el microservicio
	 */
	@Override
	public void run(String... args) {
		Thread respuestaTibcoThread = new Thread(getRespuestaTibcoServiceImpl());
		respuestaTibcoThread.setName("tibcoResp-0");
		respuestaTibcoThread.start();
	}
	
	/**
	 * M\u00e9todo principal. Inicializaci\u00f3n del microservicio
	 * @param args Argumentos de tipo cadena para el m\u00e9todo principal
	 */
	public static void main(String[] args) {
		SpringApplication.run(TransaccionesCotiMsApplication.class, args);
	}
	
}
