package pack110dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtilities
	{	public static int getIntParameter(HttpServletRequest request, String paramName, int defaultValue)
			{	String paramString = request.getParameter(paramName);
				int paramValue;
				try { paramValue=Integer.parseInt(paramString);
					}
				catch(NumberFormatException nfe)
					{	paramValue=defaultValue;	}	
				return(paramValue);
			}
		
		public static void PageHead(HttpServletResponse arg1, String str) throws IOException
			{  	arg1.setContentType("text/html");
				PrintWriter out = arg1.getWriter();
				out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
				out.print("<HTML>");
					out.print("<HEAD>");
						out.print("<TITLE>");
							out.print(str);
				        out.print("</TITLE>");
				    out.print("</HEAD>");
				    out.println("<BODY>");
			}
		
		public static void PageFoot(HttpServletResponse arg1) throws IOException
			{	PrintWriter out = arg1.getWriter();
					out.println("</BODY>");
				out.println("</HTML>");
				out.flush();
				out.close();
			}
		
		public static String searchCookie(Cookie[] cook, String nm)
			{	for(int i=0; i<cook.length; i++)
					if (cook[i].getName().equalsIgnoreCase(nm))
						return cook[i].getValue();
				return "";
			}
	}
