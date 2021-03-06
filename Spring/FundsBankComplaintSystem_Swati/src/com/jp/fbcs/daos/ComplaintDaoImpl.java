package com.jp.fbcs.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jp.fbcs.entities.Complaint;
import com.jp.fbcs.exception.ComplaintException;



@Repository("complaintdao")
public class ComplaintDaoImpl implements IComplaintDao {
	
	@Autowired
	private DataSource dataSource;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Integer raiseNewComplaint(Complaint complaint) throws ComplaintException {
		
		//entityManager.getTransaction().begin();
//		String sql = "INSERT INTO COMPLAINT VALUES (?,?,?,?,?,?,?,?)";
//		Query qry = entityManager.createNativeQuery(sql, Complaint.class);
		System.out.println(complaint);
		entityManager.persist(complaint);
		
		//entityManager.close();
		return complaint.getComplaintId();
		
	}

	@Override
	public Complaint checkStatus(Integer compliantId) throws ComplaintException {
		Complaint complaintDesc = entityManager.find(Complaint.class, compliantId);
		return complaintDesc;
	}



	

	

}
