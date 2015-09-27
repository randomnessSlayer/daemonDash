package daemondash.newsvisualizer.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArticleParser {
	private ArrayList<ArrayList<Tuple<String>>> listOfWordCountsByArticle = new ArrayList<ArrayList<Tuple<String>>>();
	private ArrayList<Tuple<String>> listOfWordCountsTotal = new ArrayList<Tuple<String>>();
	private ArrayList<String> mostPopWords = new ArrayList<String>();
	private ArrayList<Tuple<String>> mostPopTuples = new ArrayList<Tuple<String>>();
	private String searchTerm;

	public ArticleParser(String searchTerm, final ArrayList<String> articles) throws InterruptedException {
		this.searchTerm = searchTerm;
		this.searchTerm = this.searchTerm.toUpperCase(Locale.ENGLISH);
		
		for (final String s : articles) {
			String[] strArr = s.split("\\s+");
			final ArrayList<Tuple<String>> stringCounts = new ArrayList<Tuple<String>>();
			for (final String str : strArr) {
				Tuple<String> tuple = new Tuple<String>(str, 1);
				if(notCommonWord(str)){
					int index = stringCounts.indexOf(tuple);
				int indexGeneral = listOfWordCountsTotal.indexOf(tuple);
				if (index >= 0) {
					stringCounts.get(index).incValue();
					listOfWordCountsTotal.get(indexGeneral).incValue();
				} else{
					stringCounts.add(tuple);
				}
				if (indexGeneral >= 0) {
					listOfWordCountsTotal.get(indexGeneral).incValue();
				} else {
					listOfWordCountsTotal.add(tuple);
				}
			}
			}
			listOfWordCountsByArticle.add(stringCounts);
		}

		Collections.sort(listOfWordCountsTotal);
		for (int index = 0; index < StaticVariables.NUM_POP_WORDS && index < listOfWordCountsTotal.size(); index++) {
			mostPopWords.add(listOfWordCountsTotal.get(index).getKey());
			mostPopTuples.add(listOfWordCountsTotal.get(index));
		}
	}

	private boolean notCommonWord(String s) {
		ArrayList<String> commonWords = (ArrayList<String>) StaticVariables.LIST_OF_COMMON_WORDS.clone();
		String[] terms = searchTerm.split("\\s+");
		for (String term : terms) {
			commonWords.add(term);
		}
		
		s = s.toUpperCase();
		if (s.length() > 2) {
			for (String word : commonWords) {
				if (word.equals(s)) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	public ArrayList<String> getMostPopWords() {
		return mostPopWords;
	}

	public ArrayList<Tuple<String>> getMostPopTuples() {
		return mostPopTuples;
	}
}
