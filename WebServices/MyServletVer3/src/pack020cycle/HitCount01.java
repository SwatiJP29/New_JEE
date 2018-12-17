package pack020cycle;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HitCount01 extends HttpServlet implements SingleThreadModel
	{	int hitCount;
		
	// Do not use constructors in servlet.
		public void init() throws ServletException {
			super.init();
			hitCount = 0;
		}

		protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	PrintWriter out = arg1.getWriter();
			
				arg1.setContentType("text/html");
				synchronized (this) {
					out.println("This website is hit "+(++hitCount)+" no. of times.");
				}
				
				out.close();
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}
	}

