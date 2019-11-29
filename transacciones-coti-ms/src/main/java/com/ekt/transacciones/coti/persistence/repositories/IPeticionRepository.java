package com.ekt.transacciones.coti.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ekt.transacciones.coti.model.Peticion;

/**
 * 
 * Interfaz para manipular, controlar y consultar los datos de la entidad (tabla) Peticion (PETICION) 
 * 
 * @author Edgar Quiroz
 * @version 1.0 21/11/19
 *
 */
@Repository
public interface IPeticionRepository extends JpaRepository<Peticion, Integer> {
	
	/**
	 * M\u00e9todo para obtener las peticiones (transacciones) que se procesaron correctamente en los sistemas involucrados (Manhattan, TIBCO y COTI)
	 * @param idMovimientoCOTI ID \u00fanico de movimiento (transacci\u00f3n) en COTI
	 * @return Objeto de tipo Peticion
	 * @see com.ekt.transacciones.coti.model.Peticion
	 */
	@Query("	SELECT p "
			+ "	  FROM Peticion p "
			+ "  WHERE IDMOVIMIENTOCOTI = :idMovimientoCOTI"
			+ "	   AND ESTATUSPETICION = '1'"
			+ "	   AND MENSAJE = 'OK'")
	public Peticion obtenerMensajeProcesado(Integer idMovimientoCOTI);

}

