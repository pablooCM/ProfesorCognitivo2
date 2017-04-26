package logicaDeNegocio;

import java.lang.reflect.*;

import dto.DTO_Documento;

/**
 * Esta clase permite crear objetos de tipo Documento mediante un método de clase
 * @author PEDS_ATI
 *
 */
public class FactoryDocumento {
	
	/**
	 * Permite crear objetos de tipo Documento, ya sean del subtipo PDF o TXT
	 * Utiliza reflect para instanciar las subclases
	 * @param DTO_nuevoDocumento es un objeto con los atributos necesarios para crear el documento
	 * @return nuevoDocumento es el documento que se creará
	 */
	public static Documento crearDocumento(DTO_Documento DTO_nuevoDocumento)
	{
		Documento nuevoDocumento;
	
		try
		{
			Class<?> claseHijaDocumento = Class.forName("logicaDeNegocio."+DTO_nuevoDocumento.getTipoDocumento());
			try
			{
				Constructor<?> constructorDocumento = claseHijaDocumento.getConstructor(new Class[]{DTO_Documento.class});			
				try
				{
					try
					{
						try
						{
							nuevoDocumento = (Documento) constructorDocumento.newInstance(DTO_nuevoDocumento);
							return nuevoDocumento;
							
						}catch (InstantiationException e)
						{
							return null;
						}
					} catch (IllegalAccessException e)
					{
						return null;
					}
				}catch (InvocationTargetException e)
				{
					return null;
				}
				
			}   catch (NoSuchMethodException e){
				return null;
			}
				
		}catch (ClassNotFoundException e)
		{
			return null;
		}
		
	}
}
