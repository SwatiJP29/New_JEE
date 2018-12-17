package pack010welcome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet
	{		private void commonFunction(HttpServletRequest arg0, HttpServletResponse arg1)
				throws IOException
				{	PrintWriter out = arg1.getWriter();
					
					// Page Head
					arg1.setContentType("text/html");
					out.print("<HTML>");
						out.print("<HEAD>");
							out.print("<TITLE>");
								out.print("Welcome");
							out.print("</TITLE>");
						out.print("</HEAD>");
						out.print("<BODY>");
						
						for(int i=1; i<=5;i++) {
							out.print("<H"+i+">Servlet Technology welcomes you!!!</H"+i+"><br/>");
							out.print("asdfasdf");
						}
					// Page footer
						out.print("</BODY>");
					out.print("</HTML>");
					out.close();
				}
			protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
				throws IOException
				{	commonFunction(arg0, arg1);	}
			protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
				throws IOException
				{	commonFunction(arg0, arg1);	}
	}
