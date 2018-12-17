package pack070tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Tag15CompanyAddress extends TagSupport {

	
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("Marol Maroshi Road.");
		} catch (IOException e) {
			throw new JspException("Problem in Tag15CompanyAddress.", e);
		}
		
		return this.SKIP_BODY;
	}
	
}
