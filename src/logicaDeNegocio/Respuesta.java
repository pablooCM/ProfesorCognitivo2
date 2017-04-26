package logicaDeNegocio;

/**
 * Crea la respuesta asociada a una pregunta.
 * 
 * @author PEDS
 *@version 1.0
 *
 */
public class Respuesta {

	private String respuesta;
	private String estado;
   
	/**
     * Constructor de la clase.
     * @param String de la respuesta.
     */
    public Respuesta(String pRespuesta) 
    {
    	respuesta = pRespuesta;
    }
    
    // GETTERS AND SETTERS.
    
	public String getEstado() 
	{
		return estado;
	}
	
	public void setEstado(String pEstado)
	{
		this.estado = pEstado;
	}
	
	public String getRespuesta() 
	{
		return respuesta;
	}
   
}