package logicaDeNegocio;

import dto.DTO_Pregunta;


/**
 * Clase de patrón creacional Factory Simple.
 * @author PEDS
 * @version 1.0
 */
public class FactoryPregunta {
	
	/**
	 * Crea un nuevo objeto de tipo pregunta
	 * @param DTO_nuevaPregunta
	 * @return Pregunta
	 */
	public static Pregunta crearPregunta(DTO_Pregunta DTO_nuevaPregunta){
		
		Pregunta nuevaPregunta = new Pregunta(DTO_nuevaPregunta);
		return nuevaPregunta;
	}

}
