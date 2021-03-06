<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Save Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	${msg }
	<springForm:form method="POST" commandName="complaint"
		action="checkStatus.hr">
		<table>
			<tr>
				<td>Customer ID:</td>
				<td><springForm:input path="complaintId" /></td>
			</tr>
			<tr>
				<td><a href="checkStatus.hr?id=${complaint.complaintId}">Check Status</a></td>
			</tr>

			<tr>
				<td colspan="3"><a href="checkStatus.hr?id=${requestScope.complaint.complaintId}"><input type="submit" value="SUBMIT"></a></td>
			</tr>

		</table>
		
		<table border="1">
		<tr>
			<th>Complaint ID</th>
			<th>Description</th>
			<th>Status</th>
		</tr>
		<tr>
			<td>${requestScope.comlDetails.complaintId }</td>
			<td>${requestScope.comlDetails.description }</td>
			<td>${requestScope.comlDetails.status }</td>
		</tr>
	</table>

	</springForm:form>

</body>
</html>
