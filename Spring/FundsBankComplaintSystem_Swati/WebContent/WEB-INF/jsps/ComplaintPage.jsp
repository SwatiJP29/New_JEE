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
        action="submitComplaintData.hr">
        <table>
            <tr>
                <td>Account ID:</td>
                <td><springForm:input name ="accontId" path="accontId" /></td>
            </tr>
            <tr>
                <td>Branch Code:</td>
                <td><springForm:input path="branchCode" /></td>
            </tr>
            <tr>
            	<td>Email ID:</td>
                <td><springForm:input path="emailId" /></td>
            </tr>
            
            <tr>
                <td>
                <springForm:select path="category">
                	<springForm:option value = "NONE" label = "Select"/>
                     <springForm:options items = "${complaintCategory}" />
                </springForm:select> 
                </td>
            </tr>
            <tr>
            	<td>Description:</td>
                <td><springForm:input path="description" /></td>
            </tr>
            <tr>
                <td><a href="checkStatusPage.hr">Check Status</a></td>
            </tr>
            
            <tr>
                <td colspan="3"><input type="submit" value="SUBMIT"></td>
            </tr>
            
        </table>
 
    </springForm:form>
 
</body>
</html>
