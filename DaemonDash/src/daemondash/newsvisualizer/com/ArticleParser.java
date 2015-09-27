package daemondash.newsvisualizer.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArticleParser {
	private ArrayList<ArrayList<Tuple<String>>> listOfWordCountsByArticle = new ArrayList<ArrayList<Tuple<String>>>();
	private ArrayList<Tuple<String>> listOfWordCountsTotal = new ArrayList<Tuple<String>>();
	private ArrayList<String> mostPopWords = new ArrayList<String>();
	private ArrayList<Tuple<String>> mostPopTuples = new ArrayList<Tuple<String>>();

	public ArticleParser(final ArrayList<String> articles) throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(articles.size() / 2);
		for (final String s : articles) {
			es.submit(new Runnable() {

				@Override
				public void run() {
					String[] strArr = s.split("\\s+");
					ArrayList<Tuple<String>> stringCounts = new ArrayList<Tuple<String>>();
					for (String str : strArr) {
						boolean found = false;
						for (Tuple<String> tuple : stringCounts) {
							if (tuple.getKey().equals(str)) {
								tuple.incValue();
								found = true;
							}
						}
						if (!found && notCommonWord(str)) {
							stringCounts.add(new Tuple<String>(str, 1));
						}
					}
					listOfWordCountsByArticle.add(stringCounts);
				}
			});
		}
		es.shutdown();
		es.awaitTermination(StaticVariables.TIMEOUT, TimeUnit.SECONDS);

		for (final ArrayList<Tuple<String>> wordList : listOfWordCountsByArticle) {
			for (Tuple<String> word : wordList) {
				boolean found = false;
				for (Tuple<String> tuple : listOfWordCountsTotal) {
					if (tuple.getKey().equals(word.getKey())) {
						tuple.setValue(word.getValue());
						;
						found = true;
					}
				}
				if (!found) {
					listOfWordCountsTotal.add(new Tuple<String>(word.getKey(), word.getValue()));
				}
			}
		}

		Collections.sort(listOfWordCountsTotal);
		for (int index = 0; index < StaticVariables.NUM_POP_WORDS && index < listOfWordCountsTotal.size(); index++) {
			mostPopWords.add(listOfWordCountsTotal.get(index).getKey());
			mostPopTuples.add(listOfWordCountsTotal.get(index));
		}
	}

	private boolean notCommonWord(String s) {
		s = s.toUpperCase();
		if (s.length() > 2) {
			for (String word : StaticVariables.commonWords) {
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
