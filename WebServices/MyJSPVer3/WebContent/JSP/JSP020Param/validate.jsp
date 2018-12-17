<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>JSP Collect Parameters from Servlet</TITLE>
	</HEAD>
	<%! String color = "#FEF6E5"; 	%>
	<BODY BGCOLOR = <%= color %>>
			<%@ page errorPage = "Errors.jsp" %>
			<jsp:useBean id = "entry" class = "pack020param.TravAgentBean" scope = "session"/>
			
			<TABLE BORDER=1 ALIGN=CENTER>
				<TR BGCOLOR="#FFAD00">
					<TH>Information<TH>Details
						<TR><TD>Email Address<TD><jsp:getProperty name = "entry" property="emailAddress" />
						<TR><TD>Email Address<TD>${entry.origin}
						<TR><TD>Origin       <TD><jsp:getProperty name = "entry" property="origin" />
						<TR><TD>Destination  <TD><jsp:getProperty name = "entry" property="destination" />
						<TR><TD>Total Cost   <TD><jsp:getProperty name = "entry" property="totalCost" />
						<TR><TD>Advance Paid <TD><jsp:getProperty name = "entry" property="advance" />
			</TABLE>
	</BODY>
</HTML>