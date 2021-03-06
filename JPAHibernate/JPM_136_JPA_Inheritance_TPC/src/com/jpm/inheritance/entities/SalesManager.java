/**
 * 
 */
package com.jpm.inheritance.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="SALESMGR_TPC")
@AttributeOverrides({
	@AttributeOverride(column=@Column(name="SALESMGR_ID"), name="empId"),
	@AttributeOverride(column=@Column(name="SALESMGR_NAME"), name="empName"),
	@AttributeOverride(column=@Column(name="SALESMGR_SALARY"), name="empSal"),
	@AttributeOverride(column=@Column(name="SALESMGR_ID"), name="bonus"),
	
})

public class SalesManager extends Manager {
	private Double commission;
	
	public SalesManager() {
		// TODO Auto-generated constructor stub
	}

	public SalesManager(String empName, Double empSal, Double bonus, Double commission) {
		super(empName, empSal, bonus);
		this.commission = commission;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	@Override
	public String toString() {
		return "SalesManager [commission=" + commission + ", getEmpSal()=" + getEmpSal() + "]";
	}
	
	

}
