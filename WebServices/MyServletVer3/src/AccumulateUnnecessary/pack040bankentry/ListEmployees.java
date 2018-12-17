package pack040bankentry;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListEmployees extends HttpServlet
	{	SavingBankBean sbb;	
		public void init() throws ServletException
			{	super.init();
				String driver, url, user, passwd;
				
				ServletContext sct = this.getServletContext();
				driver = sct.getInitParameter("drv");
				url = sct.getInitParameter("url");
				
				ServletConfig sc = this.getServletConfig();
				user = sc.getInitParameter("user");
				passwd = sc.getInitParameter("pass");
				
				try {	sbb = new SavingBankBean(driver, url, user, passwd);
						System.out.println("Connection opened.");
					}
				catch (ClassNotFoundException e)
					{	e.printStackTrace();	}
				catch (SQLException e)
					{	e.printStackTrace();	}
			}
		
		protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	PrintWriter out = arg1.getWriter();	
				arg1.setContentType("text/html");
				out.print("<HTML>");
				out.print("<HEAD>");
					out.print("<TITLE>");
						out.print("List Names.");
					out.print("</TITLE>");
					out.print("<BODY>");
					try {	queryTable(out, "Select * from accountmaster");	}
					catch (SQLException e)
						{	e.printStackTrace();	}
					catch (IOException e)
						{	e.printStackTrace();	}
					out.print("</BODY>");	
				out.print("</HEAD>");
			out.print("</HTML>");
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}
		
		public void queryTable(PrintWriter out, String query) throws SQLException, IOException
			{	String [][]table=sbb.queryTable(query);
				
				out.println("<TABLE BORDER=1 ALIGN=CENTER>");
				out.println("<TR BGCOLOR='#FFAD00'>");
				for(int i =0; i<table[0].length; i++)
					out.println("<TH>"+table[0][i]);
				
				for(int i=1; i<table.length; i++)
					{	out.println("<TR>");
						for(int j=0; j<table[i].length; j++)
							out.println("<TD>"+table[i][j]);
					}
				out.println("</TABLE>");
			}
	}
