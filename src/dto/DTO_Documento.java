package dto;

import java.util.Date;

/**
 * Esta clase permite crear objetos de tipo DTO_Documento que permite transportar
 * atributos de los objetos de tipo documento. Solo posee m�todos getter y setter 
 * para obtener y establecer sus atributos.
 * @author PEDS_ATI
 *
 */
public class DTO_Documento {
	
	private String autor;
	private String contenido;
	private String tipoDocumento;
	private String titulo;
	private Date fechaCreacion;
	
	public String getContenido() {
		return contenido;
	}

	public void setContenido(String pContenido) {
		this.contenido = pContenido;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String pTipoDocumento) {
		this.tipoDocumento = pTipoDocumento;
	}
	
	public String getTitulo()
	{
		return titulo;
	}
	
	public void setTitulo(String pTitulo)
	{
		titulo = pTitulo;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String pAutor) {
		this.autor = pAutor;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date pFechaCreacion) {
		this.fechaCreacion = pFechaCreacion;
	}
}
