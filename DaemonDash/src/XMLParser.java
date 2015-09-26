
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class XMLParser {

	public void XMLParser(File xmlFile){
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(xmlFile);
			
			document.getDocumentElement().normalize();
			
			
		}catch(Exception e){
			throw new IllegalArgumentException();
		}
	}

	public ArrayList<String> retrieveLinks(){

		throw new IllegalArgumentException();

	}
}
