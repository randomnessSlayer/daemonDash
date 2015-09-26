package daemondash.newsvisualizer.com;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class RSSFeed {
	private org.w3c.dom.Document doc;
	RSSFeed ( URL fed ) throws IOException, URISyntaxException, ParserConfigurationException{
		BufferedReader in = new BufferedReader(
	    new InputStreamReader(fed.openStream()));
		
		String inputLine;
		String add = "";
		while ((inputLine = in.readLine()) != null){
			 add = add + inputLine ;
		}
		
		in.close();
		
		File tryT = new File (add);
		org.w3c.dom.Document docu = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		docu.setTextContent(add);		
		
		this.doc = docu;
		
	}
		
	public void setDoc ( org.w3c.dom.Document inputDoc ){
		doc = inputDoc;
	}

	public org.w3c.dom.Document getDoc (){
		return doc;
	}
	
	public static void main (String [] args) throws IOException, URISyntaxException, ParserConfigurationException{		
		RSSFeed test = new RSSFeed (new URL("http://rss.cnn.com/rss/cnn_topstories.rss"));
	}
}
