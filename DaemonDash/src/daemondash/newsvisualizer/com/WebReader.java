package daemondash.newsvisualizer.com;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class WebReader {

	private ArrayList<String> textOutputs;

	public WebReader(List<String> URLs) throws IOException, InterruptedException {
		textOutputs = new ArrayList<String>();
		ExecutorService es = Executors.newFixedThreadPool(URLs.size() / 2);

		for (final String URL : URLs) {
			es.submit(new Runnable() {

				@Override
				public void run() {
					try {
						Document doc;

						doc = Jsoup.connect(URL).get();
						Elements paragraphs = doc.getElementsByTag("p");
						Elements goodParagraphs = new Elements();
						for (Element paragraph : paragraphs) {
							if (!paragraph.hasClass("metadata")) {
								goodParagraphs.add(paragraph);
							}
						}

						String output = "";
						for (Element goodParagraph : goodParagraphs) {
							String text = " " + goodParagraph.text();
							// Removes all punctuation except apostrophes
							text = text.replaceAll("[\\p{Punct}&&[^\\u0027]]", " ");
							text = text.toUpperCase(Locale.ENGLISH);
							output += text;
						}
						textOutputs.add(output);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		es.shutdown();
		es.awaitTermination(20, TimeUnit.SECONDS);
	}

	public ArrayList<String> getOutputs() {
		return textOutputs;
	}
}
