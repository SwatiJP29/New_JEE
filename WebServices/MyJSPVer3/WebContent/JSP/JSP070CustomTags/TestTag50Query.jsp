<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib uri="/tags" prefix="tagjsp" %>

<HTML>
	<HEAD>
		<TITLE>Test Query Table</TITLE>
	</HEAD>
	
	<BODY>
		<H1>Test Query Table</H1>
		<tagjsp:QUERY query='Select ename, empno from Emp' jndi='ThinJNDI'/>
		
		<H1>Test Query Table with expression</H1>
		<% String qry = "Select * from Emp";	%>
		<tagjsp:QUERY query='<%= qry %>' jndi='ThinJNDI'/>
	</BODY>
</HTML>