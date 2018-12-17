package pack065upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 public class DownloadImage extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			File file=null;
			FileInputStream fin=null;
			try{
				//file=new File(request.getPathTranslated());
				file = new File("C:\\oracle\\ora90\\classes\\oracle\\sysman\\vif\\images\\root.jpeg");
				fin=new FileInputStream(file); 
			}
			catch(FileNotFoundException e){
				response.setContentType("text/plain"); 
				PrintWriter out=response.getWriter();
				out.println("FILE NOT FOUND: "+request.getPathTranslated());	
				out.close();
			}
			byte data[]=new byte[(int)file.length()];  
			fin.read(data); 
			fin.close();  
			ServletOutputStream imageOut= response.getOutputStream(); 
			if (request.getRequestURI().indexOf(".gif")>0)	
				response.setContentType("image/gif"); 
			else     	
				response.setContentType("image/jpeg");  
				imageOut.write(data);  
				imageOut.close();
		}
	}   	  	    