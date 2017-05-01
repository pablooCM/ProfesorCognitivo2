package logicaDeNegocio;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.solr.client.solrj.SolrServerException;

import logicaDeIntegracion.FactoryConversacion;
import logicaDeIntegracion.FactoryConvertidorVozATexto;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dto.DTO_Consulta;

/**
 * Clase que realiza l consulta, cuando la entrada es un archivo de audio.
 * @author PEDS
 * @version 1.0
 */
public class Voz extends Consulta {

    
    private File contenidoPreguntaAudio; //archivo de audio en formato wav o flac. Contiene el audio con la pregunta.

  /**
   * Constructor de la clase.
   * @param DTO_nuevaConsulta
   */
    public Voz(DTO_Consulta DTO_nuevaConsulta)
    {
    	super();
        this.contenidoPreguntaAudio = DTO_nuevaConsulta.getPreguntaVoz();
    }

 
    
    /**
     * realiza una consulta al servicio de watson.
     * @return ArrayList<String> contenido de las respuestas.
     */
    public ArrayList<String> hacerConsulta() {
    	
    	try {
    		
			return contenidoRespuestas = FactoryConversacion.crearConversacion().consultarPregunta(convertirVozTexto());
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
        
    }

    /**
     * Convierte el contenido del archivo de audio a texto.
     * @return contenidoPreguntaTexto
     */
    private String convertirVozTexto() {
       
    	return contenidoPreguntaTexto = FactoryConvertidorVozATexto.crearVoz_Texto().convertirVozTexto(contenidoPreguntaAudio);
       
    }

   


}