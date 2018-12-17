package pack060response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneForAll extends HttpServlet
{	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{	String select = req.getParameter("flights");
			ServletContext context = getServletContext();
			InputStream is = null;
			if (select.equalsIgnoreCase("PDF"))
				{	res.setContentType("application/pdf");	// Setting content type.
					is = context.getResourceAsStream("/WEB-INF/data/Chapter 8 Handling Cookies.pdf");
				}
			else if (select.equalsIgnoreCase("DOC"))
				{	res.setContentType("application/msword");
					is = context.getResourceAsStream("/WEB-INF/data/ShortCut Keys.doc");
				}
			else if (select.equalsIgnoreCase("PPT"))
				{	res.setContentType("application/vnd.ms-powerpoint");
					is = context.getResourceAsStream("/WEB-INF/data/Presentation on JDBC.ppt");
				}
			else if (select.equalsIgnoreCase("EXL"))
				{	res.setContentType("application/vnd.ms-excel");
					is = context.getResourceAsStream("/WEB-INF/data/Employee.xls");
				}
			else
				{	res.setContentType("text/plain");
					is = context.getResourceAsStream("/WEB-INF/data/OrdinaryFile.txt");
				}
	        int read = 0;
	        byte bytes[] = new byte[1024];
	        OutputStream os = res.getOutputStream();
	        while((read = is.read(bytes))!= -1)
	        	{os.write(bytes, 0, read);}
	        os.flush();
	        os.close();
	    }
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
		{doGet(req, res);}
}