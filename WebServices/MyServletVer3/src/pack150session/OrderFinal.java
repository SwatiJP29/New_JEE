package pack150session;

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

import packcommon.ServletUtilities;
import packcommon.UserMasterDAO;

public class OrderFinal extends HttpServlet
	{	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
			{	PrintWriter out = response.getWriter();
				
				// These statements on the top of every servlet/JSP
		        HttpSession sess = request.getSession(false);
		        if (sess==null){
		            response.sendRedirect("/MyServletVer3/html/form150login.html");
		        }
		        String ufName = (String) sess.getAttribute("UserFullName");
		        String uName = (String) sess.getAttribute("UserName");
		        String passWord = (String) sess.getAttribute("PassWord");
		        
		        ServletContext sct = this.getServletContext();
		        
		        try {
		            UserMasterDAO sbb = (UserMasterDAO) sct.getAttribute("UserMaster");
		            if (sbb.isUserAuthenticated(uName, passWord)==null){
		            	sess.invalidate();
		                response.sendRedirect("/MyServletVer3/html/form150login.html");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        
				String orderchoice = request.getParameter("submit");
				String[] itemList = request.getParameterValues("items");
				
				ServletUtilities.pageHead(response, "Ordering your items");
				
				if (orderchoice.equals("ORDER NOW"))
					{	OrderBean ob = null;
						/*String jndi = sct.getInitParameter("jndi");*/
						try	{	ob = new OrderBean();
								ob.addNew(uName, itemList);
				            out.println("Your order has been confirmed.  Visit again.");
				            
				            // Remove cookies
						    Cookie co = new Cookie("Ord"+uName, "");
		                    co.setMaxAge(0); // Trick for deleting cookie.
		                    response.addCookie(co);
		                    
		                    // Invalidate session.
		                    sess.invalidate();
		                    ob.closeConnection();
							}
						catch(SQLException se)
							{	throw new ServletException("Problem in Table handling", se);}
					}	
				else    {
				    String itemLStr="";
					for(int i=0; i<itemList.length; i++)
						itemLStr += itemList[i];// itemStr="BatBall";
				    Cookie co = new Cookie("Ord"+uName, itemLStr);
				    co.setMaxAge(604800); // For a week
				    response.addCookie(co);
                    out.println("Pls visit website within one week.");
                    
                    sess.invalidate();
			}
		}
	
		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);}		
	}
