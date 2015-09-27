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
		}
		es.shutdown();
		es.awaitTermination(StaticVariables.TIMEOUT, TimeUnit.SECONDS);
	}

	public XMLParser(String feed, final String searchTerm) throws IOException, InterruptedException {
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
					String title = element.getElementsByTag("title").first().text();
					String description = element.getElementsByTag("description").first().text();

					if (title.contains(searchTerm) || description.contains(searchTerm)) {
						links.add(element.getElementsByTag("link").first().text());
					}

				}
			});
		}
		es.shutdown();
		es.awaitTermination(StaticVariables.TIMEOUT, TimeUnit.SECONDS);
	}

	public XMLParser(List<String> feeds) throws IOException, InterruptedException {
		links = new ArrayList<String>();

		for (String feed : feeds) {
			Document doc = Jsoup.connect(feed).get();
			doc = Jsoup.parse(doc.html(), "", Parser.xmlParser());
			Elements elements = doc.getElementsByTag("item");

			ExecutorService es = Executors.newFixedThreadPool(elements.size() / 2);

			for (final Element element : elements) {
				es.submit(new Runnable() {

					@Override
					public void run() {
						String title = element.getElementsByTag("title").first().text();
						String description = element.getElementsByTag("description").first().text();
					}
				});
			}
			es.shutdown();
			es.awaitTermination(StaticVariables.TIMEOUT, TimeUnit.SECONDS);
		}
	}

	public XMLParser(List<String> feeds, final String searchTerm) throws IOException, InterruptedException {
		links = new ArrayList<String>();

		for (String feed : feeds) {
			Document doc = Jsoup.connect(feed).get();
			doc = Jsoup.parse(doc.html(), "", Parser.xmlParser());
			Elements elements = doc.getElementsByTag("item");

			ExecutorService es = Executors.newFixedThreadPool(elements.size() / 2);

			for (final Element element : elements) {
				es.submit(new Runnable() {

					@Override
					public void run() {
						String title = element.getElementsByTag("title").first().text();
						String description = element.getElementsByTag("description").first().text();

						if (title.contains(searchTerm) || description.contains(searchTerm)) {
							links.add(element.getElementsByTag("link").first().text());
						}
					}
				});
			}
			es.shutdown();
			es.awaitTermination(StaticVariables.TIMEOUT, TimeUnit.SECONDS);
		}
	}

	public ArrayList<String> retrieveLinks() {
		return links;
	}
}
