package logicaDeIntegracion;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;



/**
 * Clase que se encarga de conectar el servicio de watson de traducir.
 * @author pakelean
 * @version 1.0
 */
public class Traductor implements ITraductor {

	private LanguageTranslation servicioTraducir;
	private final static String NOMBREUSUARIO = "44ffda95-3824-4e51-990d-01f456e360a6";
	private final static String CONTRASENA = "svjKOTn0zxcL";
	
	/**
	 * Constructor de la clase.
	 */
	public Traductor(){
		servicioTraducir =  new LanguageTranslation();
		servicioTraducir.setUsernameAndPassword(NOMBREUSUARIO, CONTRASENA);
	}
	
	/**
	 * Traduce un texto de español a ingles.
	 * @param pTexto. 
	 */
	public String traducirEspanolIngles(String pTexto)
	{
		TranslationResult resultadoTraduccion = servicioTraducir.translate(pTexto,Language.SPANISH,Language.ENGLISH).execute();
	    return obtenerRespuesta(resultadoTraduccion.toString());
	}
	
	
	/**
	 * Procesa el Json que retorna el consumir el servicio de watson para obtener la respuesta.
	 * @param pRespuesta
	 * @return textoTraducido.
	 */
	private String obtenerRespuesta(String pRespuesta)
	{
		JsonElement jelement = new JsonParser().parse(pRespuesta);
	    JsonObject  jobject = jelement.getAsJsonObject();
	    
	    JsonArray jarray = jobject.getAsJsonArray("translations");
	    jelement = jarray.get(0);
	    jobject = jelement.getAsJsonObject();
	    String respuesta = jobject.get("translation").toString();  
	    return respuesta.replace('"', ' ');
	}
}
