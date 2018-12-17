package pack065upload;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class UploadImage extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=GB2312";
	String fileName = null;
	ServletContext sc = null;
	

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType(CONTENT_TYPE);
	PrintWriter out = response.getWriter();
	out.println(
	"<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">");
	out.println("<tr>\n <td class=tablebody1>\n<form name=\"upload_file_form\" method=\"post\" action=\"upload\" enctype=\"multipart/form-data\">");
	out.println("<input type=\"file\" name=\"filename\" accept=\"image/gif,image/jpeg\">");
	out.println("<input type=\"submit\" name=\"Submit\" value=\"Go\"");
	out.println("</form>");
	out.print("</td></tr></table>");
	System.out.println("In Get method.");
	}

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType(this.CONTENT_TYPE);
	
	this.getData(request, response);
}

private void getData(HttpServletRequest request, HttpServletResponse response) 
throws IOException {
	PrintWriter out = null;
	InputStream input = null;
	BufferedOutputStream output = null;
	try {
		out = response.getWriter();
		byte data[] = null;
		String uploadContentType = request.getContentType();
		
		//if (uploadContentType != null && uploadContentType.indexOf("multipart/form-data") != -1) {
			input = request.getInputStream();
			int dataLength = request.getContentLength();
			data = new byte[dataLength];
			int onceRead = 0;
			int totalRead = 0;
			
			while ( (totalRead < dataLength) && (onceRead >= 0)) {
				onceRead = input.read(data, totalRead, dataLength);
				totalRead += onceRead;
			}
		//}
		
		//----
		String dataString = new String(data);
		data = null;
		int indexOfUploadFile = 0;
		indexOfUploadFile = dataString.indexOf("filename=\"");
		String fileName = "filename=\"";
		int fileName_index = fileName.length();
		//	----
		dataString = dataString.substring(indexOfUploadFile + fileName_index);
		String upload_file_name = dataString.substring(0, dataString.indexOf("\""));
		upload_file_name = upload_file_name.substring(upload_file_name.lastIndexOf("\\") + 1);
		//-----
		dataString.substring(dataString.indexOf("\"") + 1);
		//-----
		dataString = dataString.substring(dataString.indexOf("\r\n\r\n") +4);
		int boundaryIndex = uploadContentType.indexOf("boundary=");
		String boundary = uploadContentType.substring(boundaryIndex + "boundary=".length());
		boundary = boundary.trim();
		//------
		dataString = dataString.substring(0, dataString.indexOf(boundary)-4);
		
		String upload_file_path_name = "e:\\" + upload_file_name;
		output = new BufferedOutputStream(new FileOutputStream(upload_file_path_name, true));
		output.write(dataString.getBytes());
		out.println("upload success");
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	finally {
		try {
			input.close();
			output.close();
			out.close();
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	}
} 