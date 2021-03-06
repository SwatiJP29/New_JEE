/**
 * 
 */
package com.jpm.inheritance.joinedtable.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */

@Entity
@Table(name="SMGR_JOIN_TABLE")

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
