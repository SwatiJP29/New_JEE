package pack040user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packcommon.ServletUtilities;
import packcommon.UserMasterDAO;
import packcommon.packexceptions.DuplicateUserException;

public class Login extends HttpServlet
	{	UserMasterDAO sbb;
	
		public void init() throws ServletException
			{	super.init();
				String driver, url, user, passwd;
				
				ServletContext sct = this.getServletContext();
				driver = sct.getInitParameter("drv");
				url = sct.getInitParameter("url");
				
				ServletConfig sc = this.getServletConfig();
				user = sc.getInitParameter("user");
				passwd = sc.getInitParameter("pass");
				
				try {	sbb = new UserMasterDAO(driver, url, user, passwd);
						System.out.println("Connection opened.");
					}
				catch (SQLException e)
					{	e.printStackTrace();	}
			}
		
		protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{
				String ufName, uName, passWord;
				
				uName = arg0.getParameter("UNAME");
				passWord = arg0.getParameter("PASSWORD");
				
				PrintWriter out = arg1.getWriter();
				arg1.setContentType("text/plain");
				
				try {	ufName = sbb.isUserAuthenticated(uName, passWord);
						if (ufName!=null)
							welcomeWebPage(ufName, arg1);
						else
							loginFailedWebPage(uName, arg1);
					}
				catch (SQLException e){
					e.printStackTrace();
				}
				finally{
					out.close();
				}
			}
	
		private void welcomeWebPage(String ufName, HttpServletResponse arg1)
			throws IOException {
			ServletUtilities.pageHead(arg1, "Welcome Mr./Ms. "+ufName);
			PrintWriter out = arg1.getWriter();
			out.println("<H3>Welcome Mrs./Ms. "+ufName+"</H3>");
			ServletUtilities.pageFoot(arg1);
		}
		
		private void loginFailedWebPage(String uName, HttpServletResponse arg1)
			throws IOException {
			ServletUtilities.pageHead(arg1, "Login Failed.");
			PrintWriter out = arg1.getWriter();
			out.println("Authentication Failed.  Will you pls try to login again?<BR>");
			out.println("<A HREF='/MyServletVer3/html/form040login.html'>Login</A>");
			ServletUtilities.pageFoot(arg1);
		}
		
		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}
		
		public void destroy()
			{	try {	sbb.closeConnection();
						System.out.println("Connection being closed.");
					}
				catch (SQLException e)
					{	e.printStackTrace();	}
			}
	}