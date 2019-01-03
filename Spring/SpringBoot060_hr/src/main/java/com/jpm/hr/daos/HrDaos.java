package com.jpm.hr.daos;

import com.jp.hr.entities.Employee;
import com.jpm.hr.exceptions.HrException;

public interface HrDaos {
	public Employee getEmployeeDetails(int empNo) throws HrException;
}
