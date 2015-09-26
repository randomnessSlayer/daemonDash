package tests.daemondash.newsvisualizer.com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import daemondash.newsvisualizer.com.ArticleParser;
import daemondash.newsvisualizer.com.WebReader;
import daemondash.newsvisualizer.com.XMLParser;

public class ArticleParserTest {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		ArrayList<String> articles = new ArrayList<String>();
		String article = "LAKE TEKAPO, New Zealand — A college student from New York and another from London have died while kayaking in New Zealand, police said Saturday. Police area commander Dave Gaskin said the pair was part of a group of 11 friends who got into trouble Friday while kayaking on Lake Tekapo. Gaskin told Television New Zealand it was very, very lucky that all 11 students didn’t die after they were struck by strong winds that swamped their vessels and thrust them into the frigid lake water.Rescuers described the survivors as suffering hypothermia and in some cases being incoherent.The students were all attending Monash University in Melbourne, Australia, and were visiting New Zealand during a semester break.Police said those who died were 21-year-old Daniel Hollnsteiner from New York and 20-year-old James Murphy from London.Hollnsteiner’s Facebook page said he had been living in Buffalo and was from Staten Island.Monash University said in a statement that the college community was deeply saddened by the deaths and that it had sent a senior manager to New Zealand to assist the surviving students.Copyright 2015 The Associated Press. All rights reserved. This material may not be published, broadcast, rewritten or redistributed.";
		article = article.toUpperCase();
		articles.add(article);
		File f = new File("C:/test.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(f);
		XMLParser xmlParser = new XMLParser(document, "China");
		ArrayList<String> list = (ArrayList<String>) Arrays.asList("http://www.cnn.com/2015/09/25/politics/china-state-dinner/index.html");
		list.addAll(xmlParser.retrieveLinks());
		WebReader reader = new WebReader(list);
		articles.add(reader.getOutputs().get(0));
		ArticleParser parser = new ArticleParser(articles);
		for (String s : parser.getMostPopWords()) {
			System.out.println(s);
		}
	}

}
