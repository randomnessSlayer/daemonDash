import java.io.File;
import java.util.ArrayList;

public class XMLParserTest {
	
	public static void main(String[] args){
		
		File f = new File("C:/test.xml");
		XMLParser xmlp = new XMLParser(f,"russia");
		ArrayList<String> links = xmlp.retrieveLinks();
		for(String s : links){
			System.out.println(s);
		}
		
	}
	
}
