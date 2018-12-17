<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<%@ page isELIgnored='false' %>
	<TABLE BORDER=1 ALIGN=CENTER>
				<TR BGCOLOR="#FFAD00">
					<TH>Information<TH>Details
						<TR><TD>Email Address<TD>${ Bean.emailAddress }
						<TR><TD>Destination  <TD>${ Bean.destination }
						<TR><TD>Total Cost   <TD>${ Bean.totalCost }
						<TR><TD>Advance Paid <TD>${ Bean.advance }
	</TABLE>
	<TABLE BORDER=1 ALIGN=CENTER>
				<TR BGCOLOR="#FFAD00">
					<TH>Information<TH>Details
						<TR><TD>Email Address<TD>${ sessionScope.Bean.emailAddress }
						<TR><TD>Destination  <TD>${ sessionScope.Bean.destination }
						<TR><TD>Total Cost   <TD>${ sessionScope.Bean.totalCost }
						<TR><TD>Advance Paid <TD>${ sessionScope.Bean.advance }
	</TABLE>
	<TABLE BORDER=1 ALIGN=CENTER>
				<TR BGCOLOR="#FFAD00">
					<TH>Week Names<TH>Details
						<TR><TD>${ WeekNames[0] }<TD>${ WeekNames[1] }
						<TR><TD>${ WeekNames[2] }<TD>${ WeekNames[3] }
						<TR><TD>${ WeekNames[4] }<TD>${ WeekNames[5] }
						<TR><TD>${ WeekNames[6] }<TD>${ WeekNames[7] }
	</TABLE>
	<TABLE BORDER=1 ALIGN=CENTER>
				<TR BGCOLOR="#FFAD00">
					<TH>Week Names<TH>Details
						<c:forEach items="${sessionScope.WeekNames}" var="current">
        					<TR><TD><c:out value="${current}" />&nbsp;
      					</c:forEach>
	</TABLE>
	<TABLE BORDER=1 ALIGN=CENTER>
				<TR BGCOLOR="#FFAD00">
					<TH>Month Names<TH>Details
						<TR><TD>${ MonthNames[0] }<TD>${ MonthNames[1] }
						<TR><TD>${ MonthNames[2] }<TD>${ MonthNames[3] }
	</TABLE>
	<TABLE BORDER=1 ALIGN=CENTER>
				<TR BGCOLOR="#FFAD00">
					<TH>Map Names<TH>Details
						<TR><TD>${ Friends["Deshpande"] }<TD>${ Friends["Mishra"] }
						<TR><TD>${ Friends["Dawane"] }<TD>${ Friends["Govindraj"] }
	</TABLE>
</body>
</html>