package com.hibernate.pack90_association.pack30_manyMany.beans;

import java.util.Set;

public class Project {
	private Integer projectId;
	private String projectTitle;

	// Many to Many towards Emp
	private Set<Emp> employees;

	public Project() {
		super();
	}

	public Project(Integer projectId) {
		super();
		this.projectId = projectId;
	}

	// Association scaffolding code
	public Set<Emp> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Emp> employees) {
		this.employees = employees;
	}
	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectTitle="
				+ projectTitle + "]";
	}
	
	
}
