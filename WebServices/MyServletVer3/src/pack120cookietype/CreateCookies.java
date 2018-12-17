/* This servlet passes created cookies through response header to the client browser.
 * Client browser creates a cookie text file at c:\Document and Setting\chandrashekhar\cookies\ chandrashekhar@Cookies99[1]
 * Here, Chandrashekhar is login name of a computer, Cookies99 is a name of an application
 * Other things recorded are the time and date of life span 
 * 
 */
package pack120cookietype;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packcommon.ServletUtilities;

public class CreateCookies extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	for(int i=0; i<3; i++)
					{	Cookie cook = new Cookie("Sess-"+i, "Value-"+i);
						arg1.addCookie(cook);	// This is a cookie with age for a session only.
						cook = new Cookie("Prstt-"+i, "Value-"+i);
						if (i==0)
							cook.setMaxAge(60);
						if (i==1)
							cook.setMaxAge(120);	// Age set for two minutes.
						if (i==2)
							cook.setMaxAge(3600);
						arg1.addCookie(cook);	// This is a cookie persistant for an hour.
					}
				arg1.setContentType("text/html");
				PrintWriter out = arg1.getWriter();
				String title = "Setting Cookies";
				ServletUtilities.pageHead(arg1, title);
				out.println("<BODY BGCOLOR=\"#FDF5E6\">"+
						"<H1 ALIGN=\"CENTER\">"+title+"</H1>"+
						"There are six cookies associated with this page."+
						"To see them, visit the"+
						
						"<A HREF=\"/MyServletVer3/showcoo\">"+
						//"<A HREF=\""+arg0.getContextPath()+"/showcookies\">"+
						"<CODE>ShowCookies</CODE> servlet</A>."+
						"<P>"+
						"Three of the cookies are associated only with the "+
						"current session, while three are persistent."+
						"Quit the browser, restart, and return to the "+
						"<CODE>ShowCookies</CODE> servlet to varify that "+
						"the three long-lived ones persist across sessions.");
				ServletUtilities.pageFoot(arg1);
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}	
	}
