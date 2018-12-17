package pack050request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Request extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	arg1.setContentType("text/html");
				PrintWriter out = arg1.getWriter();

				String title = "Servlet Receiving Request.";
				out.println("<HTML><HEAD><TITLE>"+title+"</TITLE></HEAD>");
				out.println("<BODY BGCOLOR=\"#FDF5E6\">");
				out.println("<H1 ALIGN=CENTER>"+title+"</H1>");
				out.println("<B>Request Method : </B>"+arg0.getMethod()+"<BR>");
				out.println("<B>Request Protocol : </B>"+arg0.getProtocol()+"<BR>");
				out.println("<B>Request URI : </B>"+arg0.getRequestURI()+"<BR>");
				
				out.println("<TABLE BORDER=1 ALIGN=CENTER>");
				out.println("<TR BGCOLOR=\"#FFAD00\">");
				out.println("<TH>Header Name<TH>Header Value");
				Enumeration headerNames = arg0.getHeaderNames();
				while(headerNames.hasMoreElements())
					{	String headerName =(String)headerNames.nextElement();
						out.println("<TR><TD>"+headerName);
						out.println("    <TD>"+arg0.getHeader(headerName));
					}
				out.println("</TABLE</BODY></HTML>");
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}	
	}
