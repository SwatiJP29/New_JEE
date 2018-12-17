package pack070tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Tag10CompanyName extends TagSupport 
	{	public int doStartTag() throws JspException
			{	try {	JspWriter out = pageContext.getOut();
						out.print("Pragati Software Pvt. Ltd.");
					}
				catch (IOException ioe)	{	
						throw new JspException("Exception in CompanyName10", ioe);
				}
				return (SKIP_BODY);
			}
	}
