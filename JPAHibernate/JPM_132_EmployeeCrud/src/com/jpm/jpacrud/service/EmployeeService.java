package com.jpm.jpacrud.service;

import java.util.List;

import com.jpm.jpacrud.dao.EmployeeDao;
import com.jpm.jpacrud.dao.IEmployeeDao;
import com.jpm.jpacrud.entities.Employee;
import com.jpm.jpacrud.exception.EmployeeException;

public class EmployeeService implements IEmployeeService{
	//prep work is we create the object of Dao Interface
	 private IEmployeeDao employeeDao;
	public EmployeeService() {
		employeeDao = new EmployeeDao();
	}	

	

	@Override
	public Long addEmployee(Employee employee) throws EmployeeException {
		employeeDao.beginTransaction();
		employeeDao.addEmployee(employee);
		employeeDao.commitTransaction();
		return employee.getEmployeeId();
	}



	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		
		return employeeDao.getEmployeeList();
	}



	@Override
	public Employee getEmployeeById(Long empId) throws EmployeeException {
		
		return employeeDao.getEmployeeById(empId);
	}



	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		employeeDao.beginTransaction();
		employeeDao.updateEmployee(employee);
		//employeeDao.commitTransaction();
		return employee;
		
	}



	@Override
	public Long deleteEmployeeById(Long empId) throws EmployeeException {
		employeeDao.beginTransaction();
		employeeDao.deleteEmployeeById(empId);
		employeeDao.commitTransaction();
		return (empId);
	}

}
