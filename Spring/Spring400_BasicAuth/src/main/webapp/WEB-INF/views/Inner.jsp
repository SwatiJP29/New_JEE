<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
	<head>
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
	</head>
	<body>
		<h2>${message}</h2> <!-- This message is coming from the controller class mandV -->
		<c:if test="${pageContext.request.userPrincipal.name != null}">
		   <h2>Welcome : ${pageContext.request.userPrincipal.name} </h2>
	       <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>  
		</c:if>
	</body>
</html>