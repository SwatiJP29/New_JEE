package pack150session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

class OrderBean
	{	DataSource ds;
		Connection con;
		
		public OrderBean() throws SQLException{
			String drv = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:chandra";
			String user = "scott";
			String password = "tiger";
			
			try {
				Class.forName(drv);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);
			ds = null;
		}
		
		public OrderBean(Connection con)
			{	this.con = con;
				this.ds =  null;
			}
		
		public OrderBean(String jndi) throws NamingException
			{	Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup(jndi);	// "ThinJNDI"
				con = null;
			}
		
		public void addNew(String custName, String[]  itemName) throws SQLException
			{	Connection conn = null;
				if (ds==null)
					conn = con;
				else
					conn = ds.getConnection();
				
				Statement st = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery("Select custName, ItemName from OrderTable");
				for(int i=0; i<itemName.length; i++)
					{	rs.moveToInsertRow();
						rs.updateString("custName", custName);
						rs.updateString("itemName", itemName[i]);
						rs.insertRow();
					}
				rs.close();
				st.close();
				if (ds!=null)
					conn.close(); // Return connection to DataSource
				
			}
		
		public void closeConnection() throws SQLException {
			if (ds==null) {
				if (con!=null) {
					con.close();
					con= null;
				}
			}
		}
		
		public String[][] getList(String qry) throws SQLException
			{	Connection conn = ds.getConnection();
				Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = st.executeQuery(qry);
				ResultSetMetaData rsmd = rs.getMetaData();
				
				int noOfCols = rsmd.getColumnCount();
				rs.last();
				int noOfRows = rs.getRow(); 
				rs.beforeFirst();
				String [][]table = new String[noOfRows][noOfCols];
				
				// Column heads
				for(int j=0; j<noOfCols; j++)
					table[0][j] = rsmd.getColumnName(j+1);
				
				// Table Body
				for(int i=0; rs.next(); i++)
					for(int j=0; j<noOfCols; j++)
						table[i][j] = rs.getString(j+1);
				
				rs.close();
				st.close();
				conn.close();
				return table;
			}
	}
