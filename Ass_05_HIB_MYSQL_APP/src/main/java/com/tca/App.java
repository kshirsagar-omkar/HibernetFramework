package com.tca;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.tca.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Configuration configuration = null;
    	SessionFactory sessionFactory = null;
    	Session session = null;
    	Transaction transaction= null;
    	
    	
    	try {
	    	configuration = new Configuration();
	    	
	    	configuration.configure();
	    	 
	    	sessionFactory = configuration.buildSessionFactory();
	    	
	    	session = sessionFactory.openSession();
	    	
	    	transaction = session.beginTransaction();
	    	
	    	
	    	Student student = new Student();
	    	
	    	student.setRno(101);
	    	student.setName("AAA");
	    	student.setPer(66.6);
	    	
	    	session.save(student);
	    	
	    	transaction.commit();
	    	System.out.println( "Data Saved Successfully" );
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
