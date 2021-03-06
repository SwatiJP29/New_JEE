package com.jp.fbcs.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Entity(name="complaint")
@Table(name="COMPLAINT")
public class Complaint {
	
	private Integer complaintId;
	
	
	
	//@Length(max = 10, message="Account number should be 10 digits")
	private Integer accontId;
	
	
	private String branchCode;
	
	//@Email
	private String emailId;
	
	
	private String category;
	
	
	private String description;
	
	
	private String priority;
	
	
	private String status;
	
	
	
	public Complaint(Integer complaintId, Integer accontId, String branchCode, String emailId, String category,
			String description, String priority, String status) {
		super();
		this.complaintId = complaintId;
		this.accontId = accontId;
		this.branchCode = branchCode;
		this.emailId = emailId;
		this.category = category;
		this.description = description;
		this.priority = priority;
		this.status = status;
	}
	public Complaint() {
		
	}
	@Id
	@Column(name="COMPLAINTID")
	@SequenceGenerator(name="COMPL_GEN", sequenceName="hibernate_sequence1", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPL_GEN")
	public Integer getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}
	
	@Column(name="ACCOUNTID")
	public Integer getAccontId() {
		return accontId;
	}
	public void setAccontId(Integer accontId) {
		this.accontId = accontId;
	}
	
	@Column(name="BRANCHCODE")
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	
	@Column(name="EMAILID")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name="CATEGORY")
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="PRIORITY")
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", accontId=" + accontId + ", branchCode=" + branchCode
				+ ", emailId=" + emailId + ", category=" + category + ", description=" + description + ", priority="
				+ priority + ", status=" + status + "]";
	}
	
	
	
	

}
