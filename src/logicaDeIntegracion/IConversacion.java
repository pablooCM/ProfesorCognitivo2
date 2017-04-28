package logicaDeIntegracion;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrServerException;

public interface IConversacion {
	
	public abstract ArrayList<String> consultarPregunta( String pPregunta)throws SolrServerException, IOException;
	public abstract void registrarPreguntaRespuesta(String pCategoria, String pPregunta, String pRespuesta)throws SolrServerException, IOException;

}
