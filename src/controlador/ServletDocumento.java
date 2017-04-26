package controlador;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import logicaDeNegocio.PDF;
import dto.DTO_Documento;

/**
 * Servlet implementation class ServletDocumento
 */
@WebServlet("/crearDocumento")

/*
 *Este servlet permite capturar las peticiones de crear documentos y obtener los datos de dicho documentos
 *Como respuesta genera el documento 
 */
public class ServletDocumento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Este es el constructor de la clase
     * @see HttpServlet#HttpServlet()
     */
    public ServletDocumento() {
        super();
        
    }

    /*
     * este m�todo es el que captura la petici�n y pasa el request y response al m�todo doPost
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request, response);
    }

    /*
     * 	Este m�todo crea un objeto Documento a trav�s del controlador y luego genera el documento con
     * el formato requerido.
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 
   	 ServletOutputStream os = response.getOutputStream();
   	 
   	 String tipoDocumento = request.getParameter("comboFormatos");
   	 String pregunta = request.getParameter("pregunta");
   	 String respuestas =  request.getParameter("respuestas");
   	 
   	 DTO_Documento DTO_nuevoDocumento = new DTO_Documento();
   	 DTO_nuevoDocumento.setAutor("Watson Tutor: Diseño de Software");
   	 DTO_nuevoDocumento.setTipoDocumento(tipoDocumento);
   	 
   	 if(tipoDocumento.equals("PDF"))
   	 {	
   		DTO_nuevoDocumento.setContenido("Pregunta: "+ pregunta + "\n\n"+" Respuestas: "+"\n" + respuestas );	 
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

}
