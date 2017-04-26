package logicaDeNegocio;

import java.util.*;



import enlaceDeDatos.ConexionBaseDatosRedis;

/**
 * Clase Consulta.
 * Consume los servicios de watson.
 * @author PEDS
 * @version 1.0
 */
public abstract class Consulta {

    
	
	/**
	 * Atributos de la clase.
	 */
    protected ArrayList<String> contenidoRespuestas;
    protected String contenidoPreguntaTexto;
    protected boolean estadoRespuesta;

    public Consulta() {
    
       contenidoRespuestas = new ArrayList<String>();
    }

   /**
    * Metodo abstracto, que difiere del tipo de consulta, sea por voz o texto.
    * @return ArrayList con el contenido de las respuestas.
    */
    public abstract ArrayList<String> hacerConsulta();

 
    /**
     * Obtiene los datos registrados para una categoria: UML, Principios de diseño, POO.
     * @param pCategoria
     * @return ArrayList datos de una categoria.
     */
    public  ArrayList<String> obtenerDatosCategoria(String pCategoria)
    {
    	ConexionBaseDatosRedis obtenerDatos = new ConexionBaseDatosRedis();
    	return obtenerDatos.obtenerDatos(pCategoria);
    	
    }
    
    

    /**
     * Getter and setters
     */
    
    public void setContenidoPregunta(String pContenidoPregunta) {
        
    	this.contenidoPreguntaTexto = pContenidoPregunta;
       
    }

   
    public String getContenidoPregunta() {
        
        return this.contenidoPreguntaTexto;
    }

}