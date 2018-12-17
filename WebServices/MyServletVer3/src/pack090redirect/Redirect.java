package pack090redirect;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Redirect extends HttpServlet
	{	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws ServletException, IOException
	    	{	//String newUrl = "http://localhost:7001/ResponseHeader55/readPDF";
	    		String newUrl = "http://www.pragatisoftware.com";
	    		
	    		/*	HTML Hyper Link Way of Redirection
		        	res.setContentType("text/html");
		        	PrintWriter out = res.getWriter();
		        	out.println("<html><head><title>301 Moved Permanantly</title></head>");
		        	out.println("<body>");
		        	out.println("Website moved to <a href=\""+newUrl+"\">here.</a>");
		        	out.println("</body></html>");
		        	out.close();
	        	*/
	    		
	    		// Servlet first way
	        	//res.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
	        	//res.setHeader("Location", newUrl);
	        	
	    		// Servlet second way
	    		res.sendRedirect(newUrl);
	    	}
	}
