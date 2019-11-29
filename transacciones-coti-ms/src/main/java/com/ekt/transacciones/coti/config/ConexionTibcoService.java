package com.ekt.transacciones.coti.config;

import java.util.Optional;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ekt.transacciones.coti.commons.message.EktCodigosMensajes;
import com.ekt.transacciones.coti.commons.message.EktGeneradorMensajes;

import com.tibco.tibjms.Tibjms;
import com.tibco.tibjms.TibjmsQueueConnectionFactory;

/**
 * 
 * Clase para realizar las funciones de conectar y desconectar con TIBCO, as\u00ed como el env\u00edo y recepci\u00f3n de mensajes
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 *
 */
public class ConexionTibcoService {
	
	/*
	 * Atributos y objetos de la clase \u00fatiles para configurar las conexiones a TIBCO
	 */
	private static Logger LOG = LoggerFactory.getLogger(ConexionTibcoService.class);
	private final EktGeneradorMensajes generadorMensajes = EktGeneradorMensajes.getInstancia();
	
	private String servicio;
	private String host;
	private String puerto;
	private String usuario;
	private String contrasena;
	private String cola;

	/**
	 * M\u00e9todo para crear la cadena de conexi\u00f3n del servicio TIBCO con base al host y al puerto
	 */
	public void crearServicio() {
		servicio = "tcp://" + host + ":" + puerto;
	}
	
	/**
	 * M\u00e9todo para asignar (set) host del servicio TIBCO
	 * @param host Host del servicio TIBCO 
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * M\u00e9todo para asignar (set) el puerto del servicio TIBCO
	 * @param puerto Puerto del servicio TIBCO 
	 */
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	
	/**
	 * M\u00e9todo para asignar (set) el usuario del servicio TIBCO
	 * @param usuario Usuario del servicio TIBCO 
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * M\u00e9todo para asignar (set) la contrase\u00f1a del servicio TIBCO
	 * @param contrasena Contrase\u00f1a del servicio TIBCO 
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	/**
	 * M\u00e9todo para asignar (set) la cola del servicio TIBCO
	 * @param cola Cola del servicio TIBCO 
	 */
	public void setCola(String cola) {
		this.cola = cola;
	}
	
	/*
	 * Atributos y objetos de la clase \u00fatiles para realizar operaciones con TIBCO
	 */
	private ConnectionFactory connectionFactory;
	private Connection conexion;
	private Session sesion;
	private MessageProducer msjProducer;
	private MessageConsumer msjConsumer;
	private TextMessage mensajeEnviado;
	private TextMessage mensajeRecibido;
	private Queue destino;
	private final int ackMode = Tibjms.NO_ACKNOWLEDGE;
	
	/**
	 * M\u00e9todo para crear y establecer conexi\u00f3n hacia el servicio TIBCO
	 * @return VERDADERO en caso de establecer conexi\u00f3n satisfactoriamente, FALSO en caso contrario
	 */
	public boolean conectar() {
		try {
			crearServicio();
			connectionFactory = new TibjmsQueueConnectionFactory(servicio);
			conexion = connectionFactory.createConnection(usuario, contrasena);
			LOG.info(generadorMensajes.build(EktCodigosMensajes.CONEXION_TIBCO_ESTABLECIDA, servicio, cola));
			return true;
		}
		catch(JMSException e) {
			LOG.error(generadorMensajes.build(EktCodigosMensajes.CONEXION_TIBCO_FALLIDA, servicio, cola));
			return false;
		}
	}
	
	/**
	 * M\u00e9todo para cerrar la conexi\u00f3n establecida con el servicio TIBCO  
	 */
	public void cerrarConexion() {
		try {
			conexion.close();
			LOG.info(generadorMensajes.build(EktCodigosMensajes.CONEXION_TIBCO_FINALIZADA, servicio, cola));
		}
		catch(Exception exception) {
			LOG.error(generadorMensajes.build(EktCodigosMensajes.CONEXION_TIBCO_YA_CERRADA));
		}
	}
	
	/**
	 * M\u00e9todo para enviar mensajes en formato JSON con determinados encabezados, al servicio TIBCO
	 * @param peticion Petici\u00f3n a enviar a TIBCO en formato JSON de tipo cadena
	 * @param tienda ID de la tienda asociada a la petici\u00f3n
	 * @return ID del mensaje enviado al servicio TIBCO para su posterior rastreo
	 */
	public String enviarMensaje(String peticion, Integer tienda) {
		try {
			Optional<TextMessage> enviado = Optional.empty();
			sesion = conexion.createSession(true, ackMode);
			destino = sesion.createQueue(cola);
			msjProducer = sesion.createProducer(destino);
			mensajeEnviado = sesion.createTextMessage(peticion);
			mensajeEnviado.setJMSDestination(destino);
	    	mensajeEnviado.setBooleanProperty("JMS_TIBCO_COMPRESS", true);
	    	mensajeEnviado.setIntProperty("PA", 1);
	    	mensajeEnviado.setIntProperty("CA", 1);
	    	mensajeEnviado.setIntProperty("SU", 1);
	    	mensajeEnviado.setIntProperty("TT", tienda);
	    	msjProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
	    	msjProducer.send(mensajeEnviado);
			sesion.commit();
			sesion.close();
			enviado = Optional.ofNullable(mensajeEnviado);
	    	LOG.info((enviado.isPresent() ? 
	    			generadorMensajes.build(EktCodigosMensajes.MENSAJE_ENVIADO, enviado.get().toString()) : 
	    			generadorMensajes.build(EktCodigosMensajes.NO_HAY_MENSAJES)));
	    	return (enviado.isPresent() ? enviado.get().getJMSMessageID().toString() : "");
		}
		catch(JMSException jmsEx) {
			LOG.error(generadorMensajes.build(EktCodigosMensajes.IMPOSIBLE_ENVIAR_MENSAJES));
			return "";
		}
		
	}
	
	/**
	 * M\u00e9todo para recibir mensajes del servicio TIBCO
	 * @return Cuerpo del mensaje recibido del servicio TIBCO para su posterior procesamiento
	 */
	public String recibirMensaje() {
		try {
			Optional<TextMessage> recibido = Optional.empty();
			sesion = conexion.createSession(true, ackMode);
			destino = sesion.createQueue(cola);
			msjConsumer = sesion.createConsumer(destino);
			conexion.start();
			mensajeRecibido = (TextMessage) msjConsumer.receiveNoWait();
	    	conexion.stop();
			sesion.commit();
			sesion.close();
			recibido = Optional.ofNullable(mensajeRecibido);
	    	LOG.info((recibido.isPresent() ? 
	    			generadorMensajes.build(EktCodigosMensajes.MENSAJE_RECIBIDO, recibido.get().toString()) : 
	    			generadorMensajes.build(EktCodigosMensajes.NO_HAY_MENSAJES)));
	    	return (recibido.isPresent() ? recibido.get().getText() : "");
		}
		catch(JMSException jmsEx) {
			LOG.error(generadorMensajes.build(EktCodigosMensajes.IMPOSIBLE_RECIBIR_MENSAJES));
			return "";
		}
	}

}
