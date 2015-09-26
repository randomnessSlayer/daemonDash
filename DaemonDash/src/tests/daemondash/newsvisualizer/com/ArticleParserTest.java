package tests.daemondash.newsvisualizer.com;

import java.util.ArrayList;

import daemondash.newsvisualizer.com.ArticleParser;

public class ArticleParserTest {

	public static void main(String[] args) {
		ArrayList<String> articles = new ArrayList<String>();
		String article = "LAKE TEKAPO, New Zealand — A college student from New York and another from London have died while kayaking in New Zealand, police said Saturday. Police area commander Dave Gaskin said the pair was part of a group of 11 friends who got into trouble Friday while kayaking on Lake Tekapo. Gaskin told Television New Zealand it was very, very lucky that all 11 students didn’t die after they were struck by strong winds that swamped their vessels and thrust them into the frigid lake water.Rescuers described the survivors as suffering hypothermia and in some cases being incoherent.The students were all attending Monash University in Melbourne, Australia, and were visiting New Zealand during a semester break.Police said those who died were 21-year-old Daniel Hollnsteiner from New York and 20-year-old James Murphy from London.Hollnsteiner’s Facebook page said he had been living in Buffalo and was from Staten Island.Monash University said in a statement that the college community was deeply saddened by the deaths and that it had sent a senior manager to New Zealand to assist the surviving students.Copyright 2015 The Associated Press. All rights reserved. This material may not be published, broadcast, rewritten or redistributed.";
		articles.add(article);
		ArticleParser parser = new ArticleParser(articles);
		for (String s : parser.getMostPopWords()) {
			System.out.println(s);
		}
	}

}
