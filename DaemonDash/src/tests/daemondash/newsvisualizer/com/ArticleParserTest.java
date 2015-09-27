package tests.daemondash.newsvisualizer.com;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import daemondash.newsvisualizer.com.ArticleParser;
import daemondash.newsvisualizer.com.StaticVariables;
import daemondash.newsvisualizer.com.Tuple;
import daemondash.newsvisualizer.com.WebReader;
import daemondash.newsvisualizer.com.XMLParser;

public class ArticleParserTest {
	public static void main(String[] args)
			throws IOException, ParserConfigurationException, SAXException, InterruptedException {
		long initTime = System.currentTimeMillis();
		XMLParser xmlParser = new XMLParser(StaticVariables.LIST_OF_ALL_SITES, "pope francis");
		if (xmlParser.foundStuff()) {
			long newTime = System.currentTimeMillis();
			System.out.println("XMLParser Time Lapsed: " + (newTime - initTime) / 1000.0);
			initTime = newTime;
			System.out.println("Num RSS Feeds Used:" + xmlParser.retrieveLinks().size());
			WebReader reader = new WebReader(xmlParser.retrieveLinks());
			newTime = System.currentTimeMillis();
			System.out.println("WebReader Time Lapsed: " + (newTime - initTime) / 1000.0);
			initTime = newTime;
			ArticleParser parser = new ArticleParser("pope francis", reader.getOutputs());
			newTime = System.currentTimeMillis();
			System.out.println("ArticleParser Time Lapsed: " + (newTime - initTime) / 1000.0);
			initTime = newTime;
			for (Tuple<String> s : parser.getMostPopTuples()) {
				System.out.println(s);
			}
		}else{
			System.out.println("Term not found.");
		}
	}

}
