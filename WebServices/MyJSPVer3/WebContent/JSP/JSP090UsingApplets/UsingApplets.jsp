<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title>Using jsp:plugin</title>
	<link rel=STYLESHEET href="JSP-Styles.css" type="text/css">
	</head>
	<body>
		<center>
		<table border="5">
			<tr><th class="TITLE">Using jsp:plugin</table>
			<p>
			<!--  
			<jsp:plugin code="pack90applets.PluginApplet.class" codebase="/MyJSPVer2" type="applet" width="370" height="420">
			</jsp:plugin>
			-->
			<jsp:plugin code="pack090applets.appletWithBanner7.class" codebase="/MyJSPVer3" type="applet" width="500" height="50">
			</jsp:plugin>
		</center>
	</body>
</html>