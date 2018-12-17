package pack030el;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pack020param.TravAgentBean;


 public class SetObjects extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(true);
		TravAgentBean tab = new TravAgentBean();
		tab.setEmailAddress("cbdesh2000@yahoo.com");
		tab.setOrigin("Mumbai");
		tab.setDestination("Mumbai");
		tab.setAdvance(5000);
		tab.setTotalCost(15000);
		
		ArrayList wN = new ArrayList();
		wN.add("Sunday");wN.add("Monday");wN.add("Tuesday");wN.add("Wednesday");
		wN.add("Thursday");wN.add("Friday");wN.add("Saturday");wN.add("Mannaday");
		
		String[] mN = {"Jan","Feb", "Mar", "Apr"};
		
		HashMap hm = new HashMap();
		hm.put("Deshpande", "Chandra");
		hm.put("Mishra", "Rakesh");
		hm.put("Dawane", "Vishal");
		hm.put("Govindraj", "Nagarjun");
		
		sess.setAttribute("Bean", tab);
		sess.setAttribute("WeekNames", wN);
		sess.setAttribute("MonthNames", mN);
		sess.setAttribute("Friends", hm);
		RequestDispatcher rd = request.getRequestDispatcher("/objects");
		rd.forward(request, response);
	}  	  	    
}