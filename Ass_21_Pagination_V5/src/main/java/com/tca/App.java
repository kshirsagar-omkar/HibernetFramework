package com.tca;

import java.util.List;
import java.util.Scanner;

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
	private static Scanner sc = null;
	
    public static void main(String[] args) {
        
    	try {
    		
    		configuration = new Configuration();
    		configuration.addAnnotatedClass(Student.class);
    		
    		sessionFactory = configuration.buildSessionFactory();
    		session = sessionFactory.openSession();
    		
    		
    		transaction = session.beginTransaction();
    		
    		
    		
    		
    		/*=============================== Pagination  =================================*/
    		
    		Query query = session.createQuery("FROM Student");
    		
    		Integer MAX_RES = 3;
    		
    		query.setMaxResults(MAX_RES);
    		
    		
    		sc = new Scanner(System.in);
    		
    		
    		// example of pagination
    		
    		for(int i=0; i<=9; i+=MAX_RES) {
    			
    			query.setFirstResult(i);
    			
    			List<Student> students = query.list();
    			
    			for(Student student : students) {
    				System.out.println(student);
    			}
    			System.out.println("-------------------------------------------------------------");
    			
    			System.out.print("Enter any key to see next record: ");
    			sc.nextLine();
    			System.out.println();
    			
    		}
    		
    		
    		
    		
    		
    		
    		transaction.commit();
    		
    		
    	}
    	catch(Exception e) {
    		transaction.rollback();
    		e.printStackTrace();
    	}
    	finally {
    		session.close();
    		sessionFactory.close();
    		sc.close();
    	}
    	
    	
    	
    	
    	
    	
    }
}
