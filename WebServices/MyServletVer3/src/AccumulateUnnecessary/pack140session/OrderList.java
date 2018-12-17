package pack140session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderList extends HttpServlet
	{	
		protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	HttpSession sess = arg0.getSession(false);
				PrintWriter out = arg1.getWriter(); //&nbsp;
				if (sess == null)
					{	out.println("Please visit opening page.");
						out.println("<a href='/SessionTracking122/html/ItemRac.html'>Go now</a>");
					}
				String custName = (String)sess.getAttribute("name");
				String [] itemList = (String[])sess.getAttribute("items");
				String sessId = (String)sess.getAttribute("sessId");
				
				Cookie [] coo = arg0.getCookies();
				
				out.println("<FORM ACTION = '/SessionTracking122/order' METHOD = 'POST'>");
				out.println("<TABLE ALIGN='center' WIDTH='100%' cellspacing='2' cellpadding='2' border=3>");
					out.println("<TR><TH align='left'><B>Customer's Name</B><TH align='left'>"+custName);
					out.println("<TR><TD align='left'><B>Session Identifier</B><TH align='left'>"+sessId);
				ArrayList al = new ArrayList();
					if (itemList!=null)
						for(int i=0;i<itemList.length; i++)
							{	out.println("<TR><TD align='center'><B>"+(1+i)+"</B><TH align='left'>"+itemList[i]);
								al.add(itemList[i]);
							}
					if (coo!=null)
						for(int i=0, j=0; i<coo.length; i++)
							{	if (coo[i].getName().indexOf("Ord"+custName)!=-1)
									{	out.println("<TR><TD align='center'><B>"+(((itemList!=null)?itemList.length:0)+1+(j++))+"</B><TH align='left'>"+coo[i].getValue());
										al.add(coo[i].getValue());
									}
							}
				itemList=new String[al.size()];
				Iterator it = al.iterator();
				for(int i=0; it.hasNext(); i++)
					itemList[i] = (String) it.next();
				sess.setAttribute("items", itemList);
				out.println("</TABLE>");
				out.println("<INPUT TYPE='SUBMIT' NAME='submit' VALUE = 'ORDER NOW'/>");
				out.println("<INPUT TYPE='SUBMIT' NAME='submit' VALUE = 'ORDER LATER'/>");
				out.println("</FORM>");
			}
	
		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}	
	}
