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
import javax.persistence.TypedQuery;

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
		
		TypedQuery<Employee> query = (TypedQuery<Employee>) entityManager.createQuery("from Employee");
		return query.getResultList();
	}

	@Override
	public Employee getEmpDetails(int empID) throws HrException {
		
		return entityManager.find(Employee.class, empID);	
		
	}

	@Override
	public int insertNewRecord(Employee emp) throws HrException {
		entityManager.persist(emp);
		return emp.getEmpID();
		
	}
	
	


}
