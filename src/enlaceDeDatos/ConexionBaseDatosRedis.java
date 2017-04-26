package enlaceDeDatos;

import java.util.*;

import redis.clients.jedis.Jedis;


/**
 * 
 * @author PEDS
 * @version 1.0
 */
public class ConexionBaseDatosRedis {

	/**
	 * Atributos de la clase.
	 */
	private static Jedis baseDatosRedis;
	private static final String  STRINGCONEXION = "pub-redis-15866.dal-05.1.sl.garantiadata.com";
	private static final int     PUERTO         = 15866;
	private static final String  CONTRASENA     = "pepe1196";
	
    /**
     * Constructor de la clase
     */
    public ConexionBaseDatosRedis() {   	
    	baseDatosRedis = new Jedis(STRINGCONEXION, PUERTO);
    	 baseDatosRedis.auth(CONTRASENA);
    }
    
    /**
     * Inserta en la base de datos redis.
     * @param pCategoria categoria de la pregunta.
     * @param pPregunta 
     * @param pRespuesta
     */
    public void insertarDatos(String pCategoria,String pPregunta, String pRespuesta)
    {
    	baseDatosRedis.lpush(pCategoria, pPregunta , pRespuesta);
    }
    
    /**
     * Obtiene los preguntas y respuestas asociadas a una categoria.
     * @param pCategoria
     * @return ArrayList<String> preguntas y respuestas.
     */
    public ArrayList<String> obtenerDatos(String pCategoria)
    {
    	ArrayList<String> contenido = new ArrayList<String>();
        List<String> list = baseDatosRedis.lrange(pCategoria, 0 ,100);
        for(int i=0; i<list.size(); i++) 
        {
        	contenido.add(list.get(i));
        }
        return contenido;
    }
    
    /**
     * Elimina los registros en la base de datos, asociados a una categoria.
     * @param pCategoria
     */
    public void limpiarBaseDatos(String pCategoria){
    	Set<String> keys = baseDatosRedis.keys(pCategoria);
    	for(String key:keys)
    	{
    		baseDatosRedis.del(key);
    	}
    }

}