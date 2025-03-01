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
    	System.out.println("\n\n\nStart\n\n\n");
    	
    	/*Save and persist
    	 * 
    	 * 1. Save record and return the primary key
    	 * 2. only save the record doesn't return anything
    	 * 
    	 * */
    	
    	//System.out.println( mySave() );
    	//myPersist();
    	
    	
    	
    	/*===========================================================================================================*/
    	
    	
    	
    	
    	/*Update and saveOrUpdate
    	 * 
    	 * 1. Update the record if the record is exist. If record does not exist it gives an EXCEPTION
    	 * 2. Update the record if the record is exist. If the record does not exist it INSERT the Records 
    	 * 
    	 * */
    	
//    	myUpdate();
//    	mySaveOrUpdate();
    	
    	
    	
    	
    	
    	/*===========================================================================================================*/
    	
    	
    	
    	
    	/*Delete
    	 * 1.This Will DELETE the record if FOUND. ELSE It Does NOTHING
    	 * 
    	 * */
    	
//    	myDelete();
    	
    	
    	
    	
    	
    	/*===========================================================================================================*/
    	
    	
    	/* Get & Load 
    	 * Both Fetch Record from Database
    	 * 
    	 * 1. 	if record not found it return null
    	 * 		Early Loading OR Eager Loading 
    	 * 		-> get record as soon as get() is called.
    	 * 
    	 * 2.	if record not found it gives an Exception
    	 * 		Late Loading or Lazy Loading
    	 * 		-> get only identifier as PROXY OBJECT when load() is called.
    	 * 		   When other than identifier field(i.e student.getName(), etc) is called then ACTUALLY IT FIRES the QUERY 	
    	 * 
    	 * */
    	
    	myGet();
    	myLoad();
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	System.out.println("\n\nSuccess!!\n\n");
    	
    	sessionFactory.close();
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*===========================================================================================================*/
    
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
    
    /*===========================================================================================================*/
    
    
    
    
    /*===========================================================================================================*/
    
    /* Only Updates the record if the Record is already is in database */
    private static void myUpdate() {
    	try {
    		Student student = new Student();
        	student.setRno(101);
        	student.setName("om"); 			//This create an problem because if we not set an value to. its by default value is 'null' so it will be saved in db
        	student.setPer(22.88);
        	
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
        	
        	
        	session.update(student);
        	
        	
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
    	}
    }
    
    
    /*This Updates the record if exist. If the record is not exist the it insert the record*/
    private static void mySaveOrUpdate() {
    	try {
    		Student student = new Student();
        	student.setRno(106);
//        	student.setName("om"); 			//This create an problem because if we not set an value to. its by default value is 'null' so it will be saved in db
        	student.setPer(22.88);
        	
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
        	

        	
        	session.saveOrUpdate(student);
        	
        	
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
    	}
    }
    
    
    /*===========================================================================================================*/
    
    
    
    
    
    /*===========================================================================================================*/
    
    /*This will delete the record if exist. If record not exist it then it does nothing*/
    private static void myDelete() {
    	try {
    		Student student = new Student();
    		student.setRno(106);
    		
    		session = sessionFactory.openSession();
    		transaction = session.beginTransaction();
    		
    		session.delete(student);
    		
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
    	}
    }
    
    
    
    
    /*===========================================================================================================*/
    
    
    
    
    
    /*===========================================================================================================*/
    
    
    /*This Will Fetch the record from database if found return object else null*/
    private static void myGet(){
    	try {
    		
    		Integer rno = 106;
    		
    		session = sessionFactory.openSession();
    		
    		Student student = (Student) session.get(Student.class, rno);
    		
    		System.out.println(student);
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		if(session != null) {
    			session.close();
    		}
    	}
    }
    
    /*This Will Fetch record from database if found return object else EXCEPTION*/
    
    private static void myLoad(){
    	try {
    		
    		Integer rno = 106;
    		
    		session = sessionFactory.openSession();
    		
    		Student student = (Student) session.load(Student.class, rno);
    		
    		System.out.println(student);
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		if(session != null) {
    			session.close();
    		}
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
