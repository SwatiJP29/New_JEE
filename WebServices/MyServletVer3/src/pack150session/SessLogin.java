package pack150session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import packcommon.ServletUtilities;
import packcommon.UserMasterDAO;
import packcommon.packexceptions.DuplicateUserException;

public class SessLogin extends HttpServlet
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
				        sct.setAttribute("UserMaster", sbb);
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
				
				try {
					ufName = sbb.isUserAuthenticated(uName, passWord);
					//ufName="Chandrashekhar";
 
					if (ufName!=null)
					    welcomeWebPage(arg0, arg1, ufName, uName, passWord);
					else
						loginFailedWebPage(uName, arg1);
					
					ServletUtilities.pageFoot(arg1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
		private void welcomeWebPage(HttpServletRequest arg0, HttpServletResponse arg1, String ufName, String uName, String passWord)
			throws IOException, ServletException {
			ServletUtilities.pageHead(arg1, "Welcome Mr./Ms. "+ufName);
			PrintWriter out = arg1.getWriter();
			out.println("<H3>Welcome Mrs./Ms. "+ufName+"</H3>");
			
			// Create session
			HttpSession sess = arg0.getSession(true);
			
			// Put values to the session
			sess.setAttribute("UserFullName", ufName);
			sess.setAttribute("UserName", uName);
			sess.setAttribute("PassWord", passWord);
			/*
			// Receive cookies if any from previous session
			Cookie[] coo = arg0.getCookies();
			ArrayList al = new ArrayList();;
			if (coo!=null) {
                for(int i=0; i<coo.length; i++)   
                   if (coo[i].getName().indexOf("Ord"+uName)!=-1)
                       al.add(coo[i]);
            }
			sess.setAttribute("ItemList", al);
			*/
			System.out.println("before dispatch");
			
			// Including Items layout from another servlet
			RequestDispatcher rd = arg0.getRequestDispatcher("/enterlist");
			rd.include(arg0, arg1);
			System.out.println("after dispatch");
		}
		
		private void loginFailedWebPage(String uName, HttpServletResponse arg1)
			throws IOException {
			ServletUtilities.pageHead(arg1, "Login Failed.");
			PrintWriter out = arg1.getWriter();
			out.println("Authentication Failed.  Will you pls try to login again?<BR>");
			out.println("<A HREF='/MyServletVer3/html/form150login.html'>Login</A>");
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