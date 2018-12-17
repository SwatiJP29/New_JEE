package pack180ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ssi.SSIServlet;


public class CurrentTime extends SSIServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		Date date = new Date();
		DateFormat df = DateFormat.getInstance();
		String zone = req.getParameter("zone");
		if (zone != null) {
		TimeZone tz = TimeZone.getTimeZone(zone);
		df.setTimeZone(tz);
		}
		out.println(df.format(date));
		}
}
