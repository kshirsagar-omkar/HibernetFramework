package com.tca;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Department;
import com.tca.entities.Employee;


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
        	configuration.addAnnotatedClass(Department.class);
        	configuration.addAnnotatedClass(Employee.class);
        	
        	
        	sessionFactory = configuration.buildSessionFactory();
        	session = sessionFactory.openSession();
        	
        	transaction = session.beginTransaction();
        
        	
        	
        	
        	
        	/*
        	
        	// ================= department varun employee save karne ==================================
        	
        	Department d = new Department();
        	d.setDid(111);
        	d.setDname("CS");
        	     	
        	
        	Employee e = new Employee();
        	e.setEid(101);
        	e.setEname("aaa");
        	e.setEsalary(10000.0);
        	e.setDept(d);
        	
        	Employee e1 = new Employee();
        	e1.setEid(102);
        	e1.setEname("bbb");
        	e1.setEsalary(8000.0);
        	e1.setDept(d);
        	
        	
        	
        	List<Employee> employees = new ArrayList<>();
        	employees.add(e);
        	employees.add(e1);
        	
        	
        	d.setEmployees(employees);
        	
        	
        	session.save(d);
        	*/
        	
        	
        	
        	
        	/*
        	 
        	// employee varun department save karne
        	
        	
        	
        	Department d = new Department();
        	d.setDid(222);
        	d.setDname("Arts");
        	
        	
        	
        	Employee e2 = new Employee();
        	e2.setEid(103);
        	e2.setEname("ccc");
        	e2.setEsalary(500.0);
        	e2.setDept(d);
        	
        	
        	
        	
        	
        	session.save(e2);
        	
        	*/
        	
        	
        	
        	
        	//Deleting department 222 
        	Department d = session.get(Department.class, 222);
        	session.delete(d);
        	
        	
        	
        	
        	
        	
        
        	
        	transaction.commit();
        	System.out.println("Done!");
        	
        }catch(Exception e) {
        	transaction.rollback();
        	e.printStackTrace();
        }
    }
}
