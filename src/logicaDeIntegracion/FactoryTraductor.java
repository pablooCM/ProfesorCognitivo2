package logicaDeIntegracion;


/**
 * Clase de patrón creacional Factory Simple.
 * @author PEDS
 * @version 1.0
 */
public class FactoryTraductor {
	
	
	/**
	 * Crea un nuevo objeto de tipo Traductor..
	 * @return Traductor.
	 */	
	public static ITraductor crearTraductor(){
		ITraductor nuevoTraductor = new Traductor();
		return  nuevoTraductor;
	}

}
