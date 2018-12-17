package pack140sessions_and_scopes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 public class SetScope extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ServletContext context = this.getServletContext();
		
		String req = "Contents of request variable";
		String ses = "Contents of session variable";
		String con = "Contents of context variable";
		
		request.setAttribute("REQUEST", req);
		session.setAttribute("SESSION", ses);
		context.setAttribute("CONTEXT", con);
		
		RequestDispatcher rd = request.getRequestDispatcher("/proprequest");
		rd.forward(request, response);
	}  	  	  	    
}