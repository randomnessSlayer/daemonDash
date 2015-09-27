package tests.daemondash.newsvisualizer.com;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import daemondash.newsvisualizer.com.WebReader;
import daemondash.newsvisualizer.com.XMLParser;

public class XMLParserTest {
	
	public static void main(String[] args) throws IOException, URISyntaxException, ParserConfigurationException, SAXException, InterruptedException{
		XMLParser xmlp = new XMLParser("http://rss.cnn.com/rss/cnn_topstories.rss", "orange");
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
