<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib uri="/tags" prefix="tagjsp" %>

<HTML>
	<HEAD>
		<TITLE>Employee Search</TITLE>
	</HEAD>
	
	<BODY BGCOLOR=#FEF6E5>
		<TABLE CLASS="TITLE" ALIGN = "CENTER" BORDER=2><TR><TH>Employee Search</TABLE>
		<% 	String param = request.getParameter("empno");
			if (param==null){ %>
				<FORM ACTION="/MyJSPVer3/JSP/JSP070CustomTags/TestTag90SearchEmp.jsp" METHOD = "GET">
					<CENTER>
						<TABLE BORDER=3 ALIGN = "CENTER">
							<TR><TD>Employee Number			<TD><INPUT TYPE="TEXT" NAME="empno">
						</TABLE>
						
						<BR>
						<INPUT TYPE = "SUBMIT" NAME="submit" VALUE = "OK">
					</CENTER>
				</FORM>
			<% 	} else
				{	Integer empNo = new Integer(param);
				 %>
				<tagjsp:SEARCHEMP empNo='<%=empNo%>' jndi='ThinJNDI'/>
				<jsp:useBean id = 'empbean' class='pack070tags.Tag60EmpBean' scope='session'/>
				<TABLE BGCOLOR=#FEF6E5 BORDER='3' ALIGN = "CENTER">
					<TR><TD>Number<TD><jsp:getProperty name = "empbean" property = "empNo"/> </TR>
					<TR><TD>Name  <TD><jsp:getProperty name = "empbean" property = "eName"/> </TR>
					<TR><TD>Salary<TD><jsp:getProperty name = "empbean" property = "empSal"/></TR>
				</TABLE>
				<% } %>
	</BODY>
</HTML>