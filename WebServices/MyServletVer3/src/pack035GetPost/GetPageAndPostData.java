package pack035GetPost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packcommon.ServletUtilities;

public class GetPageAndPostData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getMethod().equalsIgnoreCase("HEAD"))
			return;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ServletUtilities.pageHead(response, "Get the page");
		out.println("<FORM ACTION = \"/MyServletVer3/getpost\" METHOD = \"POST\">");
		out.println("<TABLE ALIGN=\"center\" WIDTH=\"100%\" cellspacing=\'2\' cellpadding=\'2\' >");
		out.println("<BR><BR>");
		out.println("<CENTER>");
		out.println("You are getting a page now."+request.getMethod());
		out.println("<BR><INPUT TYPE=\"SUBMIT\" NAME=\"choice\" VALUE = \"Go\">");
		out.println("<A href=\'/MyServletVer3/getpost\'>Click Here</A>");
		out.println("</CENTER>");
		out.println("</TABLE>");
		out.println("</FORM>");
		ServletUtilities.pageFoot(response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		ServletUtilities.pageHead(response, "Get the page");
		out.println("<FORM ACTION = \"/MyServletVer3/getpost\" METHOD = \"GET\">");
		out.println("<TABLE ALIGN=\"center\" WIDTH=\"100%\" cellspacing=\'2\' cellpadding=\'2\' >");
		out.println("<BR><BR>");
		out.println("<CENTER>");
		out.println("Your data is posted."+request.getMethod());
		out.println("<BR><INPUT TYPE=\"SUBMIT\" NAME=\"choice\" VALUE = \"Go\">");
		out.println("</CENTER>");
		out.println("</TABLE>");
		out.println("</FORM>");

		ServletUtilities.pageFoot(response);
	}
	
	public long getLastModified(HttpServletRequest req) {
		return System.currentTimeMillis() / 1000 * 1000;
	}
}
