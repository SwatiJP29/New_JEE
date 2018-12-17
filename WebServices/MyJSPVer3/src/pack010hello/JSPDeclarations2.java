package pack010hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.Calendar;

public class JSPDeclarations2 extends HttpServlet
{	// Instance field declaration
		int hitCount;
		Date lastDateOfHit;
		
		// Init Method Declaration
		public void init()
			{	hitCount = 0;
				lastDateOfHit = new Date();
				System.out.println("Initialization and enguaging resources.");	
			}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
			{	ServletContext application = this.getServletContext();
				ServletConfig config = this.getServletConfig();
				HttpSession session = request.getSession();
				PrintWriter out = response.getWriter();
				
				response.setContentType("text/html");
				out.println("Servlet Context Information...<BR>");
				out.println("Server Information: ");
				out.println(application.getServerInfo());
				out.println("<BR>");
				out.println("Major Version: ");
				out.println(application.getMajorVersion());
				out.println("<BR>");
				out.println("Minor Version: ");
				out.println(application.getMinorVersion());
				out.println("<BR>");
				out.println("Servlet Context: ");
				out.println(application.getServletContextName());
				out.println("<BR>");
				
				out.println("<BR>Servlet Config Information...<BR>");
				out.println("Servlet Name: ");
				out.println(config.getServletName());
				out.println("<BR>");
				
				out.println("<BR>Session Information...<BR>");
				out.println("Sessin ID: ");
				out.println(session.getId());
				out.println("<BR>");
				out.println("Last time access: ");
				out.println(session.getLastAccessedTime());
				out.println("<BR>");
				out.println("Creation time: ");
				out.println(session.getCreationTime());
				out.println("<BR>");
				
				out.println("<BR><BR>This servlet is hit for ");
				out.println(++hitCount);
				out.println(" number of times. The last hit is on "+formatDate(lastDateOfHit)+".");
				lastDateOfHit = new Date();
			}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
			{	doGet(request, response);	}
		
		public void destroy()
			{	System.out.println("Resources Released.");	}
		
		public String formatDate(Date dt)
			{	Calendar cal = Calendar.getInstance();
				cal.setTime(dt);
				String td = cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR);
				return td;
			}
	}