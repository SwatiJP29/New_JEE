package com.jp.fbcs.services;

import com.jp.fbcs.entities.Complaint;
import com.jp.fbcs.exception.ComplaintException;

public interface IComplaintService {
	
	public Integer raiseNewComplaint(Complaint complaint) throws ComplaintException;
	public Complaint checkStatus(Integer compliantId) throws ComplaintException;
	
}
