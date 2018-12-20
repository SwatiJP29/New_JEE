package com.hibernate.pack90_association.pack30_manyMany.beans;

import java.util.Set;


public class Emp {
	private Integer empNo;
	private String eName;
	private String job;
	
	// Many to Many towards Project
	private Set<Project> projects;
	
	public Emp() {
		super();
	}
	
	public Emp(Integer empNo) {
		super();
		this.empNo = empNo;
	}

	// Association scaffolding code
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Emp [eName=" + eName + ", empNo=" + empNo + ", \n\tprojects="
				+ projects + "]";
	}
}
