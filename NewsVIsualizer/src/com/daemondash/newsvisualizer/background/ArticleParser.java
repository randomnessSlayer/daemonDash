package com.daemondash.newsvisualizer.background;
import java.util.ArrayList;

public class ArticleParser {
	public static final int NUM_POP_WORDS = 15;
	private ArrayList<ArrayList<Tuple<String>>> listOfWordCountsByArticle = new ArrayList<ArrayList<Tuple<String>>>();
	private ArrayList<Tuple<String>> listOfWordCountsTotal = new ArrayList<Tuple<String>>();
	private ArrayList<String> mostPopWords;

	public ArticleParser(ArrayList<String> articles) {
		for (String s : articles) {
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
				if (!found) {
					stringCounts.add(new Tuple<String>(str, 1));
				}
			}
			listOfWordCountsByArticle.add(stringCounts);
		}
		for (ArrayList<Tuple<String>> wordList : listOfWordCountsByArticle) {
			for (Tuple<String> word : wordList) {
				boolean found = false;
				for (Tuple<String> tuple : listOfWordCountsTotal) {
					if (tuple.getKey().equals(word.getKey())) {
						tuple.incValue();
						found = true;
					}
				}
				if (!found) {
					listOfWordCountsTotal.add(new Tuple<String>(word.getKey(), 1));
				}
			}
		}
		for (int index = 0; index < NUM_POP_WORDS && index < listOfWordCountsTotal.size(); index++) {
			mostPopWords.add(listOfWordCountsTotal.get(index).getKey());
		}
	}

	public ArrayList<String> getMostPopWords() {
		return mostPopWords;
	}
}
