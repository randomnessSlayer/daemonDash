
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class XMLParser {
	
	private ArrayList<String> links;
	
	public XMLParser(File xmlFile){
		
		links = new ArrayList<String>();
		
		try{
			
			//create a document out of the xml file to parse the elements
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(xmlFile);
			
			document.getDocumentElement().normalize();
			
			//creates a list of nodes separated by "item" tags
			
			NodeList nList = document.getElementsByTagName("item");
			
			for(int counter = 0; counter < nList.getLength(); counter++){
				
				Node n = nList.item(counter);
				
				if(n.getNodeType() == n.ELEMENT_NODE){
					Element e = (Element) n;
					String link = e.getElementsByTagName("link").item(0).getTextContent();
					links.add(link);
				}
				
				
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public XMLParser(File xmlFile, String searchTerm){
		
	}
	
	public ArrayList<String> retrieveLinks(){

		return links;

	}
}
