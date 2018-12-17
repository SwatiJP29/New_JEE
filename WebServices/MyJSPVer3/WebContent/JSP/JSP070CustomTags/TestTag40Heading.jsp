<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>Some Tag-Generated Headings</TITLE>
	</HEAD>
	<BODY>
		<%@ taglib uri="/tags" prefix="tagjsp" %>
		
		<tagjsp:HEADING bgColor="#C0C0C0">
			<tagjsp:COMPANYNAME/>
		</tagjsp:HEADING>
		
		<P>
		<tagjsp:HEADING bgColor="BLACK" color="WHITE">
			<tagjsp:COMPANYNAME/>
		</tagjsp:HEADING>
		
		<P>
		<tagjsp:HEADING bgColor="#EF8429" fontSize="60" border="5" >
			<tagjsp:COMPANYNAME/>
		</tagjsp:HEADING>
		
		<P>
		<tagjsp:HEADING bgColor="CYAN" width="100%">
			<tagjsp:COMPANYNAME/>
		</tagjsp:HEADING>
		
		<P>
		<tagjsp:HEADING bgColor="CYAN" fontSize="60" fontList="Brush Script MT, Times, serif">
			<tagjsp:COMPANYNAME/>
		</tagjsp:HEADING>
		
		<P>
	</BODY>
</HTML>