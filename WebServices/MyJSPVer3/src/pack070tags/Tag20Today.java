package pack070tags;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Tag20Today extends TagSupport
	{	public int doStartTag() throws JspException
			{	JspWriter out = pageContext.getOut();
				Calendar cal = Calendar.getInstance();
				//cal.setTime(new Date());
				
				try	{	out.println(cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));	}
				catch(IOException ie)
					{	throw new JspException("Exception in Today20", ie);}
				return (SKIP_BODY);
			}
	
	}
