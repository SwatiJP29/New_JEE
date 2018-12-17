package pack130usecookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookies extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	String name = arg0.getParameter("name");
				System.out.println("Value collected from form"+name);
				if (name!="")
					{	Cookie cook = new Cookie("name", name);
						cook.setMaxAge(1200);
						arg1.addCookie(cook);
					}
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);}	
	}
