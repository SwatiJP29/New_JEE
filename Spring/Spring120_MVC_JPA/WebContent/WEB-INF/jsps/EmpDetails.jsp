<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Head01.jsp"></jsp:include>
		<jsp:include page="Head02.jsp"></jsp:include>
	<table border="1">
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<tr>
			<td>${requestScope.empDetails.empID }</td>
			<td>${requestScope.empDetails.firstName }</td>
			<td>${requestScope.empDetails.lastName }</td>
		</tr>
	</table>
	
	<a href="getEmpList.hr">Go Gack to list</a>
</body>
</html>