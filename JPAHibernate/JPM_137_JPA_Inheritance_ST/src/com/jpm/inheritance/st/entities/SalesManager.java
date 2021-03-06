/**
 * 
 */
package com.jpm.inheritance.st.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Administrator
 *
 */

@Entity
@DiscriminatorValue(value="SMGR")

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
