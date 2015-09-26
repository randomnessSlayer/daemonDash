package com.daemondash.newsvisualizer.background;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLParserTest {
	
	public static void main(String[] args) throws IOException{
		
		File f = new File("C:/test.xml");
		XMLParser xmlp = new XMLParser(f,"orange");
		ArrayList<String> links = xmlp.retrieveLinks();
		for(String s : links){
			System.out.println(s);
		}
		
		System.out.println("");
		
		WebReader wr = new WebReader(links);
		for(String string : wr.getOutputs()){
			System.out.println(string);
		}
	}
	
}
