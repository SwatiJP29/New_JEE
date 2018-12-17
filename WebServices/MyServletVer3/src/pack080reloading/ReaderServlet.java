package pack080reloading;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packcommon.ServletUtilities;

public class ReaderServlet extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	arg1.setContentType("text/html");
				PrintWriter out = arg1.getWriter();
		
				arg1.setHeader("Refresh", "5");
				String title = "Taza Khabar";
				ServletUtilities.pageHead(arg1, "Taza Khabar");
				out.println("<BODY BGCOLOR=\"#FDF5E6\">"+
						"<H2 ALIGN = CENTER>"+title+"</H2>"+
						"<H3>"+ TodaysNews.readNews()+"</H3>");
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);}	
	}
