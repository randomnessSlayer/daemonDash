package daemondash.newsvisualizer.com;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.parser.*;
import org.jsoup.select.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class XMLParser {

	private ArrayList<String> links;

	public XMLParser(String feed) throws IOException {
		links = new ArrayList<String>();
		
		Document doc = Jsoup.connect(feed).get();
		doc = Jsoup.parse(doc.html(), "", Parser.xmlParser());
		Elements elements = doc.getElementsByTag("item");
		
		for (Element element : elements) {
			links.add(element.getElementsByTag("link").first().text());
		}
	}

	public XMLParser(String feed, String searchTerm) throws IOException{
		links = new ArrayList<String>();
		
		Document doc = Jsoup.connect(feed).get();
		doc = Jsoup.parse(doc.html(), "", Parser.xmlParser());
		Elements elements = doc.getElementsByTag("item");
		
		for (Element element : elements) {
			String title = element.getElementsByTag("title").first().text();
			String description = element.getElementsByTag("description").first().text();
			
			if (title.contains(searchTerm) || description.contains(searchTerm)) {
				links.add(element.getElementsByTag("link").first().text());
			}
		}
	}

	public ArrayList<String> retrieveLinks(){
		return links;
	}
}
