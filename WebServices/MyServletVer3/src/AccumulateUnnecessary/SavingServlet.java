package pack110dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SavingServlet extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	String acctype = arg0.getParameter("accounttype");
								
				PrintWriter out = arg1.getWriter();
				ServletUtilities.PageHead(arg1,"SavingServlet");
				
				out.println("<H3 ALIGN=\"CENTER\">Saving Servlet</H3>"+
						"<H4 ALIGN=\"CENTER\">"+acctype+"</H4><BR><BR>"
						);
				out.println("</BODY></HTML>");
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}	
	}