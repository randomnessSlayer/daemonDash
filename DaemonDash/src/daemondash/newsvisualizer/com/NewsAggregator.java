package daemondash.newsvisualizer.com;

import java.util.ArrayList;

public class NewsAggregator {
	private ArrayList<Tuple> popularWords = new ArrayList<Tuple>();
	
	public void NewsAggregator(String term){

		

			ArrayList<String[]> totalList = new ArrayList<String[]>();
			totalList.add(StaticVariables.LIST_OF_CNN_SITES);
			totalList.add(StaticVariables.LIST_OF_BBC_SITES);
			totalList.add(StaticVariables.LIST_OF_NY_SITES);
			totalList.add(StaticVariables.LIST_OF_WASHPOST_SITES);
			totalList.add(StaticVariables.LIST_OF_AP_SITES);
			totalList.add(StaticVariables.LIST_OF_AJ_SITES);

			for(String[] theseLinks : totalList){
				XMLParser xmlp = new XMLParser(theseLinks,term);
				WebReader wr = new WebReader(xmlp.retrieveLinks());
				ArticleParser ap = new ArticleParser(wr.getOutputs());
				popularWords.addAll(ap.getMostPopTuples());
			}





		}
	}
