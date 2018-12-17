package pack010welcome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packcommon.ServletUtilities;

public class WhatsTimeNow extends HttpServlet
	{		private void commonFunction(HttpServletRequest arg0, HttpServletResponse arg1)
				throws IOException
				{	PrintWriter out = arg1.getWriter();
					ServletUtilities.pageHead(arg1, "World Clock");
					
						out.println("Time India       :"+ZoneWiseTime.getTimeInZone("India")+"<BR>"+"<BR>");
						out.println("Time USA     	  :"+ZoneWiseTime.getTimeInZone("usa")+"<BR>"+"<BR>");
						out.println("Time Russia      :"+ZoneWiseTime.getTimeInZone("Russia")+"<BR>"+"<BR>");
						out.println("Time Japan       :"+ZoneWiseTime.getTimeInZone("Japan")+"<BR>"+"<BR>");
						out.println("Time Britain	  :"+ZoneWiseTime.getTimeInZone("Britain")+"<BR>"+"<BR>");
						out.println("Time South Africa:"+ZoneWiseTime.getTimeInZone("South Africa")+"<BR>");
						
						ServletUtilities.pageFoot(arg1);
				}
			protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
				throws IOException
				{	commonFunction(arg0, arg1);	}
			protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
				throws IOException
				{	commonFunction(arg0, arg1);	}
	}
