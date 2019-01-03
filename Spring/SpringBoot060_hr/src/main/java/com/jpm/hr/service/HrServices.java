package com.jpm.hr.service;

import java.io.Serializable;

import com.jp.hr.entities.Employee;
import com.jpm.hr.exceptions.HrException;

public interface HrServices extends Serializable{
	public Employee getEmpDetails(int empNo) throws HrException;
}
