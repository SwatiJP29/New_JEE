package com.jp.fbcs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.fbcs.daos.IComplaintDao;
import com.jp.fbcs.entities.Complaint;
import com.jp.fbcs.exception.ComplaintException;

@Service("complaintservice")
public class ComplaintServiceImpl implements IComplaintService {
	
	private IComplaintDao daoCompliant;
	
	
	
	@Autowired
	public ComplaintServiceImpl(@Qualifier("complaintdao")IComplaintDao daoCompliant) throws ComplaintException{
		
		this.daoCompliant = daoCompliant;
		
	}

	@Override
	public Integer raiseNewComplaint(Complaint complaint) throws ComplaintException {
		
		daoCompliant.raiseNewComplaint(complaint);
		
		return complaint.getComplaintId();
	}

	@Override
	public Complaint checkStatus(Integer compliantId) throws ComplaintException {
		
		return daoCompliant.checkStatus(compliantId);
	}

	

}
