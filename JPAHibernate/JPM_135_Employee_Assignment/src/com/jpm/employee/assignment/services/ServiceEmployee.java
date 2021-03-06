package com.jpm.employee.assignment.services;

import java.util.ArrayList;
import java.util.List;

import com.jpm.employee.assignment.entities.Employee;
import com.jpm.employee.assignment.exceptions.HrException;

public interface ServiceEmployee {
	public List<Employee> getEmpList() throws HrException;
	public Employee getEmpDetails(int empID) throws HrException;
	
	public Long joinNewEmployee(Employee emp) throws HrException;
}
