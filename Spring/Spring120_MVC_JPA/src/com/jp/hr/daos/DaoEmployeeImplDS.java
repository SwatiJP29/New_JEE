package com.jp.hr.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

//@Repository("daoDS")
public class DaoEmployeeImplDS implements DaoEmployee {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public ArrayList<Employee> getEmplist() throws HrException {
		ArrayList<Employee> empList = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			 connect = dataSource.getConnection();
			 stmt = connect.createStatement();
			 rs = stmt.executeQuery("select employee_id,first_name,last_name from employee1");
			
			
			while (rs.next()){
				int empID = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				empList.add(new Employee(empID, firstName, lastName));
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
				
				connect.close();
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}
		
		return empList;
	}

	@Override
	public Employee getEmpDetails(int empID) throws HrException {
		String qry = "select employee_id,first_name,last_name from Employee1 where employee_id = ?";
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			 connect = dataSource.getConnection();
			 stmt = connect.prepareStatement(qry);
			 stmt.setInt(1, empID);
			 rs = stmt.executeQuery();
			 
			
			
			if (rs.next()){
				
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				return new Employee(empID, firstName, lastName);
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
				connect.close();
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}
	}

	@Override
	public boolean insertNewRecord(Employee emp) throws HrException {
		String qry = "INSERT INTO Employee1 (employee_id, first_name, last_name) values (?,?,?)";
		Connection connect = null;
		PreparedStatement stmt = null;
		
		
		try {
			 connect = dataSource.getConnection();
			 stmt = connect.prepareStatement(qry);
			 stmt.setInt(1, emp.getEmpID());
			 stmt.setString(2,  emp.getFirstName());
			 stmt.setString(3, emp.getLastName());
			 
			 int recInserted = stmt.executeUpdate();
			 return recInserted==1? true: false;
			
			
			
		} catch ( SQLException e) {
			
			throw new HrException("Problem in fetching", e);

		} finally {
			try {
				
				if (stmt!=null){
					stmt.close();
				}
				connect.close();
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}

	}
}
