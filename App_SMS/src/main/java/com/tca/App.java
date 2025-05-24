package com.tca;

import org.hibernate.SessionFactory;

import com.tca.entities.Student;
import com.tca.factory.StudentServiceFactory;
import com.tca.service.StudentService;
import com.tca.util.HibernateUtil;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    	
    	saveStudent();
    	
    	System.out.println("Done!");
    	HibernateUtil.closeSessionFactory();
    	
    }
    
    
    
    public static void saveStudent() {
    	
    	StudentService studentService = StudentServiceFactory.getStudentService();
    	
    	Student student = new Student();
    	student.setName("aaa");
    	student.setPer(96.88);
    	student.setCity("pune");
    	
    	
    	Integer id = studentService.saveStudent(student);
    	
    	if(id == null) {
    		System.out.println("Unable To save record :" + id);
    	}
    	else {
    		System.out.println("Record Saved For :" + id);
    	}
    }
    
    
}
