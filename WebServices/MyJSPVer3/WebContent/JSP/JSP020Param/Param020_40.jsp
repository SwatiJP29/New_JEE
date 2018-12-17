<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>JSP Collect Parameters</TITLE>
	</HEAD>
	<%-- #FEF6E5 --%>
	<%! String color = "#FEF6E5"; 	%>
	<BODY BGCOLOR = <%= color %>>
			<%@ page errorPage = "Errors.jsp" %>
			<H1> <%= request.getParameter("flights")%> </H1>
			<jsp:useBean id = "entry" class = "pack020param.TravAgentBean" scope = "session"/>
			
			<%-- 6 --%>
			<jsp:setProperty name = "entry" property = "*" />
	
			<jsp:forward page = "/validate"/>
	</BODY>
</HTML>