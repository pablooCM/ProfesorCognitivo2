package logicaDeIntegracion;


/**
 * Clase de patrón creacional Factory Simple.
 * @author PEDS
 * @version 1.0
 */
public class FactoryConvertidorVozATexto {
	
	
	/**
	 * Crea un nuevo objeto de tipo ConvertidorVozATexto.
	 * @return ConvertidorVozATexto.
	 */
	public static IVoz_Texto crearVoz_Texto(){
	    IVoz_Texto nuevoConvertidorVozATexto = new ConvertidorVozATexto();
	    return nuevoConvertidorVozATexto;
	}

}
