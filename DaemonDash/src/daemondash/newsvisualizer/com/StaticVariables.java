package daemondash.newsvisualizer.com;

import java.util.ArrayList;

public class StaticVariables {
	public static final int NUM_POP_WORDS = 15;
	public static final int TIMEOUT = 20;
	public static final String[] commonWords = new String[] { "FOR", "THE", "SAID", "WHILE", "FROM", "AND", "WAS",
			"WHERE", "WHAT", "WHEN", "WHY", "HOW", "THAT", "THEN", "THERE", "WHO", "ALL", "WERE", "INTO", "TIMELY",
			"HAD", "WILL", "WITH", "ARE", "BUT", "HIS", "WOULD", "COULD", "WHICH", "THEIR", "WELL", "ABOUT", "CNN",
			"JUST", "LIKE", "YOU", "SHE", "HER", "HIM", "SAYS", "THIS", "NOT", "THEY", "HAS", "HAVE", "NEWS", "ITS",
			"ALSO", "OVER", "MORE", "BEEN", "BEING", "YOUR", "OUT", "AFTER", "CAN", "PEOPLE", "YEAR", "THAN", "SOME",
			"BADGE", "MANY", "OUR", "NEW", "WORLD", "POST", "COMMENTS", "2015", "REUTERS", "TWO", "THINK", "EVERY",
			"BADGES", "ONE", "FIRST", "TIME", "NOW", "THEM", "OTHER", "WEEK", "YEARS", "ADVERTISEMENT", "BEFORE",
			"KNOW", "WANT", "MOST", "LEAST", "SEE", "BACK", "PLEASE", "REQUEST", "MINUTES", "CONSISTENTLY", "HERE",
			"AGAINST", "TOLD", "THOUGHT", "PERCENT", "EVEN", "RATE", "SECOND", "THIRD", "FOURTH", "SECONDLY", "THIRDLY",
			"FINALLY", "NEARLY", "QUICKLY", "INC", "BROWSER", "PROVIDED", "STORY", "000", "BECAUSE", "THESE", "THOSE",
			"BBC", "JAVASCRIPT", "SUCH", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY",
			"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "NOVEMBER", "DECEMBER",
			"REALLY", "MONTH", "MONTHS", "DAY", "DAYS", "EMAIL", "ONLY", "COMMENT", "USING", "SOURCES", "EARLIER",
			"DON'T", "WON'T", "SHOULDN'T", "SHOULD", "SAY", "FELLOW", "MRS", "MR"};
	
	public static final ArrayList<String> LIST_OF_COMMON_WORDS = asArray(commonWords);
	
	public static final String[] ARRAY_OF_CNN_SITES = new String[] { "http://rss.cnn.com/rss/cnn_topstories.rss",
			"http://rss.cnn.com/rss/cnn_world.rss", "http://rss.cnn.com/rss/cnn_us.rss",
			"http://rss.cnn.com/rss/money_latest.rss", "http://rss.cnn.com/rss/cnn_allpolitics.rss",
			"http://rss.cnn.com/rss/cnn_tech.rss", "http://rss.cnn.com/rss/cnn_health.rss",
			"http://rss.cnn.com/rss/cnn_showbiz.rss", "http://rss.cnn.com/rss/cnn_travel.rss",
			"http://rss.cnn.com/rss/cnn_living.rss", "http://rss.cnn.com/rss/cnn_latest.rss" };

	public static final ArrayList<String> LIST_OF_CNN_SITES = asArray(ARRAY_OF_CNN_SITES);

	public static final String[] ARRAY_OF_BBC_SITES = new String[] { "http://feeds.bbci.co.uk/news/world/rss.xml",
			"http://feeds.bbci.co.uk/news/business/rss.xml", "http://feeds.bbci.co.uk/news/politics/rss.xml",
			"http://feeds.bbci.co.uk/news/health/rss.xml", "http://feeds.bbci.co.uk/news/education/rss.xml",
			"http://feeds.bbci.co.uk/news/science_and_environment/rss.xml",
			"http://feeds.bbci.co.uk/news/technology/rss.xml",
			"http://feeds.bbci.co.uk/news/entertainment_and_arts/rss.xml", "http://feeds.bbci.co.uk/news/rss.xml" };

