<! DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%-- This is JSPDeclarations.jsp.  It demonstrates declarations in JSP.  This comment
	 is translated in servlet but does not seapage to HTML page --%>

<!-- This is HTML page.  It is passed to browser as a part of html-->


<%-- Demo fi JSP Declarations, JSP scriptlets, JSP Expression, JSP Directives --%>

<%@ page import = "java.util.Date, java.util.Calendar" %>

<%-- Instance Field Declarations --%>
	<%! int hitCount;
		Date lastDateOfHit;
	%>

<%--Declaring jspInit() Method --%>
	<%! public void jspInit()
			{	hitCount = 0;
				lastDateOfHit = new Date();
				System.out.println("Initialization and enguaging resources.");	
			}
	%>

<%-- Declaring jspDestroy() Method--%>
	<%! public void jspDestroy()
			{	System.out.println("Resources Released.");	}
	%>

<%-- Contents of jspService() Method --%>
<%@ page contentType = "text/html" %>


Servlet Context Information...<BR>
	Server Information:  <%= application.getServerInfo()%><BR>
	Major Version: <%= application.getMajorVersion()%><BR>
	Minor Version: <%= application.getMinorVersion()%><BR>
	Servlet Context: <%= application.getServletContextName()%><BR>
<BR>
<% out.println("agadfasdfasdf"); %>

Servlet Config Information...<BR>
	Servlet Name: <%= config.getServletName()%><BR>

<BR>
Session Information...<BR>
	Sessin ID: <%= session.getId()%><BR>
	Last time access: <%= session.getLastAccessedTime()%><BR>
	Creation time: <%= session.getCreationTime()%><BR>

<BR><BR><BR>
	This JSP is hit for <%= (++hitCount)%> number of times. The last hit is on <%= formatDate(lastDateOfHit)%>
	Todays Date:<%= new java.util.Date()%>
	<% lastDateOfHit = new Date();%>
	
<%-- Declaring formatDate() Method--%>
	<%! public String formatDate(Date dt)
			{	Calendar cal = Calendar.getInstance();
				cal.setTime(dt);
				String td = cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR);
				return td;
			}
	%>