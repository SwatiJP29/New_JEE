package pack140session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderFinal extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	HttpSession sess = arg0.getSession(false);
				PrintWriter out = arg1.getWriter();
				
				String orderchoice = arg0.getParameter("submit");
				String custName = (String) sess.getAttribute("name");
				String [] itemList = (String[])sess.getAttribute("items");
				
				if (orderchoice.equals("ORDER NOW"))
					{	ServletContext sct = this.getServletContext();
						String jndi = sct.getInitParameter("jndi");
						try	{	OrderBean ob = new OrderBean(jndi);
								ob.addNew(custName, itemList);
							}
						catch(NamingException ne)
							{	throw new ServletException("Problem in JNDI Lookup", ne);}
						catch(SQLException se)
							{	throw new ServletException("Problem in Table handling", se);}
					}	
				else
					for(int i=0; i<itemList.length; i++)
						{	Cookie co = new Cookie("Ord"+custName+i, itemList[i]);
							co.setMaxAge(3600); // For a week
							arg1.addCookie(co);
							out.println("Ord"+custName+i+": "+itemList[i]+"<BR>");
						}
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);}		
	}
