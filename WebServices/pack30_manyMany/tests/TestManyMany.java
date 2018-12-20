package com.hibernate.pack90_association.pack30_manyMany.tests;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.pack90_association.pack30_manyMany.beans.Emp;
import com.hibernate.pack90_association.pack30_manyMany.beans.Project;
import com.hibernate.pack90_association.pack30_manyMany.utils.HibernateUtils;

public class TestManyMany {

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;

		try {
			HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSession();
			tx = HibernateUtils.getTransaction(session);

			
			/* // 1. Explore relationship. // Get navigation from one side. Getnavigation from both side. 
			 Project proj1 = (Project)session.load(Project.class, 100);
			 System.out.print("Number:"+proj1.getProjectId()+"\t"+proj1.getProjectTitle()); //Emp emp1 = (Emp)
			 session.load(Emp.class, 7499); //System.out.println(emp1);
			 Set<Emp> employees = proj1.getEmployees();
			 
			 System.out.println("\nAll employees on Project:"+proj1.getProjectTitle());
			 for(Emp emp : employees)
				 System.out.println(emp.getEmpNo()+"\t\t"+emp.geteName());
			 */

			/*
			 System.out.println("\n All projects of employee:"+7900);
			 Emp emp= (Emp) session.load(Emp.class, 7900);
			 Set<Project> projects = emp.getProjects();
			 
			 for(Project project : projects){
				 System.out.println(project);
			}
			 */

			/* Working with Joins
			List<Emp> empList = session.createQuery(
					"from Emp emp join fetch emp.projects").list();

			for (Emp emp : empList) {
				System.out.println(emp);
			}
			*/
			System.out.println("Committing.");
			HibernateUtils.commit(tx);
		} catch (HibernateException e) {
			e.printStackTrace();
			HibernateUtils.rollback(tx);
		} finally {
			HibernateUtils.closeSession(session);
			HibernateUtils.closeHibetnate();
		}
	}
}
