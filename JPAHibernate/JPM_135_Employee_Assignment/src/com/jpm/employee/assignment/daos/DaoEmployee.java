package com.jpm.employee.assignment.daos;


import java.util.List;

import com.jpm.employee.assignment.entities.Employee;
import com.jpm.employee.assignment.exceptions.HrException;

public interface DaoEmployee {
	
	public List<Employee> getEmplist() throws HrException;
	
	public Employee getEmpDetails(int empID) throws HrException;
	
	public int insertNewRecord(Employee emp) throws HrException;
	
	public void commitTransaction();
	public void beginTransaction();

}
