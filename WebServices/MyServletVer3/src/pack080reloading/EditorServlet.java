package pack080reloading;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import packcommon.ServletUtilities;

public class EditorServlet extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	String action = arg0.getParameter("action");
				String news	  = arg0.getParameter("news");
				PrintWriter out = arg1.getWriter();
				
					ServletUtilities.pageHead(arg1, "Taza Khabar");
					out.println("<H1 ALIGN = 'CENTER'>Taza Khabar</H1>");
					out.println("<FORM ACTION ='/MyServletVer3/editor' Method='GET'>");
						out.println("<CENTER>");
							out.println("News:");
							out.println("<INPUT TYPE ='TEXT' NAME = 'news'><BR>");
						
							out.println("<INPUT TYPE='RADIO' NAME='action' VALUE='append'>");
							out.println("Append |");
							out.println("<INPUT TYPE='RADIO' NAME='action' VALUE='replace'>");
							out.println("Replace");
						
							out.println("<BR><BR>");
							if (news==null)
								{	news=""; action = "";}
							
							if (action.trim().equalsIgnoreCase("append"))
								TodaysNews.addNews(news);
							if (action.trim().equalsIgnoreCase("replace"))
								TodaysNews.replaceNews(news);
							
							out.println("<INPUT TYPE ='TEXT' NAME = 'news' VALUE='"+TodaysNews.readNews()+"'>");
							out.println("<INPUT TYPE='SUBMIT' VALUE='OK'>");
						out.println("</CENTER>");
					out.println("</FORM>");
				
				ServletUtilities.pageFoot(arg1);
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}	
	}
