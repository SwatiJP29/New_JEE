package pack130usecookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntryForm	extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	String name = "";
				
				Cookie [] cookies = arg0.getCookies();
				if (cookies != null)
					name = searchCookie(cookies, "name");
				
				PrintWriter out = arg1.getWriter();
				out.print("<HTML>");
				out.print("<HEAD>");
					out.print("<TITLE>");
						out.print("Experience Cookie");
					out.print("</TITLE>");
					out.print("<BODY BGCOLOR=\"#FDF5E7\">\n"+
							"<H1 ALIGN=CENTER>"+"Heyyy Cookie"+"</H1>");
					out.println("<FORM ACTION =\"/MyServletVer3/setcookies\" Method=\"POST\">"+
							"<CENTER>"+
							"Name : <INPUT TYPE =\"TEXT\" NAME = \"name\" VALUE = '"+name+"'><BR>"+
					
							"<INPUT TYPE=\"SUBMIT\" VALUE=\"OK\">"+
							"</CENTER>");
					out.println("</FORM></BODY></HTML>");
			}
	
		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);}
		
		public String searchCookie(Cookie[] cook, String nm)
			{	for(int i=0; i<cook.length; i++)
					if (cook[i].getName().equalsIgnoreCase(nm))
						return cook[i].getValue();
				return "";
			}
	}
