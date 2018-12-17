<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>Exception Caught</TITLE>
	</HEAD>
	<BODY BGCOLOR=#FEF6E5>
		<%@ page isErrorPage = "true"%>
		<TABLE CLASS="TITLE" ALIGN = "CENTER" BORDER=1>EXCEPTION</TABLE>
		
		<P>
		<B><%= request.getRemoteHost()%></B> has reported the following error:
		<I><%=exception%></I>.  This problem occured in the following place:
		<PRE>
			<%@ page import="java.io.*" %>
			<% exception.printStackTrace(new PrintWriter(out)); %>
		</PRE>
	</BODY>
</HTML>