package com.jp.fbcs.daos;

import com.jp.fbcs.entities.Complaint;
import com.jp.fbcs.exception.ComplaintException;

public interface IComplaintDao {
	
	public Integer raiseNewComplaint(Complaint complaint) throws ComplaintException;
	public Complaint checkStatus(Integer compliantId) throws ComplaintException;
	
	
}
