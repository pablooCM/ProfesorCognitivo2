package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import dto.DTO_Documento;
import logicaDeNegocio.PDF;


/**
 * Servlet implementation class ServletCatalogo
 */
@WebServlet(name = "ServletCatalogo", urlPatterns = {"/ServletCatalogo"})
@MultipartConfig
public class ServletCatalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCatalogo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
     	 ServletOutputStream os = response.getOutputStream();
       	 
       	String tipoDocumento = request.getParameter("comboFormatos");
       	String categoria = request.getParameter("tipo").toString();
       	String idioma = request.getParameter("idioma").toString();
       	
     	ArrayList<String> respuestas =  ControladorWeb.solicitarDatosCategoria(categoria);
       	String contenido = "";
     	
       	 DTO_Documento DTO_nuevoDocumento = new DTO_Documento();
       	 DTO_nuevoDocumento.setAutor("Watson Tutor: Catalogo Preguntas "+ categoria);
       	 
       	 DTO_nuevoDocumento.setTipoDocumento(tipoDocumento);
       	 
       	 if(tipoDocumento.equals("PDF"))
       	 {	
       		 int cont =1;
       		 for(int i =0; i<respuestas.size(); i=i+2){
       			 contenido += " "+cont++ + " -Pregunta: "+respuestas.get(i+1) + " \n "+" respuesta: "+respuestas.get(i) +" \n\n "  ;
       		 }
       		 
       		 if(idioma.equals("ingles")){
       			 contenido = ControladorWeb.solicitudTraducirAIngles(contenido);
       		 }
       		 
       		DTO_nuevoDocumento.setContenido( contenido );
       	
       		 
       		 PDF nuevoDocumento = (PDF)ControladorWeb.solicitudCrearDocumento(DTO_nuevoDocumento);
       		 
       		response.setContentType("application/pdf"); 
          	response.setHeader("Content-Disposition","attachment;filename=Documento_Watson_Tutor.pdf");
          	 
       	     try{
       	    	
       	    	 Document doc = new Document();
       	    	 PdfWriter.getInstance(doc, os);
       	    	  
       	    	 doc.addAuthor(nuevoDocumento.getAutor());
       		     doc.addCreationDate();
       		     doc.addTitle("Documento "+nuevoDocumento.getAutor());
       		     doc.setPageSize(PageSize.LETTER);
       		     doc.open();

       		     doc.add( new Paragraph(nuevoDocumento.getTitulo()+"\n\n"));
       		     doc.add( new Paragraph(nuevoDocumento.getContenido()));
       		     doc.close(); 

       	     }catch(DocumentException e){
       	    	 e.printStackTrace();
       	     }
       	  
       	     catch(Exception e){
       	    	 e.printStackTrace();
       	     }
       	     
       	     
       	 }
       	 
       	 
     }

    	
    	
    	
    	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
