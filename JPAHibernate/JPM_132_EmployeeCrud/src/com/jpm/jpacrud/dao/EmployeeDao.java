/**
 * 
 */
package com.jpm.jpacrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jpm.jpacrud.entities.Employee;
import com.jpm.jpacrud.exception.EmployeeException;
import com.jpm.jpacrud.util.JPAUtil;

/**
 * @author Administrator
 *
 */
public class EmployeeDao implements IEmployeeDao {
	//prep work in Dao - EntityManager Object
	private EntityManager entityManager;
	Employee emp;
	
	public EmployeeDao() {
		entityManager = JPAUtil.geEntityManager();
	}
	
	/* (non-Javadoc)
	 * @see com.jpm.jpacrud.dao.IEmployeeDao#addEmployee(com.jpm.jpacrud.entities.Employee)
	 */
	@Override
	public Long addEmployee(Employee employee) throws EmployeeException {
		//entityManager.getTransaction().begin();
		entityManager.persist(employee);
		//entityManager.getTransaction().commit();
		
		return employee.getEmployeeId();
	}

	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		Query query = entityManager.createQuery("from Employee");
		return query.getResultList();
	}

	@Override
	public Employee getEmployeeById(Long empId) throws EmployeeException {
		//entityManager.getTransaction().begin();
		Employee e1 = entityManager.find(Employee.class, empId);
		
		entityManager.close();
		return e1;
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		//entityManager.getTransaction().begin();
		
		return entityManager.merge(employee);
	}

	@Override
	public Long deleteEmployeeById(Long empId) throws EmployeeException {
		//entityManager.getTransaction().begin();
		Employee e1 = entityManager.find(Employee.class, empId);
		entityManager.remove(e1);
		return empId;
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}

}
