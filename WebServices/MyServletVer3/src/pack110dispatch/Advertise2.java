package pack110dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packcommon.ServletUtilities;

public class Advertise2 extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//ServletUtilities.PageHead(response, "Advertise 2");
		
		out.println("<FONT SIZE=4>");
		out.println("ADVERTISE 2");
		out.println("</FONT>");
		
		//ServletUtilities.PageFoot(response);
	}  		    
}