import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLParserTest {
	
	public static void main(String[] args) throws IOException, URISyntaxException, ParserConfigurationException, SAXException{
		
		File f = new File("C:/test.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(f);
		XMLParser xmlp = new XMLParser(document,"orange");
		ArrayList<String> links = xmlp.retrieveLinks();
		for(String s : links){
			System.out.println(s);
		}
		
		System.out.println("");
		
		WebReader wr = new WebReader(links);
		for(String string : wr.getOutputs()){
			System.out.println(string);
		}
	}
	
}
