<! DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%-- This program uses content type of Excel sheet using HTML Table. --%>
<%-- I need to receive request parameter where client will specify 'excel' to
	view output in excel sheet otherwise in HTML Table.  Now the thing could not
	be realized using directive as request parameter may not be obtained for directive.
	Another way is use scriptlet.
--%>

<HTML>
	<HEAD>
		<TITLE>Setting content type.</TITLE>
	</HEAD>
	<BODY>
		<CENTER>
			<H2>Reading table in Excel, Doc or plain</H2>
			<%
				String format = request.getParameter("format");
				if (format==null)
					response.setContentType("text/html");
				else
					if (format.equals("excel"))
						response.setContentType("application/vnd.ms-excel");
					else
						response.setContentType("application/msword");
			%>
			<%@ page errorPage = "Errors.jsp" %>
			<jsp:useBean id = "entry" class = "packcommon.EmpBeanDAO" />
			<% String [][] listTable = entry.getListTable(); %>
				
			<TABLE BORDER=1>
			<TR><TH>Employee Id<TH>Employee Name
			<% for(int i = 0; i<listTable.length; i++)
			 			{ %>
				<TR><TD><%= listTable[i][0] %><TD><%= listTable[i][1] %>
				<% } %>
			</TABLE>
		</CENTER>
	</BODY>
</HTML>