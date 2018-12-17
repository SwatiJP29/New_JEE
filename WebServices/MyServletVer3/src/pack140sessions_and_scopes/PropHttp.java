package pack140sessions_and_scopes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import packcommon.ServletUtilities;


 public class PropHttp extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(true);
        ServletContext context = this.getServletContext();
        
        String req = (String)request.getAttribute("REQUEST");
        String ses = (String)session.getAttribute("SESSION");
        String con = (String)context.getAttribute("CONTEXT");
        
        PrintWriter out = response.getWriter();
        ServletUtilities.pageHead(response, "Propagate Http");
        out.println("<TABLE ALIGN='center' WIDTH='100%' cellspacing='2' cellpadding='2' border='3'>");
            out.println("<TH colspan='2'>Http Request");
            out.println("<TR><TD>Request<TD>"+req);
            out.println("<TR><TD>Session<TD>"+ses);
            out.println("<TR><TD>Context<TD>"+con);
        out.println("</TABLE>");
     
        ServletUtilities.pageFoot(response);
	}  		  	    
}