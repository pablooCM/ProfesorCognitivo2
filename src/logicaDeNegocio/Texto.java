package logicaDeNegocio;

import java.io.IOException;
import java.util.*;

import org.apache.solr.client.solrj.SolrServerException;

import logicaDeIntegracion.FactoryConversacion;
import dto.DTO_Consulta;

/**
 * Clase que realiza consultas, cuando se realizan desde teclado.
 * @author PEDS
 * @version 1.0
 */
public class Texto extends Consulta {
	
    /**
     * Constructor de la clase.
     * @param DTO_nuevaConsulta
     */
    public  Texto(DTO_Consulta DTO_nuevaConsulta) {
    	super();
        this.contenidoPreguntaTexto =  DTO_nuevaConsulta.getPreguntaTexto(); 
    }

   /**
    * Método que realiza la consulta al servicio de watson.
    * @return ArrayList<String> Respuestas
    */
    public ArrayList<String> hacerConsulta() {
        
    	try {
			return contenidoRespuestas = FactoryConversacion.crearConversacion().consultarPregunta(contenidoPreguntaTexto);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
        
    }

}