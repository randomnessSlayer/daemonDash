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
	private int throwOutCounter = 0;
	private boolean foundStuff;

	public XMLParser(String feed) throws InterruptedException {
		links = new ArrayList<String>();

		try {
			Document doc = Jsoup.connect(feed).timeout(StaticVariables.TIMEOUT * 200).get();
			doc = Jsoup.parse(doc.html(), "", Parser.xmlParser());
			Elements elements = doc.getElementsByTag("item");

			ExecutorService es = Executors
					.newFixedThreadPool(Math.min(StaticVariables.MAX_THREADS, (elements.size() + 1) / 2));

			for (final Element element : elements) {
				es.submit(new Runnable() {

					@Override
					public void run() {
						links.add(element.getElementsByTag("link").first().text());
					}
				});
			}
			es.shutdown();
			es.awaitTermination(StaticVariables.TIMEOUT, TimeUnit.SECONDS);
		} catch (IOException e) {
			System.err.println(e.getMessage() + ": Excluding link. (#" + throwOutCounter + ") Feed: " + feed);
		}
		foundStuff = (links.size() > 0);
	}

	public XMLParser(String feed, final String searchTerm) throws InterruptedException {
		links = new ArrayList<String>();
		final String term = searchTerm.replaceAll("\\p{Punct}", " ").toUpperCase();

		try {
			Document doc = Jsoup.connect(feed).timeout(StaticVariables.TIMEOUT * 200).get();
			doc = Jsoup.parse(doc.html(), "", Parser.xmlParser());
			Elements elements = doc.getElementsByTag("item");

			ExecutorService es = Executors
					.newFixedThreadPool(Math.min(StaticVariables.MAX_THREADS, (elements.size() + 1) / 2));

			for (final Element element : elements) {
				es.submit(new Runnable() {

					@Override
					public void run() {
						String title = element.getElementsByTag("title").first().text().toUpperCase();
						String description = element.getElementsByTag("description").first().text().toUpperCase();

						if (title.contains(term) || description.contains(term)) {
							links.add(element.getElementsByTag("link").first().text());
						}

					}
				});
			}
			es.shutdown();
			es.awaitTermination(StaticVariables.TIMEOUT, TimeUnit.SECONDS);
		} catch (

		IOException e)

		{
			System.err.println(e.getMessage() + ": Excluding link. (#" + throwOutCounter + ") Feed: " + feed);
		}
		foundStuff = (links.size() > 0);
	}

	public XMLParser(List<String> feeds) throws InterruptedException {
		links = new ArrayList<String>();

		ExecutorService es = Executors
				.newFixedThreadPool(Math.min(StaticVariables.MAX_THREADS, (feeds.size() + 1) / 2));
		for (final String feed : feeds) {
			es.submit(new Runnable() {

				@Override
				public void run() {
					try {
						Document doc = Jsoup.connect(feed).timeout(StaticVariables.TIMEOUT * 200).get();
						doc = Jsoup.parse(doc.html(), "", Parser.xmlParser());
						Elements elements = doc.getElementsByTag("item");
						for (final Element element : elements) {
							links.add(element.getElementsByTag("link").first().text());
						}

					} catch (IOException e) {
						System.err
								.println(e.getMessage() + ": Excluding link. (#" + throwOutCounter + ") Feed: " + feed);
					}
				}
			});
		}
		es.shutdown();
		es.awaitTermination(StaticVariables.TIMEOUT, TimeUnit.SECONDS);
		foundStuff = (links.size() > 0);
	}

	public XMLParser(List<String> feeds, String searchTerm) throws InterruptedException {
		links = new ArrayList<String>();
		final String term = searchTerm.replaceAll("\\p{Punct}", " ").toUpperCase();
		ExecutorService es = Executors
				.newFixedThreadPool(Math.min(StaticVariables.MAX_THREADS, (feeds.size() + 1) / 2));
		for (final String feed : feeds) {
			es.submit(new Runnable() {

				@Override
				public void run() {
					try {
						Document doc = Jsoup.connect(feed).timeout(StaticVariables.TIMEOUT * 200).get();
						doc = Jsoup.parse(doc.html(), "", Parser.xmlParser());
						Elements elements = doc.getElementsByTag("item");

						for (final Element element : elements) {

							String title = element.getElementsByTag("title").first().text().toUpperCase();
							String description = element.getElementsByTag("description").first().text().toUpperCase();

							if (title.contains(term) || description.contains(term)) {
								links.add(element.getElementsByTag("link").first().text());
							}
						}
					} catch (IOException e) {
						System.err
								.println(e.getMessage() + ": Excluding link. (#" + throwOutCounter + ") Feed: " + feed);
					}
				}
			});
		}
		es.shutdown();
		es.awaitTermination(StaticVariables.TIMEOUT, TimeUnit.SECONDS);
		foundStuff = (links.size() > 0);
	}
	
	public boolean foundStuff(){
		return foundStuff;
	}

	public ArrayList<String> retrieveLinks() {
		return links;
	}
}
