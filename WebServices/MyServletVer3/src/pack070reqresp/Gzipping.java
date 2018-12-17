package pack070reqresp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gzipping extends HttpServlet
	{	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	String encodings = arg0.getHeader("Accept-Encoding");
				
				PrintWriter out;
				String title;
				arg1.setContentType("text/plain");
				if ((encodings !=null) && (encodings.indexOf("gzip")!=-1))
					{	title = "Page Encoded with GZip";
						OutputStream out1 = arg1.getOutputStream();
						out = new PrintWriter(new GZIPOutputStream(out1), false);
						arg1.setHeader("Content-Encoding", "gzip");
					}
				else
					{	title = "Un-encoded Page.";
						out = arg1.getWriter();
					}
				out.println("<HTML><HEAD><TITLE>"+title+"</TITLE></HEAD>");
				out.println("<BODY BGCOLOR=\"#FDF5E6\">");
				out.println("<H1 ALIGN=CENTER>"+title+"</H1>");
				for(int i =0; i<10000; i++)
					out.println("-foo-faa");
				out.println("</TABLE</BODY></HTML>");
				out.close();
			}

		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);}
	}
