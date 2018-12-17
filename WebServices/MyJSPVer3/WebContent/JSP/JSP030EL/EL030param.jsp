<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>JSP Collect Parameters</TITLE>
	</HEAD>
	<%-- #FEF6E5 --%>
	<%! String color = "#FEF6E5"; 	%>
	<BODY BGCOLOR = <%= color %>>
			<%@ page isELIgnored='false' %>
			<H1> param.flights </H1>
			
			<TABLE BORDER=1 ALIGN=CENTER>
				<TR BGCOLOR="#FFAD00">
					<TH>Information<TH>Details
						<TR><TD>Email Address<TD>${ param.emailAddress }
						<TR><TD>Origin       <TD>${ param.origin }
						<TR><TD>Destination  <TD>${ param.desti }
						<TR><TD>Total Cost   <TD>${ param.totCost }
						<TR><TD>Advance Paid <TD>${ param.advance }
						<TR><TD>Context Value <TD>${ initParam.value1 }
						<TR><TD>Config  Value <TD>${ initParam.value2 }
						<TR><TD>Config  Value <TD><%= config.getInitParameter("value2") %>
			</TABLE>
	</BODY>
</HTML>
		