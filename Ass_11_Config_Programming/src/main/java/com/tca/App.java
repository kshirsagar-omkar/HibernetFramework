package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	private static Transaction transaction = null;
	
	
	
	
    public static void main( String[] args )
    {
    	
    	configuration = new Configuration();
    	
    	configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
    	configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hibernate");
    	configuration.setProperty("hibernate.connection.user", "root");
    	configuration.setProperty("hibernate.connection.password", "root@123");
    	
    	configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    	
    	configuration.setProperty("hibernate.show_sql", "true");
    	configuration.setProperty("hibernate.format_sql", "false");
    	configuration.setProperty("hibernate.hbm2ddl.auto", "create");
    	
    	

    	
    	configuration.addResource("mymap.hbm.xml");
    	
    	
    	sessionFactory = configuration.buildSessionFactory();
    	session = sessionFactory.openSession();
    	transaction = session.beginTransaction();
    	
    	try {
    		
    		
    		Student student = new Student();
    		student.setRno(101);
    		student.setName("Omkar");
    		student.setPer(95.88);
    		
    		
    		session.save(student);
    		transaction.commit();
    		
    		System.out.println( "Hello World!" );
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		transaction.rollback();
    	}
    	finally {
    		session.close();
    		sessionFactory.close();
    	}
    	
    	
    	
        
    }
}
