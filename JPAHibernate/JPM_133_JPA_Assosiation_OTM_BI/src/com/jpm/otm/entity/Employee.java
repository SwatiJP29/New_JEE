/**
 * 
 */
package com.jpm.otm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="EMP_OTM")
public class Employee implements Comparable<Employee>{
	
	@Id
	@Column(name="EMP_ID")//here the parameter empId will be mapped to the column emp_id in the table EMP_OTM in DB
	private Long empId;
	
	@Column(name="EMP_NAME")
	private String empName;
	
	@Column(name="EMP_SAL")
	private String empSal;
	
	@ManyToOne
	@JoinColumn(name="DEPT_ID") //Name of the join column which will be created in the emp_otm table. This does not matches with dept_id column in department class
	private Department department;
	
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

	public String getEmpSal() {
		return empSal;
	}

	public void setEmpSal(String empSal) {
		this.empSal = empSal;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", department Id=" + department.getDeptId()
				+ "]";
	}

	@Override
	public int compareTo(Employee o) {
		// comparing the map obj with empId
		return (int) (this.empId-o.empId);
		//1 if first object is greater
		//-1 if first object is smaller
		//0 if both are equal
	}

	/*@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj.hashCode()==this.hashCode();
	}

	@Override
	public int hashCode() {
		
		return empId.intValue();
	}*/
	
	

}
