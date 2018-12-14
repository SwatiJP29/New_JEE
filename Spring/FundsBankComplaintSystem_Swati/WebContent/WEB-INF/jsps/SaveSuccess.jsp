<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Employee Saved Successfully</title>
</head>
<body>
<h3>
    Complaint ID for this request is ${requestScope.complaint.complaintId }
    Thanks for raising a complaint. </br>
    <a href="checkStatusPage.hr">Check Status</a>
    <a href="newComplaintForm.hr">Raise Complaint</a>
</h3> 
</body>
</html>
