package com.jp.hr.daos;

import java.util.List;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

public interface DaoEmployee {
	
	public List<Employee> getEmplist() throws HrException;
	
	public Employee getEmpDetails(int empID) throws HrException;
	
	public boolean insertNewRecord(Employee emp) throws HrException;

}