package tests.daemondash.newsvisualizer.com;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import daemondash.newsvisualizer.com.ArticleParser;
import daemondash.newsvisualizer.com.Tuple;
import daemondash.newsvisualizer.com.WebReader;
import daemondash.newsvisualizer.com.XMLParser;

public class ArticleParserTest {
	private static URL file = ArticleParserTest.class.getResource("/resources/test.xml");

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		ArrayList<String> articles = new ArrayList<String>();
		String article = "LAKE TEKAPO, New Zealand — A college student from New York and another from London have died while kayaking in New Zealand, police said Saturday. Police area commander Dave Gaskin said the pair was part of a group of 11 friends who got into trouble Friday while kayaking on Lake Tekapo. Gaskin told Television New Zealand it was very, very lucky that all 11 students didn’t die after they were struck by strong winds that swamped their vessels and thrust them into the frigid lake water.Rescuers described the survivors as suffering hypothermia and in some cases being incoherent.The students were all attending Monash University in Melbourne, Australia, and were visiting New Zealand during a semester break.Police said those who died were 21-year-old Daniel Hollnsteiner from New York and 20-year-old James Murphy from London.Hollnsteiner’s Facebook page said he had been living in Buffalo and was from Staten Island.Monash University said in a statement that the college community was deeply saddened by the deaths and that it had sent a senior manager to New Zealand to assist the surviving students.Copyright 2015 The Associated Press. All rights reserved. This material may not be published, broadcast, rewritten or redistributed.";
		article = article.toUpperCase();
		articles.add(article);
		String path = file.getPath();
		System.out.println(path);
		File f = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(f);
		XMLParser xmlParser = new XMLParser(document);
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
