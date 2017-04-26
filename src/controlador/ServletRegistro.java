package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.SolrServerException;

import dto.DTO_Pregunta;

/**
 * Servlet implementation class ServletRegistro
 */
@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistro() {
        super();
        
        // TODO Auto-generated constructor stub
    }
    
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SolrServerException
    {

        String pregunta = request.getParameter("pregunta").toString();
    	String categoria = request.getParameter("tipo").toString();
    	String respuesta = request.getParameter("respuesta");    	
    	
		DTO_Pregunta nuevaPregunta = new DTO_Pregunta();
		nuevaPregunta.setCategoria(categoria);
		nuevaPregunta.setPregunta(pregunta);
		nuevaPregunta.setRespuesta(respuesta);
		
		ControladorWeb.solicitudRealizarRegistro(nuevaPregunta);
        request.setAttribute("DTO_Pregunta", nuevaPregunta);
        request.getRequestDispatcher("respuestaRegistro.jsp").forward(request, response);
    	
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
