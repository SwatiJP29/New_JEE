<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<%@ taglib uri="/tags" prefix="tagjsp" %>
<%@ page errorPage = "/JSP/JSP070CustomTags/Errors.jsp" %>

<HTML>
	<HEAD>
		<TITLE><tagjsp:COMPANYNAME/></TITLE>
	</HEAD>
	<BODY>
		<H1><tagjsp:COMPANYNAME/></H1>
		Today is:<tagjsp:TODAYDATE/>
	</BODY>
</HTML>