
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
		NodeList nList = createNodeList(xmlFile);
		
		for(int counter = 0; counter < nList.getLength(); counter++){

			Node n = nList.item(counter);

			if(n.getNodeType() == n.ELEMENT_NODE){
				Element e = (Element) n;
				String link = e.getElementsByTagName("link").item(0).getTextContent();
				links.add(link);
			}
		}


	}

	public XMLParser(File xmlFile, String searchTerm){
		
		links = new ArrayList<String>();
		NodeList nList = createNodeList(xmlFile);
		searchTerm = searchTerm.toLowerCase();
		
		for(int counter = 0; counter < nList.getLength(); counter++){
			
			Node n = nList.item(counter);

			if(n.getNodeType() == n.ELEMENT_NODE){
				Element e = (Element) n;
				String title = e.getElementsByTagName("title").item(0).getTextContent()
						.toLowerCase();
				String description = e.getElementsByTagName("description").item(0)
						.getTextContent().toLowerCase();
				if(title.contains(searchTerm) || description.contains(searchTerm)){
					links.add(e.getElementsByTagName("link").item(0).getTextContent());
				}
			}
		}
	}

	public ArrayList<String> retrieveLinks(){
		return links;
	}

	private NodeList createNodeList(File xmlFile){
		try{
			//create a document out of the xml file to parse the elements

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(xmlFile);

			document.getDocumentElement().normalize();

			//creates a list of nodes separated by "item" tags

			NodeList nList = document.getElementsByTagName("item");
			
			return nList;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw new IllegalArgumentException();
		}
	}
}
