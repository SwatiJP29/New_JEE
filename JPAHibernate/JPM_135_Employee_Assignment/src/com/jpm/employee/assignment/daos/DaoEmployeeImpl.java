package com.jpm.employee.assignment.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jpm.employee.assignment.entities.Employee;
import com.jpm.employee.assignment.exceptions.HrException;
import com.jpmemployee.assignment.util.JPAUtil;

/* The ClassNotFoundException and SQLException should not come out of Dao Class
 * The database specific entities must not come out of the class (Like Exception and REsultSet)
 * Each and every resource (connection, statement, resultset) should be closed properly before coming out.
 * Always prefer Statement over PreparedStatement for non-interactive queries.
 * Fetch the data pagewise.
 * Prefer mentioning column names instead of column position in getXXX methods
 * 
 */

public class DaoEmployeeImpl implements DaoEmployee{
	
	private EntityManager entityManager;
	
	
	public DaoEmployeeImpl() {
		entityManager = JPAUtil.geEntityManager();
	}

	@Override
	public List<Employee> getEmplist() throws HrException  {
		
		Query query = entityManager.createQuery("from Employee");
		return query.getResultList();
	}

	@Override
	public Employee getEmpDetails(int empID) throws HrException {
		
		return entityManager.find(Employee.class, empID);	
		
	}

	@Override
	public boolean insertNewRecord(Employee emp) throws HrException {
		String qry = "INSERT INTO Employee1 (employee_id, first_name, last_name) values (?,?,?)";
		Connection connect = null;
		PreparedStatement stmt = null;
		
		
		try {
			 connect = getConnection();
			 stmt = connect.prepareStatement(qry);
			 stmt.setInt(1, emp.getEmpID());
			 stmt.setString(2,  emp.getFirstName());
			 stmt.setString(3, emp.getLastName());
			 
			 int recInserted = stmt.executeUpdate();
			 return recInserted==1? true: false;
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new HrException("Problem in fetching", e);

		} finally {
			try {
				
				if (stmt!=null){
					stmt.close();
				}
				closeConnection(connect);
			} catch (SQLException e) {
				throw new HrException("Problem in closing resources.", e);
			}
		}
		
	}
	
	


}
