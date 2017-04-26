package logicaDeNegocio;


import dto.DTO_Documento;

/**
 * Esta clase crea objetos de tipo PDF
 * @author PEDS_ATI
 *
 */
public class PDF extends Documento{
	
	/**
	 * Es el constructor de la clase PDF
	 * @param DTO_nuevoDocumento es el objeto que contiene todos los atributos necesarios para
	 * crear el PDF. La mayor�a de atributos los posee la super clase Documento.
	 */
	public PDF(DTO_Documento DTO_nuevoDocumento ){
		super(DTO_nuevoDocumento);
		
	}
}
