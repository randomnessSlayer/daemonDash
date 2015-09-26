package com.daemondash.newsvisualizer.background;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;


public class RSSFeed {
	private File fromWeb;
	RSSFeed ( URL fed ) throws IOException, URISyntaxException{
		BufferedReader in = new BufferedReader(
	    new InputStreamReader(fed.openStream()));
		
		String inputLine;
		String add = "";
		while ((inputLine = in.readLine()) != null){
			 add = add + inputLine ;
		}
		
		in.close();

		File tryT = new File (add);	
		this.fromWeb = tryT;
		
	}
		
	public void setFile ( File fed ){
		fromWeb = fed;
	}

	public File getXML (){
		return fromWeb;
	}
	
//	public static void main (String [] args) throws IOException, URISyntaxException{		
//		RSSFeed test = new RSSFeed (new URL("http://rss.cnn.com/rss/cnn_topstories.rss"));
//	
//	}
}
