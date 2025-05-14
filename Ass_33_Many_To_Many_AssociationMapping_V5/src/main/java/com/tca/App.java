package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Course;
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
        	configuration.addAnnotatedClass(Course.class);
        	configuration.addAnnotatedClass(Student.class);
        	
        	
        	sessionFactory = configuration.buildSessionFactory();
        	session = sessionFactory.openSession();
        	
        	transaction = session.beginTransaction();
        
        	
        /*
        	
        	
        	//Task 1. Add 101 student with 111 & 222 courses
        	Student s1 = new Student();
        	s1.setRno(101);
        	s1.setName("aaa");
        	
        	Course c1 = new Course();
        	c1.setCid(111);
        	c1.setCname("core java");
        	
        	Course c2 = new Course();
        	c2.setCid(222);
        	c2.setCname("advance java");

        	
        	s1.setCourses( Arrays.asList(c1, c2) );
        	
        	
        	session.save(s1);
        */
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        /*	
        	//Task 2. A new student wants to take admission for course 222
        	Course c = session.get(Course.class, 222);
        	
        	Student s = new Student();
        	s.setRno(102);
        	s.setName("bbb");
        	
        	s.setCourses( Arrays.asList(c) );
        	
        	session.save(s);
        */	
        	
        	
        	
        	
        /*	
        	
        	//Task 3. Save only course 103 Hibernate
        	Course c = new Course();
        	c.setCid(333);
        	c.setCname("hibernate");
        	
        	
        	session.save(c);
        */
        	
        	
        	
        	
        	
        /*	
        	//Task 4. A new student take admission to existing course 103
        	Course c = session.get(Course.class, 333);
        	
        	Student s = new Student();
        	s.setRno(103);
        	s.setName("ccc");
        	
        	
        	s.setCourses(Arrays.asList(c));
        	
        	session.save(s);
        */
        	
        	
        	
        	
        	
        	//Task 5. Fetch Student with all course rno=101
        	
        	Student s = session.get(Student.class, 101);
        	
        	
        	
        	System.out.println(s.getRno());
        	System.out.println(s.getName());
        	List<Course> courses = s.getCourses() ;
        	
        	for(Course c : courses) {
        		System.out.println( c.getCid() );
        		System.out.println( c.getCname() );
        		System.out.println( );
        	}
        	
        	
        	
        	
        	
        	
        	transaction.commit();
        	System.out.println("Done!");
        	
        }catch(Exception e) {
        	transaction.rollback();
        	e.printStackTrace();
        }
    }
}
