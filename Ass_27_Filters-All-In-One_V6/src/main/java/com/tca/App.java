package com.tca;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entities.Student;


public class App 
{
	
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	private static Transaction transaction = null;
	
    public static void main( String[] args )
    {
        try {
        	
        	configuration = new Configuration();
        	configuration.addAnnotatedClass(Student.class);
        	
        	
        	sessionFactory = configuration.buildSessionFactory();
        	session = sessionFactory.openSession();
        	
        	transaction = session.beginTransaction();
        
        	/*

        	//City wise

        	Filter filter = session.enableFilter("cityFilter");
        	filter.setParameter("inputCity", "PUNE");
        	*/
        	
        	
        	
        	
        	
        	
        	
        	/*
        	
        	//Above input per
        	
        	Filter filter = session.enableFilter("perFilter");
        	filter.setParameter("inputPer", 70.0);
        	*/
        	
        	
        	
        	
        	
        	
        	/**/
        	
        	//City and above inputPer
        	
        	Filter filter = session.enableFilter("perCityFilter");
        	filter.setParameter("inputCity", "PUNE");
        	filter.setParameter("inputPer", 80.0);
        	 
        	/**/
        	
        	
        	Query query = session.createQuery("From Student");

        	
        	List<Student> students = query.list();
        	
        	for(Student student : students) {
        		System.out.println("Student rno   : " + student.getRno());
        		System.out.println("Student name  : " + student.getName());
        		System.out.println("Student per   : " + student.getPer());
        		System.out.println("Student city  : " + student.getCity() + "\n");
        	}
        	
        	
        	transaction.commit();
        	System.out.println("Done!");
        	
        }catch(Exception e) {
        	transaction.rollback();
        	e.printStackTrace();
        }
    }
}
