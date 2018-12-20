package com.jp.hr.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jp.hr.entities.Dept;
import com.jp.hr.entities.Emp;
import com.jp.hr.exceptions.HrException;



@Repository("daoDS")
public class DaoEmployeeImplJPA implements DaoEmployee {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Emp> getEmplist() throws HrException {
		String sql = "SELECT e FROM empRecNew e";
		Query qry = entityManager.createQuery(sql);
		
		List<Emp> empList = qry.getResultList();
		return empList;
	}

	@Override
	public List<Dept> getDeptlist() throws HrException {
		String sql = "SELECT d FROM dept d"; //Here dept is coming from the entity name given to the dept class
		Query qry = entityManager.createQuery(sql);
		List<Dept> deptList = qry.getResultList();
		return deptList;
	}
	
	
	
	@Override
	public Emp getEmpDetails(int empNo) throws HrException {
		Emp emp = entityManager.find(Emp.class, empNo);
		return emp;
	}

	@Override
	public Dept getDeptDetails(int deptNo) throws HrException {
		Dept dept = entityManager.find(Dept.class, deptNo);
		return dept; //This dept object will return all the fields of Dept table + the set of objects of all the employees of that dept no.
	}

}
