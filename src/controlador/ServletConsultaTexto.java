package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.SolrServerException;

import dto.DTO_Consulta;
import logicaDeNegocio.Texto;

/**
 * Servlet implementation class ServletConsultaTexto
 */
@WebServlet(name = "ServletConsultaTexto", urlPatterns = {"/ServletConsultaTexto"})
@MultipartConfig
public class ServletConsultaTexto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaTexto() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void procesarRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SolrServerException
    {
    	String pregunta = request.getParameter("pregunta");
    	DTO_Consulta nuevaConsulta = new DTO_Consulta();
    	nuevaConsulta.setPreguntaTexto(pregunta);
    	nuevaConsulta.setTipoConsulta("Texto");
    	Texto consultaTexto = (Texto)ControladorWeb.crearConsulta(nuevaConsulta);
    	nuevaConsulta.setRespuestas(consultaTexto.hacerConsulta());
    	
    	
        request.setAttribute("DTO_Consulta", nuevaConsulta);
        request.getRequestDispatcher("respuestaConsulta.jsp").forward(request, response);
    	
    	
    	
    	
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
			procesarRequest(request, response);
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
			procesarRequest(request, response);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
