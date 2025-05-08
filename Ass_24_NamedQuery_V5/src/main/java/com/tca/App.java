package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entities.Student;

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
    		
    		
    		/*======================================== NamedQuery ==========================================*/
    		/*
    		//1. GET_ALL_STUDENTS
    		Query query = session.getNamedQuery("GET_ALL_STUDENTS");
    		*/
    		
    		/*
    		//2.City Wise
    		Query query = session.getNamedQuery("GET_ALL_STUDENTS_CITYWISE");
    		query.setParameter("inputCity", "PUNE");
    		
    		
    		List<Student> students = query.list();
    		for(Student student : students) {
    			System.out.println(student);
    		}
    		
    		System.out.println("\nDone!\n");
    		*/
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		/*======================================== NamedQueries ==========================================*/
    		
    		
    		//1. GET_ALL_STUDENTS
    		
    		
    		
    		Query query = session.getNamedQuery("GET_ALL_STUDENTS");
    		
    		
    		
    		List<Student> students = query.list();
    		for(Student student : students) {
    			System.out.println(student);
    		}
    		
    		
    		
    		
    		System.out.println("\n==========================================================!\n");
    		
    		
    		
    		//2.City Wise
    		Query query1 = session.getNamedQuery("GET_ALL_STUDENTS_CITYWISE");
    		query1.setParameter("inputCity", "PUNE");
    		
    		
    		
    		List<Student> students1 = query1.list();
    		for(Student student : students1) {
    			System.out.println(student);
    		}
    		
    		
    		

    		
    		
    		System.out.println("\nDone!\n");
    		transaction.commit();
    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		transaction.rollback();
    	}
    	finally {
    		session.clear();
    		sessionFactory.close();
    	}
    	
    }
}
