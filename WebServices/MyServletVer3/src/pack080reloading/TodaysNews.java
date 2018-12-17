package pack080reloading;

public class TodaysNews
	{	private static String news="";
		
		public synchronized static void addNews(String str)
			{	news = new String(news+" "+str);
				System.out.println("within todays news "+str+"|"+news);}
		
		public synchronized static void replaceNews(String str)
			{	news = str;	}
		
		public synchronized static String readNews()
			{	if (news.equals(""))
					return ("No news today");
				return news;
			}
	}