	public static final ArrayList<String> LIST_OF_BBC_SITES = asArray(ARRAY_OF_BBC_SITES);

	public static final String[] ARRAY_OF_NY_SITES = new String[] {
			"http://rss.nytimes.com/services/xml/rss/nyt/World.xml",
			"http://rss.nytimes.com/services/xml/rss/nyt/US.xml",
			"http://rss.nytimes.com/services/xml/rss/nyt/Business.xml",
			"http://rss.nytimes.com/services/xml/rss/nyt/Technology.xml",
			"http://rss.nytimes.com/services/xml/rss/nyt/Sports.xml",
			"http://rss.nytimes.com/services/xml/rss/nyt/Science.xml",
			"http://rss.nytimes.com/services/xml/rss/nyt/Health.xml",
			"http://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml",
			"http://rss.nytimes.com/services/xml/rss/nyt/InternationalHome.xml" };

	public static final ArrayList<String> LIST_OF_NY_SITES = asArray(ARRAY_OF_NY_SITES);

	public static final String[] ARRAY_OF_WASHPOST_SITES = new String[] { "http://feeds.washingtonpost.com/rss/sports",
			"http://feeds.washingtonpost.com/rss/national", "http://feeds.washingtonpost.com/rss/world",
			"http://feeds.washingtonpost.com/rss/business", "http://feeds.washingtonpost.com/rss/entertainment",
			"http://feeds.washingtonpost.com/rss/politics" };

	public static final ArrayList<String> LIST_OF_WASHPOST_SITES = asArray(ARRAY_OF_WASHPOST_SITES);

	public static final String[] ARRAY_OF_REUTERS_SITES = new String[] { "http://feeds.reuters.com/news/artsculture",
			"http://feeds.reuters.com/reuters/businessNews", "http://feeds.reuters.com/reuters/companyNews",
			"http://feeds.reuters.com/reuters/entertainment", "http://feeds.reuters.com/reuters/environment",
			"http://feeds.reuters.com/reuters/healthNews", "http://feeds.reuters.com/reuters/lifestyle",
			"http://feeds.reuters.com/news/reutersmedia", "http://feeds.reuters.com/news/wealth",
			"http://feeds.reuters.com/reuters/MostRead", "http://feeds.reuters.com/reuters/oddlyEnoughNews",
			"http://feeds.reuters.com/ReutersPictures", "http://feeds.reuters.com/reuters/peopleNews",
			"http://feeds.reuters.com/Reuters/PoliticsNews", "http://feeds.reuters.com/reuters/scienceNews",
			"http://feeds.reuters.com/reuters/sportsNews", "http://feeds.reuters.com/reuters/technologyNews",
			"http://feeds.reuters.com/reuters/topNews", "http://feeds.reuters.com/Reuters/domesticNews",
			"http://feeds.reuters.com/Reuters/worldNews" };

	public static final ArrayList<String> LIST_OF_REUTERS_SITES = asArray(ARRAY_OF_REUTERS_SITES);

	public static final String[] ARRAY_OF_AJ_SITES = new String[] { "http://www.aljazeera.com/xml/rss/all.xml",
			"http://america.aljazeera.com/content/ajam/articles.rss" };

	public static final ArrayList<String> LIST_OF_AJ_SITES = asArray(ARRAY_OF_AJ_SITES);

	public static final ArrayList<String> LIST_OF_ALL_SITES = combineAllLists();
	public static final int MAX_THREADS = 25;

	private static ArrayList<String> asArray(String[] arrayOfSites) {
		ArrayList<String> stringList = new ArrayList<String>();
		for (String s : arrayOfSites) {
			stringList.add(s);
		}
		return stringList;
	}

	private static ArrayList<String> combineAllLists() {
		ArrayList<String> allLists = LIST_OF_AJ_SITES;
		allLists.addAll(LIST_OF_REUTERS_SITES);
		allLists.addAll(LIST_OF_BBC_SITES);
		allLists.addAll(LIST_OF_CNN_SITES);
		allLists.addAll(LIST_OF_NY_SITES);
		allLists.addAll(LIST_OF_WASHPOST_SITES);
		return allLists;
	}
}
