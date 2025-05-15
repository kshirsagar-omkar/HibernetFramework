package com.tca;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entities.Course;
import com.tca.entities.Student;
import com.tca.entities.StudentCourse;


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
        	configuration.addAnnotatedClass(StudentCourse.class);
        	
        	
        	sessionFactory = configuration.buildSessionFactory();
        	session = sessionFactory.openSession();
        	
        	transaction = session.beginTransaction();
        
        	
        
        	/*
        	
        	//Task 1. I Want to assign course 111 to student 101
        	
        	Course c = new Course();
        	c.setCid(111);
        	c.setCname("core java");
        	
        	Student s = new Student();
        	s.setRno(101);
        	s.setName("aaa");
        	
        	
        	StudentCourse SC = new StudentCourse();
        	SC.setId(1);
        	SC.setCourse(c);
        	SC.setStudent(s);
        	SC.setRegDate(LocalDate.now());
        	
        	
        	
        	
        	session.save(SC);
        	
        	*/
        	
        	
        	
        	/*
        	//Task 2. I want to assign course 222 to student 101 (Already exist)
        	
        	Course c = new Course();
        	c.setCid(222);
        	c.setCname("advance java");
        	
        	
        	Student s = session.get(Student.class, 101);
        	
        	
        	StudentCourse SC = new StudentCourse();
        	SC.setId(2);
        	SC.setCourse(c);
        	SC.setStudent(s);
        	SC.setRegDate(LocalDate.of(2025, 5, 20));
        	
        	
        	session.save(SC);
        	*/
        	
        	
        	
        	
        	/*
        	//Task 3. Student 102 has taken admission butt don't have any course yet
        	Student s = new Student();
        	s.setName("bbb");
        	s.setRno(102);
        	
        	session.save(s);
        	*/
        	
        	
        	
        	
        	/*
        	//Task 4. Launching course 333 but not have any student
        	Course c = new Course();
        	c.setCname("hibernate");
        	c.setCid(333);
        	
        	session.save(c);
        	*/
        	
        	
        	
        	
        	
        	
        	/*
        	//Task 5. student 102 wants to join course 222
        	Student s = session.get(Student.class, 102);
        	Course c = session.get(Course.class, 222);
        	
        	StudentCourse sc = new StudentCourse();
        	sc.setId(3);
        	sc.setCourse(c);
        	sc.setStudent(s);
        	sc.setRegDate(LocalDate.now());
        	
        	session.save(sc);
        	*/
        	
        	
        	
        	
        	
        	
        	
        	/*
        	// Task 6. new student 103 wants to join hibernate 333
        	Student s = new Student();
        	s.setRno(103);
        	s.setName("bbb");
        	
        	Course c = session.get(Course.class, 333);
        	
        	StudentCourse sc = new StudentCourse();
        	sc.setId(4);
        	sc.setCourse(c);
        	sc.setStudent(s);
        	sc.setRegDate(LocalDate.now());
        	
        	
        	session.save(sc);
        	*/
        	
        	
        	
        	
        	
        	
        	
        	/*
        	
        	//Task 7. Fetch All course for student 101
        	Student student = session.get(Student.class, 101);
        	
        	System.out.println(student.getRno());
        	System.out.println(student.getName());
        	System.out.println();
        	
        	List<StudentCourse> studentCourses = student.getRegs();
        	
        	for(StudentCourse sc : studentCourses) {
        		
        		Course c = sc.getCourse();
        		
        		System.out.println( c.getCid() );
        		System.out.println( c.getCname() );
        		
        		System.out.println();
        	}
        	
        	*/
        	
        	
        	
        	
        	// Find Student-Course Information whose registration take place on 3rd May, 2025
			// 1. write this by using HQL
			// 2. write this by using native SQL

        	
        	
        	// 1. write this by using HQL
        	Query query = session.createQuery(" FROM StudentCourse Where regDate = :inputRegDate");
        	
        	query.setParameter("inputRegDate", LocalDate.now());
        	
        	
        	List<StudentCourse> studentCourses = query.list();
        	
        	
        	for(StudentCourse sc : studentCourses) {
        		
        		System.out.println("Student : " + sc.getStudent().getRno() + " " + sc.getStudent().getName());
        		
        		
        		System.out.println("Course : " + sc.getCourse().getCid() + " " + sc.getCourse().getCname());
        		
        		System.out.println("Registration date : " + sc.getRegDate());
        		
        		
        		System.out.println();
        	}
        	
        	
        	
        	

        	/*
        	
        	// 2. write this by using native SQL
        	
        	@SuppressWarnings("unchecked")
			List<Object[]> results = session.createNativeQuery("SELECT s.rno, s.name, c.cid, c.cname, sc.regdate FROM student_course sc, student s, course c WHERE s.rno=sc.fk_rno AND c.cid=sc.fk_cid AND regdate='2025-05-15'").list();
        	
        	
        	for(Object[] row : results) {
        		
        		System.out.println("Student Id   : " +  row[0] );
        		System.out.println("Student Name : " + row[1] );
        		System.out.println("Course Id    : " + row[2] );
        		System.out.println("Course Name  : " +row[3] );
        		System.out.println("Registration Date : " + row[4] );
        		
        		System.out.println();
        		
        	}
        	*/
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	transaction.commit();
        	System.out.println("Done!");
        	
        }catch(Exception e) {
        	transaction.rollback();
        	e.printStackTrace();
        }
    }

	private static Student Student() {
		// TODO Auto-generated method stub
		return null;
	}
}
