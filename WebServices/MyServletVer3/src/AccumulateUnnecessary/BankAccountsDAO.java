package packcommon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import packcommon.packexceptions.DuplicateUserException;

public class BankAccountsDAO {
	Connection conn;
	
	public BankAccountsDAO() throws SQLException{
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
	
	public BankAccountsDAO(String drv, String url, String user, String password) throws SQLException{
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
	public boolean isAccExist(String userName) throws SQLException {
		PreparedStatement st = conn.prepareStatement("SELECT USERNAME FROM USERMASTER WHERE USERNAME = ?");
		st.setString(1, userName);
		ResultSet rs = st.executeQuery();
		
		boolean result = (rs.next())? true : false;
		
		rs.close();
		st.close();
		
		return result;
	}
}
