package logicaDeNegocio; 
import java.lang.reflect.*; 
import dto.DTO_Consulta; 

/**
 * Clase de patrón creacional Factory Simple.
 * @author PEDS
 * @version 1.0
 */
public class FactoryConsulta { 

	/**
	 * Crea un nuevo objeto de tipo Consulta.
	 * @param DTO_nuevaConsulta
	 * @return Consulta Voz/Texto.
	 */
	public static Consulta crearConsulta(DTO_Consulta DTO_nuevaConsulta) { 
		Consulta nuevaConsulta; 
		try { 
		    Class<?> claseHijaConsulta = Class.forName("logicaDeNegocio."+DTO_nuevaConsulta.getTipoConsulta()); 
			try 
			{ 
				Constructor<?> constructorConsulta = claseHijaConsulta.getConstructor(new Class[]{DTO_Consulta.class}); 
				try 
				{ 
				   try 
				   { 
					try 
					{ 
						nuevaConsulta = (Consulta) constructorConsulta.newInstance(DTO_nuevaConsulta); 
						return nuevaConsulta; 
					}catch (InstantiationException e) 
					{ 
						return null; 
				    } 
					}
				   catch (IllegalAccessException e) { return null; 
				}
				   }catch (InvocationTargetException e) { return null; 
			} } catch (NoSuchMethodException e){ return null; 
		} }catch (ClassNotFoundException e) { return null; } 
	} 
}