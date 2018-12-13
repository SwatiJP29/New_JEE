package com.jp.hr.daos;

import java.util.List;

import com.jp.hr.entities.Dept;
import com.jp.hr.entities.Emp;
import com.jp.hr.exceptions.HrException;

public interface DaoEmployee {
	
	public List<Emp> getEmplist() throws HrException;
	
	public List<Dept> getDeptlist() throws HrException;
	
	/*public Employee getEmpDetails(int empID) throws HrException;
	
	public boolean insertNewRecord(Employee emp) throws HrException;*/

}