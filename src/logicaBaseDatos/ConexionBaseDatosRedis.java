package logicaBaseDatos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import redis.clients.jedis.Jedis;

public class ConexionBaseDatosRedis {
	
	/**
	 * Atributos de la clase.
	 */
	private static Jedis jedis = new Jedis("redis://admin:QZJGSFLDJVNJDVQK@sl-us-dal-9-portal.6.dblayer.com:23420"); 

    
    public static void insertarObjeto(String pLista, Object pObject){
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			String jsonInString = mapper.writeValueAsString(pObject);
			System.out.println(jsonInString);
			jedis.lpush(pLista, jsonInString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
    /**
     * Obtiene los preguntas y respuestas asociadas a una categoria.
     * @param pCategoria
     * @return ArrayList<String> preguntas y respuestas.
     */
    public static ArrayList<String> obtenerDatos(String pLista)
    {
    	ArrayList<String> contenido = new ArrayList<String>();
        List<String> list = jedis.lrange(pLista, 0 ,-1);
        for(int i=0; i<list.size(); i++){
        	contenido.add(list.get(i));
        }
        return contenido;
    }
    
    /**
     * Elimina los registros en la base de datos, asociados a una categoria.
     * @param pLista
     */
    public static void limpiarBaseDatos(String pLista){
    	Set<String> keys = jedis.keys(pLista);
    	for(String key:keys)
    	{
    		jedis.del(key);
    	}
    }
    
    /*	
     
     public static void main(String[] args) { 
 
		App testApp = new App("Twitter", "2.8.0");
		insertarObjeto("apps", testApp );
		    
		ArrayList<String> resultados = obtenerDatos("apps");
		System.out.println(resultados.toString());
   
     } 
      
    */
    

}