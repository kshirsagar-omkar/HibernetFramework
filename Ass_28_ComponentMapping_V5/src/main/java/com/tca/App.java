package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entities.ContactNumber;
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
        
        	
        	Student studentt = new Student();
        	studentt.setRno(101);
        	studentt.setName("Omkar");
        	studentt.setPer(95.88);
        	studentt.setCity("PUNE");
        	
        	ContactNumber phoneNumber = new ContactNumber();
        	phoneNumber.setCountryCode(91);
        	phoneNumber.setNumber("9309272458");
        	
        	
        	studentt.setPhoneNumber(phoneNumber);
        	
        	
        	session.save(studentt);
        	
        	
        	
        	Query query = session.createQuery("From Student");

        	
        	List<Student> students = query.list();
        	
        	for(Student student : students) {
        		System.out.println("Student rno   : " + student.getRno());
        		
        		
        		ContactNumber phnNo = student.getPhoneNumber();
        		System.out.println("Student phone number : +" + phnNo.getCountryCode() + " " + phnNo.getNumber() );
        		
        		
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
