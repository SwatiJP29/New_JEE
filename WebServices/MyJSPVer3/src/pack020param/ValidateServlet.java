package pack020param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateServlet	extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	HttpSession sess = arg0.getSession();
				PrintWriter out = arg1.getWriter();
				TravAgentBean ta22 = (TravAgentBean)sess.getAttribute("entry");
				if (ta22==null)
					{	System.out.println("Not Collected.");
						out.println("Bean not collected.");
					}
				else
					{	System.out.println("Collected.");
						System.out.println(ta22.advance);
						out.println("Bean collected.");
						out.println(ta22.advance);
						out.println(ta22.tCost);
						RequestDispatcher rd = arg0.getRequestDispatcher("/JSP/JSP020Param/validate.jsp");
						rd.forward(arg0, arg1);
					}
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet( arg0,arg1);}	
	}
