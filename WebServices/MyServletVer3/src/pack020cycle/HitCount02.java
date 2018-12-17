package pack020cycle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packcommon.ServletUtilities;

public class HitCount02 extends HttpServlet 
	{	int hitCount;
		String filePath = "";
		String fileName = "CurrentCount.num";
		File f;
		
		public void init() throws ServletException
			{	System.out.println("Init method being invoked.");
				
				FileInputStream fi=null;
				DataInputStream di=null;
				
				f=new File(filePath+File.separator+fileName);
				
				try {	if (f.exists())
							{	fi = new FileInputStream(f);
								di = new DataInputStream(fi);
								
								hitCount = di.readInt();
								
								di.close();
								fi.close();
							}
						else
							hitCount = 0;
					}
				catch(IOException i)
					{	throw new ServletException("Input file currepted.", i);	}
			}
		
		protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	System.out.println("Servlet receiving subsequent requests.");
				PrintWriter out = arg1.getWriter();
			
				ServletUtilities.pageHead(arg1, "Pragati Software Pvt. Ltd.");
				
				out.println("<H1>Pragati Software Private Limited</H1>");
				out.println("This website is hit "+(hitCount++)+" no. of times.");
				//out.println("User Dir."+System.getProperty("user.dir"));
				
				ServletUtilities.pageFoot(arg1);
			}
 
		protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
			{	doGet(arg0, arg1);	}
		
		public void destroy()
			{	System.out.println("Object being undeployed from server..");
				try	{	FileOutputStream fo = new FileOutputStream(f);
						DataOutputStream dos = new DataOutputStream(fo);
												
						dos.writeInt(hitCount);
						
						dos.close();
						fo.close();
					}
				catch(IOException io)
					{	}
			}
	}
