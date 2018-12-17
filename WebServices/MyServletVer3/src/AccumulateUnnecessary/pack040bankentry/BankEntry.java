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

import packcommon.UserMasterDAO;

public class BankEntry extends HttpServlet
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
				String accNm, accAdd;
				float accBal;
				
				accNm = arg0.getParameter("accname");
				accAdd = arg0.getParameter("accaddress");
				accBal = Float.parseFloat(arg0.getParameter("accbalance"));
				
				PrintWriter out = arg1.getWriter();
				arg1.setContentType("text/plain");
				out.println("Account being added: "+accNm+" "+accAdd+" "+accBal);
				
				try {	sbb.addNewUser(userFName, userName, userPassword)(accNm, accAdd, accBal);
						out.println("Account added.");
					}
				catch (SQLException e)
					{	e.printStackTrace();	}
				out.close();
			}
	
		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}
		
		public void destroy()
			{	try {	sbb.closeAll();
						System.out.println("Connection being closed.");
					}
				catch (SQLException e)
					{	e.printStackTrace();	}
			}
	}
