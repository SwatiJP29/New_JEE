/**
 * 
 */
package com.jpm.oto.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="EMP_OTO_BI")
public class Employee {
	
	@Id
	@Column(name="EMP_ID")//here the parameter empId will be mapped to the column emp_id in the table EMP_OTM in DB
	private Long empId;
	
	@Column(name="EMP_NAME")
	private String empName;
	
	@Column(name="EMP_SAL")
	private Double empSal;
	
	@OneToOne(mappedBy="employee", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
	
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double d) {
		this.empSal = d;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", address=" + address
				+ "]";
	}

	
	
	

}
