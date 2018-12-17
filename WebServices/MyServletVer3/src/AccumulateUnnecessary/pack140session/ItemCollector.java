package pack140session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ItemCollector extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	HttpSession sess = arg0.getSession(true);
		
				String custName = arg0.getParameter("name");
				String [] itemList = arg0.getParameterValues("items");
				String sessId = sess.getId();
				
				sess.setAttribute("name", custName);
				sess.setAttribute("items", itemList);
				sess.setAttribute("sessId", sessId);
				RequestDispatcher rd = arg0.getRequestDispatcher("/orderlist");
				rd.forward(arg0, arg1);
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}	
	}
