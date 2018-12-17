<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page isELIgnored='false' %>
	Accessing Context Information<BR>
	${pageContext.servletContext.serverInfo }<BR>
	${pageContext.servletContext.majorVersion }<BR>
	${pageContext.servletContext.minorVersion }<BR>
	${pageContext.servletContext.servletContextName }<BR><BR>
	
	Accessing session information<BR>
	${pageContext.session.id }<BR>
	${pageContext.session.lastAccessedTime }<BR>
	${pageContext.session.creationTime }<BR><BR>
	
	Accessing config information<BR>
	${pageContext.servletConfig.servletName }<BR><BR>
	
	
	Accessing request information<BR>
	${ pageContext.request.method }<BR>
	${ pageContext.request.contextPath }<BR>
</body>
</html>