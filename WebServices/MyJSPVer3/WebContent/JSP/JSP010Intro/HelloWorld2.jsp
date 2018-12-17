<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<%-- This is JSP's comment. It is not translated in servlet --%>

<!-- This is HTML Comment.  It is passed to browser as a part of html-->
<HTML>
	<HEAD>
		<TITLE>Ours International Bank</TITLE>
	</HEAD>
	<BODY>
		<%@ page import = "java.util.Date, java.util.Calendar" %>
		<CENTER>
			<H3>The only name in the world of Banking!!!</H3>
		
			<%  String bankName = "Ours International Bank";
				int count = 5;
				
				String [] monthName = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				//String today = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
				String today = cal.get(Calendar.DAY_OF_MONTH)+"-"+monthName[cal.get(Calendar.MONTH)]+"-"+cal.get(Calendar.YEAR)+":"+cal.get(Calendar.HOUR);
				
					for(int i=1; i<=count; i++)	{	%>
			
						<H<%=i%>><%= bankName%></H<%=i%>>
						
						<% } %>
					
						<% 	for(int j=1; j<= count; j++)	{ %>
								<H1> * </H1>
							<% } // End for inner for %>
							
			<H1> <%= today %>
		</CENTER>
	</BODY>
</HTML>