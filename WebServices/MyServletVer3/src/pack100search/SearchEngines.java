package pack100search;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchEngines extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	String srchStr = arg0.getParameter("subject");
				String srchEngine = arg0.getParameter("engine");
				
				if ((srchStr==null) ||(srchStr.length()==0))
					{	reportProblem(arg1, "Missing Search String.");
						return;
					}
				
				String url = SearchSpec.getURLforEngine(srchEngine, srchStr);
				
				if (url != null)
					arg1.sendRedirect(url);
				else
					reportProblem(arg1, "Unrecognized Search Engine.");
			}
	
		private void reportProblem(HttpServletResponse arg1, String msg) throws IOException
			{	arg1.sendError(HttpServletResponse.SC_NOT_FOUND, "<H2>"+msg+"</H2>");}
		
		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}	
	}
