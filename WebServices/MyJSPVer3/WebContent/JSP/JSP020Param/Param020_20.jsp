<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.1 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>JSP Collect Parameters</TITLE>
	</HEAD>
	<%-- #FEF6E5 --%>
	<%! String color = "#FEF6E5"; 	%>
	<BODY BGCOLOR = <%= color %>>
					
			<H1> <%= request.getParameter("flights")%> </H1>
			<jsp:useBean id = "entry" class = "pack020param.TravAgentBean" />
			
			<%-- 1 --%>
				<jsp:setProperty name = "entry" property = "emailAddress" value = '<%= request.getParameter("emailAddress") %>'/>
			
			<%-- 2 --%>
				<% 	float tcost = 1.0f;
					try {
							tcost = Float.parseFloat(request.getParameter("totCost"));
						}
					catch(NumberFormatException nfe)
						{}
				%>
				<jsp:setProperty name = "entry" property = "totalCost" 	value = "<%= tcost %>" />
			
			<%-- 3 --%>
				<jsp:setProperty name = "entry" property = "destination" param = "desti" />
				<jsp:setProperty name = "entry" property = "totalCost" 	param = "totCost" />
				
			<%-- 4 --%>
				<jsp:setProperty name = "entry" property = "advance" />
				<jsp:setProperty name = "entry" property = "origin"  />
			
			<TABLE BORDER=1 ALIGN=CENTER>
				<TR BGCOLOR="#FFAD00">
					<TH>Information<TH>Details
						<TR><TD>Email Address<TD><jsp:getProperty name = "entry" property="emailAddress"/>
						<TR><TD>Origin       <TD><jsp:getProperty name = "entry" property="origin" />
						<TR><TD>Destination  <TD><jsp:getProperty name = "entry" property="destination" />
						<TR><TD>Total Cost   <TD><jsp:getProperty name = "entry" property="totalCost" />
						<TR><TD>Advance Paid <TD><jsp:getProperty name = "entry" property="advance" />
			</TABLE>
	</BODY>
</HTML>