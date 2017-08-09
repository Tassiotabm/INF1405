package data;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class MeteorologicalData{

	private String [] meteoData = new String[8];
	
	public String [] getMeteoData(){
		return meteoData;
	}

	public MeteorologicalData() throws ParserConfigurationException, MalformedURLException, SAXException, IOException{
		
        String urlString = "http://servicos.cptec.inpe.br/XML/estacao/SBGL/condicoesAtuais.xml";
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL(urlString).openStream());
       
        doc.getDocumentElement().normalize();
        meteoData[0] = doc.getElementsByTagName("atualizacao").item(0).getTextContent();
        meteoData[1] = doc.getElementsByTagName("pressao").item(0).getTextContent();
        meteoData[2] = doc.getElementsByTagName("temperatura").item(0).getTextContent();
        meteoData[3] = doc.getElementsByTagName("tempo_desc").item(0).getTextContent();
        meteoData[4] = doc.getElementsByTagName("umidade").item(0).getTextContent();
        meteoData[5] = doc.getElementsByTagName("vento_dir").item(0).getTextContent();
        meteoData[6] = doc.getElementsByTagName("vento_int").item(0).getTextContent();
        meteoData[7] = doc.getElementsByTagName("visibilidade").item(0).getTextContent();

	}
}

