package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        
        
        try {
        	configuration = new Configuration();
        	
        	configuration.addAnnotatedClass(Student.class);
        	        	
        	sessionFactory = configuration.buildSessionFactory();
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
        	
        	//(STUDENT CLASS)Error cause because of this columnDefinition ... when the hbm2ddl = create 
        	Student student = new Student();
        	student.setRno(222);
        	student.setName("bbb");
        	student.setPer(611.89);
        	student.setEmail("bb@gmail.com");
        	
        	session.save(student);
        	
        	
        	transaction.commit();
        }
        catch(Exception e) {
        	e.printStackTrace();
        	if(transaction != null) {
        		transaction.rollback();
        	}
        }
        finally {
        	if(session != null) {
        		session.close();
        	}
        	if(sessionFactory != null) {
        		sessionFactory.close();
        	}
        }
        
        
    }
}
