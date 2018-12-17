<%@ page contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
  <head>
    <title>User Info Entry Form</title>
  </head>
  <body bgcolor="white">

    <form action="JSTLdemo3.jsp" method="post">
      <input type="hidden" name="submitted" value="true">
      <table>
        <c:if test="${param.submitted && empty param.userName}">
          <tr><td></td>
          <td colspan="2"><font color="red">
            Please enter your Name
          </font></td></tr>
        </c:if>
        <tr>
          <td>Name:</td>
          <td>
            <input type="text" name="userName"/>
          </td>
        </tr>
        <c:if test="${param.submitted && empty param.birthDate}">
          <tr><td></td>
          <td colspan="2"><font color="red">
            Please enter your Birth Date
          </font></td></tr>
        </c:if>
        <tr>
          <td>Birth Date:</td>
          <td>
            <input type="text" name="birthDate"/>
          </td>
          <td>(Use format yyyy-mm-dd)</td>
        </tr>
        <c:if test="${param.submitted && empty param.emailAddr}">
          <tr><td></td>
          <td colspan="2"><font color="red">
            Please enter your Email Address
          </font></td></tr>
        </c:if>
        <tr>
          <td>Email Address:</td>
          <td>
            <input type="text" name="emailAddr"/>
          </td>
          <td>(Use format name@company.com)</td>
        </tr>
        
	  <tr>
          <td colspan="3">
            <input type="submit" value="Send Data" />
          </td>
        </tr>

      </table>
    </form>
  </body>
</html>
