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
    
    	
//    	saveStudent();
//    	findById();
//    	findByName();
    	
//    	updateStudent();
    	
    	
    	deleteStudent();
    	
    	System.out.println("Done!");
    	HibernateUtil.closeSessionFactory();
    	
    }
    
    
    
    
    public static void deleteStudent() {
    	
    	
    	Integer id = 9;

    	Integer retId = StudentServiceFactory.getStudentService().deleteStudent(id);
    	
    	if(retId == null) {
    		System.out.println("Unable To delete record :" + id);
    	}
    	else {
    		System.out.println("Record deleted For :" + id);
    	}

    }
    
    
    
    
    
    public static void updateStudent() {
    	
    	StudentService studentService = StudentServiceFactory.getStudentService();
    	
    	Integer id = 8;
    	
    	Student student = studentService.findById(id);
    	
    	if(student != null) {
    		student.setName("aaa");
        	student.setPer(95.88);
        	student.setCity("pune");
        	
        	id = studentService.updateStudent(student);
        	
        	if(id == null) {
        		System.out.println("Unable To update record :" + id);
        	}
        	else {
        		System.out.println("Record Updated For :" + id);
        	}
    	}
    	else {
    		System.out.println("No Record found for RollNumber : " + id);
    	}

    }
    
    
    public static void findByName() {
    	
    	String name = "a";
    	java.util.List<Student> students = StudentServiceFactory.getStudentService().findByName(name);
    	
    	if(students == null || students.isEmpty()) {
    		System.out.println("Student Not Found for Student Name : " + name);
    	}
    	else {
    		System.out.println("-------------------------------------------------------");
    		for(Student student : students) {
    			System.out.println("Student Rno        : " + student.getRno());
            	System.out.println("Student Name       : " + student.getName());
            	System.out.println("Student Percentage : " + student.getPer());
            	System.out.println("Student City       : " + student.getCity());
            	System.out.println("Student Created At : " + student.getCreatedAt());
            	System.out.println("Student Updated At : " + student.getUpdatedAt());
            	System.out.println();
    		}
    	}
    }
    
    
    
    public static void findById() {
    	
    	Integer id = 1;
    	Student student = StudentServiceFactory.getStudentService().findById(id);
    	
    	if(student != null) {
    		System.out.println("Student Rno        : " + student.getRno());
        	System.out.println("Student Name       : " + student.getName());
        	System.out.println("Student Percentage : " + student.getPer());
        	System.out.println("Student City       : " + student.getCity());
        	System.out.println("Student Created At : " + student.getCreatedAt());
        	System.out.println("Student Updated At : " + student.getUpdatedAt());
    	}
    	else {
    		System.out.println("Student Not Found for RollNumber : " + id);
    	}
    }
    
    
    public static void saveStudent() {
    	
    	StudentService studentService = StudentServiceFactory.getStudentService();
    	
    	Student student = new Student();
    	student.setName("ccc");
    	student.setPer(65.0);
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
