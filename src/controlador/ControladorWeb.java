package controlador;



import java.io.IOException;
import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrServerException;

import dto.DTO_Consulta;
import dto.DTO_Documento;
import dto.DTO_Pregunta;
import logicaDeIntegracion.FactoryTraductor;
import logicaDeNegocio.Consulta;
import logicaDeNegocio.Documento;
import logicaDeNegocio.FactoryConsulta;
import logicaDeNegocio.FactoryDocumento;
import logicaDeNegocio.FactoryPregunta;
import logicaDeNegocio.Pregunta;
//import logicaDeNegocio.Consulta;
//import logicaDeNegocio.Registro;

public class ControladorWeb {


	
	/**	 * Permite crear un objeto de tipo Documento, enviando el objeto DTO_nuevoDocumento a la
	 * fábrica encargada de crear dicho documento.
	 * @param DTO_nuevoDocumento contiene los datos necesarios para crear el objeto Documento
	 * @return nuevoDocumento es el objeto creado a partir del DTO_nuevoDocumento
	 */
	public static Documento solicitudCrearDocumento(DTO_Documento DTO_nuevoDocumento)
	{
		Documento nuevoDocumento = FactoryDocumento.crearDocumento(DTO_nuevoDocumento);
		return nuevoDocumento;
	}
	
	
	/**	Permite realizar un nuevo registro de una pregunta y su respuesta, enviando el objeto DTO_nuevaPregunta a la
	 * fábrica encargada de crear la pregunta..
	 * @param DTO_nuevaPregunta contiene los datos necesarios para crear una pregunta.
	 */	
	public static void solicitudRealizarRegistro(DTO_Pregunta DTO_nuevaPregunta) throws SolrServerException, IOException
	{
		solicitudCrearPregunta(DTO_nuevaPregunta).registrarPreguntaRespuesta();
	}
	
	/**
	 * Permite crear una nueva pregunta, enviando el objeto DTO_nuevaPregunta a la fábrica encargada de crear la pregunta.
	 * @param DTO_nuevaPregunta
	 * @return Pregunta
	 */
	private static Pregunta solicitudCrearPregunta(DTO_Pregunta DTO_nuevaPregunta){
		return FactoryPregunta.crearPregunta(DTO_nuevaPregunta);
	}
	
	/**
	 * Crea un objeto de tipo consulta, enviando el objeto DTO_nuevaConsulta a la fábrica encargada de crear la consulta
	 * @param DTO_nuevaConsulta
	 * @return Consulta.
	 */
	
	public static Consulta crearConsulta(DTO_Consulta DTO_nuevaConsulta)
	{
		Consulta nuevaConsulta = FactoryConsulta.crearConsulta(DTO_nuevaConsulta); 
		return nuevaConsulta;

	}
	
	/**
	 * Traduce un texto de español a ingles.
	 * @param pTexto
	 * @return texto traducido.
	 */
	
	public static String solicitudTraducirAIngles(String pTexto)
	{
		return FactoryTraductor.crearTraductor().traducirEspañolIngles(pTexto);
		
	}
	
	/**
	 * Retorna las preguntas asociadas a una categoria. 
	 * @param pCategoria
	 * @return
	 */
	
	public static ArrayList<String> solicitarDatosCategoria(String pCategoria){
		DTO_Consulta nuevaConsulta = new DTO_Consulta();
		nuevaConsulta.setTipoConsulta("Texto");
		return FactoryConsulta.crearConsulta(nuevaConsulta).obtenerDatosCategoria(pCategoria);
	}

}
