package pack070tags;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.DataSource;

public class Tag60SearchEmp extends TagSupport
	{	int empNo;
		String jndi;
		
		public void setJndi(String jndi)
			{	this.jndi = jndi;	}
		
		public void setEmpNo(Integer i)
			{	empNo = i.intValue();	}

		public int doStartTag() throws JspException
			{	JspWriter out = pageContext.getOut();
				DataSource ds = null;
				try	{	Context ctx = new InitialContext();
						ds = (DataSource) ctx.lookup(jndi);
						
						Connection conn = ds.getConnection();
						PreparedStatement pst = conn.prepareStatement("Select empno, ename, sal from emp where empno=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
						pst.setInt(1, empNo);
						ResultSet rs = pst.executeQuery();
						Tag60EmpBean eb = null;
						if (rs.next())
							eb = new Tag60EmpBean(rs.getInt(1), rs.getString(2), rs.getFloat(3));
						rs.close();
						pst.close();
						conn.close();
						
						HttpSession sess = pageContext.getSession();
						sess.setAttribute("empbean", eb);
					}
				catch(NamingException ne)
					{	throw new JspException("Problem in QueryTag80", ne);	}
				catch(SQLException se)
					{	throw new JspException("Problem in QueryTag80", se);	}
			
				return this.SKIP_BODY;
			}
	}