package com.jp.hr.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.jp.hr.entities.Employee;
import com.jp.hr.entities.User;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.utilities.ConnectionFactoryTomcat;

public class DaoUserImpl implements DaoUser{
	
	private DataSource dataSource;
	
	public DaoUserImpl() throws HrException {
	try {
		//ConnectionFactory factory = ConnectionFactory.getConnectionFactory();
		
		ConnectionFactoryTomcat factory = ConnectionFactoryTomcat.getConnectionFactory();
		dataSource = factory.getDataSource();
	} catch (Exception e) {
		throw new HrException("Problem in procuring connection. ", e);
	}
	
}

	@Override
	public User getUserDetails(String userID) throws HrException {
		String qry = "select user_id,password,fullname, role from UserMaster where user_id = ?";
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connect = dataSource.getConnection();
			 stmt = connect.prepareStatement(qry);
			 stmt.setString(1, userID);
			 rs = stmt.executeQuery();
			 
			
			
			if (rs.next()){
				
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				String role = rs.getString("role");
				return new User(userID, password, fullname, role);
			}else {
				return null;
			}
		} catch ( SQLException e) {
			
			throw new HrException("Problem in fetching", e);

		} finally {
			try {
				if (rs!=null){
					rs.close();
				}
				if (stmt!=null){
					stmt.close();
				}
				if (connect!=null){
					connect.close();
				}
				//factory.closeConnection();
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}
	}

}
