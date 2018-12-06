package com.jpm.employee.assignment.services;

import java.util.ArrayList;

import com.jpm.employee.assignment.entities.Employee;
import com.jpm.employee.assignment.exceptions.HrException;

public interface ServiceEmployee {
	public ArrayList<Employee> getEmpList() throws HrException;
	public Employee getEmpDetails(int empID) throws HrException;
	
	public boolean joinNewEmployee(Employee emp) throws HrException;
}