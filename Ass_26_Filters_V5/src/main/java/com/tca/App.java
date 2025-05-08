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
        	 
        	//Single Parameter Filter 
        	 
        	Filter filter = session.enableFilter("cityFilter");
        	filter.setParameter("cityName", "PUNE");
        	*/

        	
        	
        	// Double Parameter Filter
        	Filter filter = session.enableFilter("perCityFilter");
        	filter.setParameter("inputPer", 75.0);
        	filter.setParameter("inputCity", "PUNE");
        	
        	
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
