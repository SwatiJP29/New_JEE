/* Getting text box parameters
 * Getting password box parameters
 * Getting Text area parameters
 * Getting check box parameters
 * Getting radio buttons parameters
 * Getting combo box parameters
 * Getting submit button parameters
 * 
 * using getParameter
 * using getParameterValues
 * using getParameterNames
 * using getParameter(getParameterNames())
 * 
 * 
 * 
 * 
 * Incorporate response in tabular form.
 */
package pack030parameters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packcommon.ServletUtilities;

public class CollectParam extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException 
			{	process(arg0, arg1);	}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	process(arg0, arg1);	}
		
		private void process(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	// Collecting Parameters
				String firstName = arg0.getParameter("fname");		// Text box
				String secondName = arg0.getParameter("sname");		// Text box
				String passWord = arg0.getParameter("pass");		// Password box
				String maritalStatus = arg0.getParameter("marital");	// Radio Buttons
				String yourAddress = arg0.getParameter("address");	// Text Area
				String yourCity = arg0.getParameter("city");	// Combo box
				String yourChoice = arg0.getParameter("choice");	// Submit Button
				
				String []news = arg0.getParameterValues("news");	// Check boxes
				
				// Preparing web page
				arg1.setContentType("text/html");
				PrintWriter out = arg1.getWriter();
				ServletUtilities.pageHead(arg1, "Win Prize on General Survey");
					out.print("<H1 ALIGN=CENTER>"+"Win Prize on General Survey"+"</H1>");
					out.print("<H3>Here is your information...</H3><BR>");
					
					out.println("<TABLE BORDER=1 ALIGN=CENTER>");
					out.println("<TR BGCOLOR='#FFAD00'>");
					out.println("<TH>Hello Mr."+firstName+" "+secondName);
					out.println("<TR><TD>Pass word<TD>"+passWord);
					out.println("<TR><TD>Marital Status<TD>"+maritalStatus);
					out.println("<TR><TD>Address<TD>"+yourAddress);
					out.println("<TR><TD>City<TD>"+yourCity);
					out.println("<TR><TD>Choice<TD>"+yourChoice);
					if (news != null)
						{	out.println("<TR><TD>News Paper/s");
							out.println("<TD>"+news[0]);
							for(int i=1; i<news.length; i++)
								{	out.println(" & "+news[i]);	}
						}
					out.println("</TABLE>");
					ServletUtilities.pageFoot(arg1);
			}
	}
