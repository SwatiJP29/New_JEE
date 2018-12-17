package pack100search;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SearchSpec
	{	private static String[][] nmUrl =
				{ 	{"google", "http://www.google.com/search?q="},
					{"alltheweb", "http://www.alltheweb.com/search?q="},
					{"yahoo", "http://search.yahoo.com/bin/search?p="},
					{"altavista", "http://www.altavista.com/web/results?q="},
					{"lycos", "http://search.lycos.com/default.asp?query="},
					{"hotbot", "http://hotbot.com/default.asp?query="},
					{"msn", "http://search.msn.com/results.asp?q="}
				};
		
		public static String getURLforEngine(String engineName, String searchString)
				throws UnsupportedEncodingException	{
				String searchURL = null;
				for(int i = 0; i<nmUrl.length; i++)
					{	if ((nmUrl[i][0]).equalsIgnoreCase(engineName))
							{	searchURL = nmUrl[i][1]+URLEncoder.encode(searchString, "UTF-8");
								break;
							}
					}
				return searchURL;
			}  
	}
