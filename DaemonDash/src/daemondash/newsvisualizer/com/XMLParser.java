package daemondash.newsvisualizer.com;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.parser.*;
import org.jsoup.select.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class XMLParser {

	private ArrayList<String> links;

	public XMLParser(String feed) throws IOException, InterruptedException {
		links = new ArrayList<String>();

		Document doc = Jsoup.connect(feed).get();
		doc = Jsoup.parse(doc.html(), "", Parser.xmlParser());
		Elements elements = doc.getElementsByTag("item");

		ExecutorService es = Executors.newFixedThreadPool(elements.size() / 2);
		for (final Element element : elements) {
			es.submit(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					links.add(element.getElementsByTag("link").first().text());
				}
			});
			es.shutdown();
			es.awaitTermination(20, TimeUnit.SECONDS);
		}
	}

	public XMLParser(String feed, String searchTerm) throws IOException {
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

	public XMLParser(List<String> feeds, String searchTerm) throws IOException {
		links = new ArrayList<String>();

		for (String feed : feeds) {
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
	}

	public ArrayList<String> retrieveLinks() {
		return links;
	}
}
