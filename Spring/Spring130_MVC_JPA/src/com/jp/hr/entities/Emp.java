package com.jp.hr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="empRecNew")
@Table(name="EMP")
public class Emp {
	private Integer empNo;
	private String empNm;
	private Float empSal;
	private Integer deptNo;
	
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="EMPNO")
	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	
	@Column(name="ENAME")
	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	@Column(name="SAL")
	public Float getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Float empSal) {
		this.empSal = empSal;
	}
	
	@Column(name="DEPTNO")
	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empNm=" + empNm + ", empSal=" + empSal + ", deptNo=" + deptNo + "]";
	}
	
	
}
