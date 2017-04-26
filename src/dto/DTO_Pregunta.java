package dto;

import java.io.Serializable;


/**
 * 
 */
public class DTO_Pregunta implements Serializable{

    
    /**
	 * 
	 */

	private String pregunta;
    private String respuesta;
    private String categoria;
    private String estado;


    public DTO_Pregunta() {

    }

    
    public void setPregunta(String pPregunta) {
        this.pregunta = pPregunta;
        
    }

    public void setCategoria(String pCategoria) {
        this.categoria = pCategoria;
        
    }

    public void setRespuesta(String pRespuesta) {
        
        respuesta = pRespuesta;
    }

    public void setEstado(String pEstado) {
        
        respuesta = pEstado;
    }
   
    
    
    public String getPregunta() {
        
        return this.pregunta;
    }

    public String getCategoria() {
       
        return this.categoria;
    }

    public String getRespuesta() {
        
        return this.respuesta;
    }
    
    public String getEstado() {
        
        return this.estado;
    }

}