package daemondash.newsvisualizer.com;

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

	public XMLParser(Document xmlFile){

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

	public XMLParser(Document xmlFile, String searchTerm){
		
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

	private NodeList createNodeList(Document xmlFile){
		try{
			//create a document out of the xml file to parse the element

			xmlFile.getDocumentElement().normalize();

			//creates a list of nodes separated by "item" tags

			NodeList nList = xmlFile.getElementsByTagName("item");
			
			return nList;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw new IllegalArgumentException();
		}
	}
}
