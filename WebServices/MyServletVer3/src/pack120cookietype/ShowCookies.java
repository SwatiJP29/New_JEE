package pack120cookietype;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packcommon.ServletUtilities;

public class ShowCookies extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	arg1.setContentType("text/html");
				PrintWriter out = arg1.getWriter();
				String title = "Active Cookies";
				ServletUtilities.pageHead(arg1, title);
				out.println("<BODY BGCOLOR=\"#FDF5E6\">"+
					"<H1 ALIGN=\"CENTER\">"+title+"</H1>"+
					"<TABLE BORDER=1 ALIGN=\"CENTER\">"+
					"<TR BGCOLOR=\"#FFAD00\">"+
					"   <TH>Cookie Name"+
					"   <TH>Cookie Value");
				Cookie [] cookies = arg0.getCookies();
				Cookie cookie;
				for(int i=0; i<cookies.length; i++)
					{	cookie = cookies[i];
						out.println("<TR>"+
								" <TD>"+cookie.getName()+
								" <TD>"+cookie.getValue()
								);
					}
				out.println("</TABLE>");
				ServletUtilities.pageFoot(arg1);
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}	
	}
