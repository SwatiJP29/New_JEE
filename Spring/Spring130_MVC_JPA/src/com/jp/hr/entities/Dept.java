package com.jp.hr.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="dept")
@Table(name="DEPT")
public class Dept {
	
	private int deptNo;
	private String deptNm;
	
	
	//Association - This is the emplist for the employees working in a specific department
	Set<Emp> empList;
	
	
	
	
	@OneToMany(mappedBy="dept", fetch=FetchType.EAGER) //This is the relation from dept to emp. One dept has many employees
	public Set<Emp> getEmpList() {
		return empList;
	}
	
	@Id
	@Column(name="DEPTNO")
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
	@Column(name="DNAME")
	public String getdeptNm() {
		return deptNm;
	}
	public void setdeptNm(String dName) {
		this.deptNm = dName;
	}
	
	
	
	public void setEmpList(Set<Emp> empList) {
		this.empList = empList;
	}

	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", dName=" + deptNm + "]";
	}
}
