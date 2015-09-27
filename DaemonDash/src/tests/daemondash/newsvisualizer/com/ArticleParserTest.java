package tests.daemondash.newsvisualizer.com;

import java.io.IOException;
import java.util.ArrayList;

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
		ArrayList<String> articles = new ArrayList<String>();
		XMLParser xmlParser = new XMLParser(StaticVariables.LIST_OF_ALL_SITES);
		ArrayList<String> list = new ArrayList<String>();
		list.add("http://www.cnn.com/2015/09/25/politics/china-state-dinner/index.html");
		list.addAll(xmlParser.retrieveLinks());
		System.out.println(list.size());
		WebReader reader = new WebReader(list);
		articles.addAll(reader.getOutputs());
		ArticleParser parser = new ArticleParser(articles);
		for (Tuple<String> s : parser.getMostPopTuples()) {
			System.out.println(s);
		}
	}

}
