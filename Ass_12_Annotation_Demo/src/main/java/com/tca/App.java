package com.tca;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;


public class App 
{
	
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	private static Transaction transaction = null;
	
	
	
	
    public static void main( String[] args )
    {
    	
    	configuration = new Configuration();
    	
    	configuration.addAnnotatedClass(Student.class);
    	
    	
    	
    	sessionFactory = configuration.buildSessionFactory();
    	session = sessionFactory.openSession();
    	transaction = session.beginTransaction();
    	
    	try {
    		
    		
    		Student student = new Student();
    		student.setRno(111);
    		student.setName("Omkar");
    		student.setPer(95.88);
    		
    		
    		session.save(student);
    		transaction.commit();
    		
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		transaction.rollback();
    	}
    	finally {
    		session.close();
    		sessionFactory.close();
    	}
    	
    	
    	
        System.out.println( "Hello World!" );
    }
}
