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
	
	
	static {
		try {
			
    		configuration = new Configuration();
    		configuration.configure();
    		sessionFactory = configuration.buildSessionFactory();
//    		session = sessionFactory.openSession();
    		
    	}
    	catch(Exception e) {
    		System.out.println("\n\n\n" + e.getMessage() + "\n\n\n");
    		e.printStackTrace();
    		System.exit(1);
    	}
	}
	
    public static void main( String[] args )
    {
    	
    	
    	
    	System.out.println( mySave() );
    	myPersist();
    	
    	
    	System.out.println("\n\nSuccess!!\n\n");
    	
    	sessionFactory.close();
    }
    
    
    
    // save() saves the object as a record in database and return the primary key
    private static Integer mySave(){
    	    	
    	try{
    		
    		Student student = new Student();
        	student.setRno(101);
        	student.setName("om");
        	student.setPer(95.88);
        	
    		session = sessionFactory.openSession();
    		transaction = session.beginTransaction();
    		
    		
    		Integer rno = (Integer)session.save(student);
    		
    		
    		transaction.commit();
    		
    		return rno;
    		
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    		
    		if(transaction != null) {
    			transaction.rollback();
    		}
    		
    		return null;
    		
    	}
    	finally {
    		if(session!=null){
    			session.close();
    		}
    	}
    	
    	
    	
    
    }
    
    
    
    
    
    // persist() saves the object as a record in database and return Nothing
    private static void myPersist(){
    	    	
    	try{
    		
    		Student student = new Student();
        	student.setRno(102);
        	student.setName("jay");
        	student.setPer(75.67);
        	
    		session = sessionFactory.openSession();
    		transaction = session.beginTransaction();
    		
    		
    		session.persist(student);
    		
    		
    		transaction.commit();
    		
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    		
    		if(transaction != null) {
    			transaction.rollback();
    		}
    		    		
    	}
    	finally {
    		if(session!=null){
    			session.close();
    		}
    	}
    	
    	
    	
    
    }
    
    
}
