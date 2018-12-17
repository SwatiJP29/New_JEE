package packcommon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import packcommon.packexceptions.DuplicateUserException;

public class UserMasterDAO {
	Connection conn;
	
	public UserMasterDAO() throws SQLException{
		String drv = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:chandra";
		String user = "scott";
		String password = "tiger";
		
		try {
			Class.forName(drv);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		conn = DriverManager.getConnection(url, user, password);
	}
	
	public UserMasterDAO(String drv, String url, String user, String password) throws SQLException{
		try {
			Class.forName(drv);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver:"+drv+" Url:"+url+" User:"+user+" Password:"+password);
		conn = DriverManager.getConnection(url, user, password);
	}
	
	public void closeConnection()throws SQLException {
		if (conn!= null)
			conn.close();
	}
	
	protected void finalize() throws SQLException{
		closeConnection();
	}
	
	public void addNewUser(String userFName, String userName, String userPassword)
		throws SQLException, DuplicateUserException {
		if (isUserExist(userName)){
			throw new DuplicateUserException("Fail in creating new user.");
		}
		
		String qry = "INSERT INTO USERMASTER (USERFNAME, USERNAME, PASSWORD) VALUES(?,?,?)";
		PreparedStatement pst = conn.prepareStatement(qry);
		pst.setString(1, userFName);
		pst.setString(2, userName);
		pst.setString(3, userPassword);
		
		pst.executeQuery();
		pst.close();
	}
	
	public boolean isUserExist(String userName) throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT USERNAME FROM USERMASTER WHERE USERNAME = ?");
		st.setString(1, userName);
		ResultSet rs = st.executeQuery();
		
		boolean result = (rs.next())? true : false;
		
		rs.close();
		st.close();
		
		return result;
	}
	
	public String isUserAuthenticated(String userName, String password)
		throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT USERFNAME, PASSWORD FROM USERMASTER WHERE USERNAME = ?");
		st.setString(1, userName);
		ResultSet rs = st.executeQuery();
		boolean result = false;
		
		if (rs.next()){
			String pw = rs.getString("PASSWORD");
			if ((pw==null))
				result = (password.equals(""))?true:false;
			else
				result = (pw.equals(password))?true:false;
		}
		else
			result = false;
		
		String ufName = result?rs.getString("USERFNAME"):null;
		rs.close();
		st.close();
		
		return ufName;
	}
	
	public String[][] queryTable(String query) throws SQLException {
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);	
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		int noOfColumns = rsmd.getColumnCount();
		rs.last();
		int noOfRows = rs.getRow()+1;
		String [][] table = new String[noOfRows][noOfColumns];
		
		rs.beforeFirst();
		
		// Creating Table
		for(int i =0; i<noOfColumns; i++)
			table[0][i] = rsmd.getColumnName(i+1);
		
		for(int i=1; rs.next(); i++)
			for(int j=0; j<noOfColumns; j++)
				table[i][j]=rs.getString(j+1);
		return table;
	}
	
	public static void main(String[] args) {
		
		try {
			UserMasterDAO umdao = new UserMasterDAO();
			//umdao.addNewUser("A", "a", "a");
			//umdao.addNewUser("B", "b", "");
			String ufName=null;
			if ((ufName=umdao.isUserAuthenticated("a", "a"))!=null)
				System.out.println("User Authenticated correctly.");
			else
				System.out.println("User unauthenticated incorrectly.");
			
			if ((ufName=umdao.isUserAuthenticated("b", ""))!=null)
				System.out.println("User Authenticated correctly.");
			else
				System.out.println("User unauthenticated incorrectly.");
			
			if ((ufName=umdao.isUserAuthenticated("a", "b"))!=null)
				System.out.println("User Authenticated incorrectly.");
			else
				System.out.println("User unauthenticated correctly.");
			
			if ((ufName=umdao.isUserAuthenticated("c", "a"))!=null)
				System.out.println("User Authenticated incorrectly.");
			else
				System.out.println("User unauthenticated correctly.");
			
			umdao.closeConnection();
		} //catch (DuplicateUserException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
