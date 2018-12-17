package pack120cookietype;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class PrintHead99
	{	public static void PageHead(HttpServletResponse arg1, String str) throws IOException
			{  	arg1.setContentType("text/html");
				PrintWriter out = arg1.getWriter();
				out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
				out.print("<HTML>");
					out.print("<HEAD>");
						out.print("<TITLE>");
							out.print(str);
				        out.print("</TITLE>");
				    out.print("</HEAD>");
				    out.println("<BODY>");
			}
		public static void PageFoot(HttpServletResponse arg1) throws IOException
			{	PrintWriter out = arg1.getWriter();
					out.println("</BODY>");
				out.println("</HTML>");
			}
	}
