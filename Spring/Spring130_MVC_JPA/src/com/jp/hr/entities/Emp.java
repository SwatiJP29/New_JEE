package com.jp.hr.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="empRecNew")
@Table(name="EMP")
public class Emp {
	private Integer empNo;
	private String empNm;
	private Float empSal;
	//private Integer deptNo;
	
	//Assosication
	private Dept dept;
	private List<Project> projects;
	
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
	
	@OneToOne  //For one employee we have one department only so one to one
	@JoinColumn(name="DEPTNO")   //Since Emp table is the owner table (has the foreign key of Dept table) hence we are giving joincolum in the emp table. And DEPTNO is from EMP table not DEPT table.
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	@ManyToMany(fetch=FetchType.EAGER) //We give fetch when we need projects along with employees
	@JoinTable(
			name = "EMP_PROJECT",
			joinColumns = @JoinColumn(name = "EMPNO"),
			inverseJoinColumns = @JoinColumn(name="PROJECTID")		
	)
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empNm=" + empNm + ", empSal=" + empSal + ", projects=" + projects + "]";
	}
}

