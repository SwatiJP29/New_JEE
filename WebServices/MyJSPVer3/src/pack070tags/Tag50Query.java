package pack070tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.DataSource;

public class Tag50Query extends TagSupport
	{	String qry;
		String jndi;
		
		public void setQuery(String qry)
			{	this.qry = qry;	}
		
		public void setJndi(String jndi)
			{	this.jndi = jndi;	}
		
		public int doStartTag() throws JspException
			{	JspWriter out = pageContext.getOut();
				//DataSource ds = null;
				Connection conn;
				try	{	//Context ctx = new InitialContext();
						//ds = (DataSource) ctx.lookup(jndi);
					
					Class.forName("oracle.jdbc.OracleDriver");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
						
						String [][] table = getList(qry, conn);
						out.println("<TABLE BORDER=1 ALIGN=CENTER>");
			        	out.println("<TR BGCOLOR='#FFAD00'>");
						for(int i =0; i<table[0].length; i++)
							out.println("<TH>"+table[0][i]);
					
						for(int i=0; i<table.length; i++)
							{	out.println("<TR>");
								for(int j=0; j<table[i].length; j++)
									out.println("<TD>"+table[i][j]);
							}
						out.println("</TABLE>");
						
						HttpSession sess = pageContext.getSession();
						sess.setAttribute("ListTable", table);
						conn.close();
					}
				//catch(NamingException ne)
					//{	throw new JspException("Problem in QueryTag80", ne);	}
				catch(SQLException se)
					{	throw new JspException("Problem in QueryTag80", se);	}
				catch(IOException ie)
					{	throw new JspException("Problem in QueryTag80", ie);	} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				return this.SKIP_BODY;
			}
		
		public String[][] getList(String qry, Connection conn) throws SQLException
			{	//Connection conn = ds.getConnection();
				Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = st.executeQuery(qry);
				ResultSetMetaData rsmd = rs.getMetaData();
				
				int noOfCols = rsmd.getColumnCount();
				rs.last();
				int noOfRows = rs.getRow(); 
				rs.beforeFirst();
				String [][]table = new String[noOfRows+1][noOfCols];
				
				// Column heads
				for(int j=0; j<noOfCols; j++)
					table[0][j] = rsmd.getColumnName(j+1);
				
				// Table Body
				for(int i=1; rs.next(); i++)
					for(int j=0; j<noOfCols; j++)
						table[i][j] = rs.getString(j+1);
				
				rs.close();
				st.close();
				conn.close();
				return table;
			}
	}
