<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<%@ taglib uri="/tags" prefix="tagjsp" %>
<%@ page errorPage = "/JSP/JSP070CustomTags/Errors.jsp" %>

<HTML>
	<HEAD>
		<TITLE><tagjsp:COMPANYNAME/></TITLE>
	</HEAD>
	<BODY>
		<% int i=2; %>
		<H1><tagjsp:COMPANYNAME/></H1>
		Today(D) is:<tagjsp:DATEFORMAT/><BR>
		Today(1) is:<tagjsp:DATEFORMAT format='<%= i %>'/><BR>
		Today(2) is:<tagjsp:DATEFORMAT format='2'/><BR>
		Today(3) is:<tagjsp:DATEFORMAT format='3'/><BR>
	</BODY>
</HTML>