package pack110dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packcommon.ServletUtilities;

public class ValidationPage extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletUtilities.pageHead(response, "Validation Page");
		
		out.println("<H1>Validation Page</H1>");
		
		RequestDispatcher rd = request.getRequestDispatcher("/finalresponse");
		rd.forward(request, response);
		
		ServletUtilities.pageFoot(response);
	}  	
}