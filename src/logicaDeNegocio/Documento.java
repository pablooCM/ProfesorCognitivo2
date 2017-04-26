package logicaDeNegocio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dto.DTO_Documento;

/**
 * Esta super clase permite crear objetos de tipo Documento
 * @author PEDS_ATI
 *
 */
public abstract class Documento {
	
	protected String titulo;
	protected String contenido;
	protected Date fechaCreacion;
	protected String tipoDocumento;
	protected String autor;
	
	
	/**
	 * Este es el constructor de la clase y recibe un DTO_Documento con los atributos
	 * necesarios para crear el Documento
	 */
	public Documento(DTO_Documento DTO_nuevoDocumento)
	{	
		autor = DTO_nuevoDocumento.getAutor();
		contenido = DTO_nuevoDocumento.getContenido();
		tipoDocumento = DTO_nuevoDocumento.getTipoDocumento();
		setFechaCreacion();
		titulo = autor+"  |  "+getFechaCreacion();
		
	}
	
	/**
	 * Este m�todo permite obtener la fecha de creaci�n de un documento con el
	 * formato d�a/mes/a�o
	 */
	public String getFechaCreacion(){
		SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
		return mascara.format(fechaCreacion);
	}
	
	/**
	 * Permite establecer la fecha de creaci�n del documento
	 * Dicha fecha es obtenida del sistema
	 */
	public void setFechaCreacion(){
		Calendar calendario;
		calendario = Calendar.getInstance();
		fechaCreacion = calendario.getTime();
	}
	
	/**
	 * Permite obtener el autor del documento
	 * @return autor es un string con el nombre del autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Permite obtener el t�tulo que llevar� el documento
	 * @return  titulo es un string que se compone del nombre del autor y la fecha de creaci�n
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Este m�todo permite obtener el contenido del documeno
	 * @return contenido es un string con el texto del documento
	 */
	public String getContenido() {
		return contenido;
	}
	
}
