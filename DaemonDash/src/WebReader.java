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
				if (!(URL.contains("http://www.cnn.com") && paragraph.hasClass("zn-body__paragraph"))) {
					paragraphs.remove(paragraph);
				}
			}
		}
	}

	
	public List<String> getOutputs() {
		return textOutputs;
	}
}
