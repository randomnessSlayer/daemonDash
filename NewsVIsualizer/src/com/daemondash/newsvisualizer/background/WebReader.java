package com.daemondash.newsvisualizer.background;
import java.io.*;
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class WebReader {
	
	private List<String> textOutputs;
	
	public WebReader(List<String> URLs) throws IOException {
		textOutputs = new ArrayList<String>();
		
		for (String URL : URLs) {
			Document doc = Jsoup.connect(URL).get();
			Elements paragraphs = doc.getElementsByTag("p");
			Elements goodParagraphs = new Elements();
			for (Element paragraph : paragraphs) {
				if (URL.contains("http://rss.cnn.com") && paragraph.hasClass("zn-body__paragraph")) {
					goodParagraphs.add(paragraph);
				}
			}
			
			String output = "";
			for (Element goodParagraph : goodParagraphs) {
					String text = " " + goodParagraph.text();
					//Removes all punctuation except apostrophes
					text = text.replaceAll("[\\p{Punct}&&[^\\u0027]]", " ");
					output += text;
			}
			textOutputs.add(output);
		}
	}

	
	public List<String> getOutputs() {
		return textOutputs;
	}
}
