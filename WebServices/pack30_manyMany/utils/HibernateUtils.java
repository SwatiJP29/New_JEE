package com.hibernate.pack90_association.pack30_manyMany.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateUtils {
 
    private static SessionFactory sessionFactory;
     
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("/com/hibernate/pack90_association/pack30_manyMany/resources/hibernate.cfg.xml");
            System.out.println("Hibernate Configuration loaded");
             
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");
             
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
     
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
    
    public static void closeHibetnate(){
    	if (sessionFactory != null){
    		sessionFactory.close();
    	}
    }

    public static Session getSession(){
		Session session = sessionFactory.openSession();
		System.out.println("Session opened.");
		return session;
	}
	
	public static void closeSession(Session session){
		if (session.isOpen())
			session.close();
		System.out.println("Session closed.");
	}
	
	public static Transaction getTransaction(Session session){
		return session.beginTransaction();
	}
	
	public static void commit(Transaction transaction){
		if (!(transaction.wasCommitted()&&transaction.wasRolledBack()))
			transaction.commit();
	}
	
	public static void rollback(Transaction transaction){
		if (!(transaction.wasCommitted()&&transaction.wasRolledBack()))
			transaction.rollback();
	}
	@Override
	protected void finalize() throws Throwable {
		closeHibetnate();
		super.finalize();
	}
}