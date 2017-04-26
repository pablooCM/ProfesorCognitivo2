package dto;

import java.io.File;
import java.io.Serializable;
import java.util.*;

/**
 * 
 */

public class DTO_Consulta implements Serializable {

	/**
	 * 
	 */

	private File preguntaVoz;
    private String preguntaTexto;
    private String tipoConsulta;
    private ArrayList<String> respuestas;

    public DTO_Consulta()  {
        respuestas = new ArrayList<String>();
    	
    }
	
	public void setTipoConsulta(String pTipoConsulta) {
	    this.tipoConsulta = pTipoConsulta;
	
	}
	
	public String getTipoConsulta() {
	    
	    return this.tipoConsulta;
	}
    public void setPreguntaTexto(String pPregunta) {
        this.preguntaTexto = pPregunta;

    }
    public void setPreguntaVoz(File pPregunta) {
        this.preguntaVoz = pPregunta;

    }
  
    public String getPreguntaTexto() {
        
        return this.preguntaTexto;
    }
    public File getPreguntaVoz() {
        
        return this.preguntaVoz;
    }

	public ArrayList<String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<String> pRespuestas) {
		this.respuestas = pRespuestas;
	}
    
    
}