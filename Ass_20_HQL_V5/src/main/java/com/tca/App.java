package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entities.Student;

/**
 * Hello world!
 */
public class App {
	
	
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	private static Transaction transaction = null;
	
	
    public static void main(String[] args) {
        
    	
    	try {
    		
    	
	    	configuration = new Configuration();
	    	configuration.addAnnotatedClass(Student.class);
	    	
	    	
	    	sessionFactory = configuration.buildSessionFactory();
	    	session = sessionFactory.openSession();
	    	transaction = session.beginTransaction();
    	
	    	/*-------------HQL-------------*/
    	
	    	
	    	
	    /*   	
	    	// Select * from student

	    	Query query = session.createQuery("FROM Student");
	    	List<Student> students = query.list();
	    	
	    	for(Student student : students) {
	    		System.out.println(student);
	    	}
	    	
	    */	
	    	/*
	    	// Select name,per From student
	    	
	    	Query query = session.createQuery("SELECT name, per FROM Student");
	    	
	    	List<Object[]> list = query.list();
	    	
	    	for( Object[] arrayOfObjects : list ) {
	    		
	    		for(Object object : arrayOfObjects) {
	    			System.out.println(object);
	    		}
	    		
	    	}*/
	    	
	    	
	    	
	    	//ORDER BY
	    	Query query = session.createQuery("FROM Student ORDER BY per");
	    	List<Student> students = query.list();
	    	for(Student student : students) {
	    		System.out.println(student);
	    	}
	    	
	    	
	    	
	    	/*-------------END-------------*/
	    	transaction.commit();
	    	
	    	System.out.println( "\nDone!" );
	    	
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		transaction.rollback();
    	}
    	finally {
    		session.close();
    		sessionFactory.close();
    	}
    	
    	
    }
    
}
