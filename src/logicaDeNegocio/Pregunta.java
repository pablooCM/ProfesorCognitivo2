package logicaDeNegocio;

import java.io.IOException;
import java.util.*;

import org.apache.solr.client.solrj.SolrServerException;

import dto.DTO_Pregunta;
import enlaceDeDatos.ConexionBaseDatosRedis;
import logicaDeIntegracion.FactoryConversacion;

/**
 * Clase Pregunta
 * 
 * Contiene los datos de los atributos de una pregunta, así como su respuesta asociada.
 * Se encarga de entrenar el servicio de watson.
 * Realiza la prsistencia de datos.
 * 
 * @author PEDS
 * @version 1.0
 */
public class Pregunta {
	
	private String pregunta;
	private String categoriaPregunta;
	private Respuesta respuesta;

    /**
     * Contructor de la clase
     * @param DTO_Pregunta objeto de transferencia de datos.
     */
    public Pregunta(DTO_Pregunta DTO_nuevaPregunta) 
    {
    	pregunta = DTO_nuevaPregunta.getPregunta();
    	categoriaPregunta = DTO_nuevaPregunta.getCategoria();
    	respuesta = new Respuesta(DTO_nuevaPregunta.getRespuesta());
    	
    }
    
    /**
     * Registra la pregunta con su respuesta asociada.
     * El registro se realiza en una base de datos y se encarga de entrenar el servicio de watson.
     * @throws SolrServerException
     * @throws IOException
     */
    public void registrarPreguntaRespuesta() throws SolrServerException, IOException{
    	registrarBaseDatosRedis(); //Registra en la base  de datos.
    	registrarEnWatson();  // Entrena el servicio de watson.
    }
    
    /**
     * Registra la pregunta en una base de datos Redis.
     */
    private void registrarBaseDatosRedis()
    {
    	ConexionBaseDatosRedis registrar = new ConexionBaseDatosRedis();
    	registrar.insertarDatos(categoriaPregunta, pregunta, respuesta.getRespuesta());

    }
    
    /**
     * Registra la pregunta en Watson para el proceso de entrenamiento.
     * @throws SolrServerException
     * @throws IOException
     */
    
    
    private void registrarEnWatson() throws SolrServerException, IOException
    {
    	FactoryConversacion.crearConversacion().registrarPreguntaRespuesta(categoriaPregunta, pregunta, respuesta.getRespuesta());
    }
    

}