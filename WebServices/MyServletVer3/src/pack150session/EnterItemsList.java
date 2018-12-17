package pack150session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import packcommon.ServletUtilities;
import packcommon.UserMasterDAO;

 public class EnterItemsList extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    
	    // These statements on the top of every servlet/JSP
	    HttpSession sess = request.getSession(false);
	    if (sess==null){
	        response.sendRedirect("/MyServletVer3/html/form150login.html");
	    }
	    String ufName = (String) sess.getAttribute("UserFullName");
        String uName = (String) sess.getAttribute("UserName");
        String passWord = (String) sess.getAttribute("PassWord");
        
	    ServletContext sct = this.getServletContext();
	    
	    try {
            UserMasterDAO sbb = (UserMasterDAO) sct.getAttribute("UserMaster");
            if (sbb.isUserAuthenticated(uName, passWord)==null){
            	sess.invalidate();
                response.sendRedirect("/MyServletVer3/html/form150login.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    
	    // Got the cookies list downloaded.
	    String srch;
	    Cookie[] cookies = request.getCookies();
	    if (cookies==null)
	        srch="";
	    else   {
	        Cookie coo = ServletUtilities.searchCookie(cookies, "Ord"+uName);
	        srch = (coo==null)?"":coo.getValue();
	    }
	   
	    //ServletUtilities.PageHead(response, "Choose Items from list");
	    out.println("<H1 ALIGN='CENTER'>Online shopping</H1>");
	    String ordFinalUrl = response.encodeURL("/MyServletVer3/ordfinal");
	    out.println("<FORM ACTION = '"+ordFinalUrl+"' METHOD = 'POST'>");
	        out.println("<TABLE ALIGN='CENTER' WIDTH='100%' cellspacing='2' cellpadding='2' border=3>");
	            out.println("<TR><TD><INPUT TYPE='CHECKBOX' NAME='items' VALUE='Bat'"+srchString(srch, "Bat")+"></TD><TD>Bat</TD>");
	            out.println("<TR><TD><INPUT TYPE='CHECKBOX' NAME='items' VALUE='Ball'"+srchString(srch, "Ball")+"></TD><TD>Ball</TD>");
	            out.println("<TR><TD><INPUT TYPE='CHECKBOX' NAME='items' VALUE='Pads'"+srchString(srch, "Pads")+"></TD><TD>Pads</TD>");
	            out.println("<TR><TD><INPUT TYPE='CHECKBOX' NAME='items' VALUE='Gloves'"+srchString(srch, "Gloves")+"></TD><TD>Gloves</TD>");
	            out.println("<TR><TD><INPUT TYPE='CHECKBOX' NAME='items' VALUE='W.Gloves'"+srchString(srch, "W.Gloves")+"></TD><TD>W.Gloves</TD>");
	            out.println("<TR><TD><INPUT TYPE='CHECKBOX' NAME='items' VALUE='Helmet'"+srchString(srch, "Helmet")+"></TD><TD>Helmet</TD>");
	        out.println("</TABLE>");
	        out.println("<BR><BR>");
	        out.println("<CENTER>");
	            out.println("<INPUT TYPE='SUBMIT' NAME='submit' VALUE = 'ORDER NOW'/>");
	            out.println("<INPUT TYPE='SUBMIT' NAME='submit' VALUE = 'ORDER LATER'/>");
	        out.println("</CENTER>");
	    out.println("</FORM>");
	}
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
        {   doGet(arg0, arg1);  }
	
	private String srchString(String srch, String item){
	    return (srch.indexOf(item)<0)?"":" CHECKED='checked'";
	}
}