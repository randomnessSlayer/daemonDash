package tests.daemondash.newsvisualizer.com;

import java.io.IOException;
import java.util.ArrayList;

import daemondash.newsvisualizer.com.*;

public class AggregatorTest {
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		NewsAggregator na = new NewsAggregator("china");
		ArrayList<Tuple<String>> words = new ArrayList<Tuple<String>>();
		for(Tuple<String> t : words){
			System.out.println(t.toString());
		}
	}
}
