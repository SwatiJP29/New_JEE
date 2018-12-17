package pack070tags;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Tag30DateFormat extends TagSupport
{	int format = 1;
	public int doStartTag() throws JspException
		{	
			JspWriter out = pageContext.getOut();
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			
			String [] monNm = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
			String [] weekNm = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
			String formatString="";
			
			switch(format)
				{	case 2 : formatString = cal.get(Calendar.DAY_OF_MONTH)+"th of "+monNm[cal.get(Calendar.MONTH)]+" "+cal.get(Calendar.YEAR); break;
					case 3 : formatString = cal.get(Calendar.DAY_OF_MONTH)+"th ("+weekNm[cal.get(Calendar.DAY_OF_WEEK)]+") "+(cal.get(Calendar.MONTH)+1)+" "+cal.get(Calendar.YEAR); break;
					default:formatString = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
				}
		
			try	{	out.println(formatString);	}
			catch(IOException ie)
				{	throw new JspException("Exception in todayformat30", ie);}
			return (SKIP_BODY);
		}
	public void setFormat(Integer i)
		{	format = i.intValue();
			System.out.println("In setFormat:"+format);
		}
}
