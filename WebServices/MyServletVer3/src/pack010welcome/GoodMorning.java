package pack010welcome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodMorning extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
			throws IOException
			{	arg1.setContentType("text/html");
				PrintWriter out = arg1.getWriter();
				
				out.println("Good Morning All!!<BR>");
				System.out.println("on page");
				out.close();
			}

	@Override
	public String getServletInfo() {
		String s = "Servlet designed by Chandra";
		return super.getServletInfo()+s;
	}
	}