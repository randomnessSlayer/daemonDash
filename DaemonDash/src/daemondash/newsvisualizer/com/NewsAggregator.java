package daemondash.newsvisualizer.com;

import java.util.ArrayList;
import java.util.List;

public class NewsAggregator {
	
	private ArrayList<Tuple<String>> popularWords = new ArrayList<Tuple<String>>();
	
	public void NewsAggregator(String term){

			ArrayList<List<String>> totalList = new ArrayList<List<String>>();
			ArrayList<String> allArticles = new ArrayList<String>();
			
			totalList.add(StaticVariables.LIST_OF_CNN_SITES);
			totalList.add(StaticVariables.LIST_OF_BBC_SITES);
			totalList.add(StaticVariables.LIST_OF_NY_SITES);
			totalList.add(StaticVariables.LIST_OF_WASHPOST_SITES);
			totalList.add(StaticVariables.LIST_OF_AP_SITES);
			totalList.add(StaticVariables.LIST_OF_AJ_SITES);

			for(String[] theseLinks : totalList){
				XMLParser xmlp = new XMLParser(theseLinks,term);
				WebReader wr = new WebReader(xmlp.retrieveLinks());
				allArticles.addAll(wr.getOutputs());
			}
			
			ArticleParser ap = new ArticleParser(allArticles);
			popularWords = ap.getMostPopTuples();





		}
	}
