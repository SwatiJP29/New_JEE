package pack110dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packcommon.ServletUtilities;

public class MainPage extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	PrintWriter out = arg1.getWriter();
				ServletUtilities.pageHead(arg1, "Main Page");
				
				RequestDispatcher rd1, rd2, rd3;
				rd1 = arg0.getRequestDispatcher("/advertise1");
				rd2 = arg0.getRequestDispatcher("/advertise2");
				rd3 = arg0.getRequestDispatcher("/html/form110dispatch.html");
				
				out.println("<BODY BGCOLOR=\"#FDF4E6\">");
					out.println("<A HREF='/MyServletVer3/entrypage'>Your Biodata</A>");
					out.println("<TABLE ALIGN='center' WIDTH='100%' CELLSPACING='2' CELLPADDING='2' BORDER='5'>");
						out.println("<TR><TD>");
							out.println("Advertise 0");	// Advertise 0
						out.println("<TR><TD>");	
							rd1.include(arg0, arg1);	// Advertise 1
						out.println("<TR><TD>");
							rd2.include(arg0, arg1);	// Advertise 2
						out.println("<TR><TD>");
							rd3.include(arg0, arg1);	// Advertise 3
						out.println("<TR><TD>");
							out.println("Advertise 4");	// Advertise 4
					out.println("</TABLE>");
				ServletUtilities.pageFoot(arg1);
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);}
	}
