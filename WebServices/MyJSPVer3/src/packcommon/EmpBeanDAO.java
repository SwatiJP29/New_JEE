package packcommon;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class EmpBeanDAO
	{	Connection conn;
		PreparedStatement pst;
		Statement st;
		ResultSet rs;
		int empNo;
		public EmpBeanDAO() throws ClassNotFoundException, SQLException
			{	Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:chandra", "scott", "tiger");
				st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pst = conn.prepareStatement("SELECT ENAME FROM EMP WHERE EMPNO = ?");
			}

		public EmpBeanDAO(String driver, String url, String user, String passWd) throws ClassNotFoundException, SQLException
			{	Class.forName(driver);
				conn = DriverManager.getConnection(url, user, passWd);
				st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				pst = conn.prepareStatement("SELECT ENAME FROM EMP WHERE EMPNO = ?");
			}
		public String [] getList() throws SQLException
			{	rs = st.executeQuery("Select ENAME FROM EMP");
				rs.last();
				int n = rs.getRow();
				String [] list = new String[n];
				rs.beforeFirst();
				for(int i=0; rs.next(); i++)
					{	list[i] = rs.getString("ENAME");}
				return list;
			}
		
		public String [][] getListTable() throws SQLException
			{	rs = st.executeQuery("Select EMPNO, ENAME FROM EMP");
				rs.last();
				int n = rs.getRow();
				String [][] list = new String[n][2];
				rs.beforeFirst();
				for(int i=0; rs.next(); i++)
					{	list[i][0] = String.valueOf(rs.getInt("EMPNO"));
						list[i][1] = rs.getString("ENAME");
					}
				return list;
			}
		
		public void close() throws SQLException
			{	rs.close();
				pst.close();
				st.close();
				conn.close();
			}
		
		public void setEmpNo(int empNo)
			{	this.empNo = empNo;	}
		
		public String getEmpNo()
			{	try {
						pst.setInt(1, empNo);
						rs = pst.executeQuery();
						rs.next();
						String str = rs.getString("ENAME");
						return str;
					}
				catch(SQLException e)
				{	return null;	}
			}
		public void finalize() throws Throwable
			{	if (conn!=null)
					conn.close();
				super.finalize();
			}
		
		public static void main(String [] argv)
			{	try {	EmpBeanDAO eb = new EmpBeanDAO();
						String [] lst = eb.getList();
						for(int i=0; i<lst.length; i++)
							{	System.out.println(lst[i]);	}
						
						System.out.println("Name for employee 1000");
						eb.setEmpNo(1000);
						System.out.println(eb.getEmpNo());
						eb.close();
					}
				catch(SQLException e)
					{	e.printStackTrace();	}
				catch(ClassNotFoundException cnf)
					{	cnf.printStackTrace();	}
			}
	}	
