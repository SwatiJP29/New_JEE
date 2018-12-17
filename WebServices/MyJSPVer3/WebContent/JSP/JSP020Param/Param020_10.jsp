<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>JSP Collect Parameters</TITLE>
	</HEAD>
	<%-- #FEF6E5 --%>
	<%! String color = "#FEF6E5"; 	%>
	<BODY BGCOLOR = <%= color %>>
					
			<H1> <%= request.getParameter("flights")%> </H1>
			
			<% 	String val1 = request.getParameter("emailAddress");
				String val2 = request.getParameter("origin");
				String val3 = request.getParameter("desti");
				String val4 = request.getParameter("totCost");
				String val5 = request.getParameter("advance");
			%>
			<TABLE BORDER=1 ALIGN=CENTER>
				<TR BGCOLOR="#FFAD00">
					<TH>Information<TH>Details
						<TR><TD>Email Address<TD><%=val1%>
						<TR><TD>Origin       <TD><%=val2%>
						<TR><TD>Destination  <TD><%=val3%>
						<TR><TD>Total Cost   <TD><%=val4%>
						<TR><TD>Advance Paid <TD><%=val5%>
			</TABLE>
	</BODY>
</HTML>
		