import java.io.*;
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class WebReader {
	
	private List<String> textOutputs;
	
	public WebReader(List<String> URLs) throws IOException {
		for (String URL : URLs) {
			Document doc = Jsoup.connect(URL).get();
			Elements paragraphs = doc.getElementsByTag("p");
			for (Element paragraph : paragraphs) {
				String output = "";
				
				if (!(URL.contains("http://www.cnn.com") && paragraph.hasClass("zn-body__paragraph"))) {
					paragraphs.remove(paragraph);
				} else {
					String text = paragraph.text();
					text.replaceAll("[\\p{Punct}&&[^\\0x27]]", " ");
					output += text;
				}
				
				textOutputs.add(output);
			}
		}
	}

	
	public List<String> getOutputs() {
		return textOutputs;
	}
}
