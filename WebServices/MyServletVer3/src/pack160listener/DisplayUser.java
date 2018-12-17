package pack160listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayUser extends HttpServlet
	{	int hitCount=0;
		String str="";
		protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	HttpSession sess = arg0.getSession(true);
				arg1.setContentType("text/html");
				PrintWriter out = arg1.getWriter();
				
				out.println("User Hits  : "+UserTracker.getUsers()+"<BR>");
				out.println("Total Hits : "+(++hitCount)+"<BR>");
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}	
	}
