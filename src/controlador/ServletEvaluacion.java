package controlador;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.SolrServerException;
import org.codehaus.jackson.map.ObjectMapper;

import dto.DTO_Pregunta;
import logicaDeNegocio.Pregunta;

/**
 * Servlet implementation class ServletRegistro
 * usa un request de tipo x.bluemix.com?estudiante=xxx&evaluacion=xxx
 * donde los paramentros estudiante y evaluacion son los ID de cada uno de esos tipos de datos
 */
@WebServlet("/ServletRegistro")
public class ServletEvaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEvaluacion() {
        super();
        
        // TODO Auto-generated constructor stub
    }
    
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SolrServerException
    {

        String estudiante = request.getParameter("estudiante").toString();
    	String evaluacion = request.getParameter("evaluacion").toString();	
    	
    	//Falta por hacer el DTO de evaluacion  <--------------------
		DTO_Evaluacion nuevaEvaluacion = new DTO_Evaluacion();
		nuevaEvaluacion.setEstudiante(estudiante);
		nuevaEvaluacion.setEvaluacion(evaluacion);
		
		
		ArrayList<String> listaPreguntas = logicaBaseDatos.ConexionBaseDatosRedis.obtenerDatos("preguntas");
		ArrayList<Pregunta> listaParseada = new ArrayList<Pregunta>();
		
		for(String obj : listaPreguntas){
			ObjectMapper mapper = new ObjectMapper();
			Pregunta nuevaPregunta =  (Pregunta) mapper.readValue(obj, Pregunta.class);
			listaParseada.add(nuevaPregunta);
		}
		
		//acá^ jala todas las preguntas, hay que filtrarlas para solo jalar las de
		//la evaluación que se está haciendo ras
		
		nuevaEvaluacion.setPreguntas = listaParseada;
		
		
		ControladorWeb.solicitudRealizarRegistro(nuevaEvaluacion);
        request.setAttribute("DTO_Evaluacion", nuevaEvaluacion);
        request.getRequestDispatcher("hacerEvaluacion.jsp").forward(request, response);
    	
    }    
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request,response);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request,response);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
