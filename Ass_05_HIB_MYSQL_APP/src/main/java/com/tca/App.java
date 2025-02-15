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
    	
    	Configuration configuration = new Configuration();
    	
    	configuration.configure();
    	 
    	SessionFactory sessionFactory = configuration.buildSessionFactory();
    	
    	Session session = sessionFactory.openSession();
    	
    	Transaction transaction = session.beginTransaction();
    	
    	
    	Student student = new Student();
    	
    	student.setRno(102);
    	student.setName("AAA");
    	student.setPer(66.6);
    	
    	session.save(student);
    	
    	transaction.commit();
    	session.close();
    	sessionFactory.close();
    	
    	
        System.out.println( "Data Saved Successfully" );
    }
}
