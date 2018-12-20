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
			<th>Employee Name</th>
			<th>Employee Salary</th>
			<th>Department Number</th>
			<th>Department Name</th>
			<th>Project ID</th>
		</tr>
		<tr>
			<td>${requestScope.empDetails.empNo }</td>
			<td>${requestScope.empDetails.empNm }</td>
			<td>${requestScope.empDetails.empSal }</td>
			<td>${requestScope.empDetails.dept.deptNo }</td>
			<td>${requestScope.empDetails.dept.deptNm }</td> <!-- Here on empdetials we get the reference of dept then the property of dept object -->
			<td>${requestScope.empDetails.projects }</td>
		</tr>
	</table>
	
	<a href="getEmpList.hr">Go Gack to list</a>
</body>
</html>