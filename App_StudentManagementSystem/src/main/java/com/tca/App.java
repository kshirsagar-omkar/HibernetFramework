package com.tca;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.tca.entities.Course;
import com.tca.entities.Student;
import com.tca.entities.StudentCourse;
import com.tca.factory.CourseServiceFactory;
import com.tca.factory.StudentCourseServiceFactory;
import com.tca.factory.StudentServiceFactory;
import com.tca.service.CourseService;
import com.tca.service.StudentCourseService;
import com.tca.service.StudentService;
import com.tca.util.CourseUtil;
import com.tca.util.StudentUtil;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	
    	
//    	optionSaveStudent();
//    	optionFetchAllStudent();
//    	optionUpdateStudent();
//    	optionDeleteStudent();
//    	optionSaveCourse();
    	
    	optionEnrollStudentInCourse();
        System.out.println("Done!");
    }
    
    
    
    
    
    public static void optionEnrollStudentInCourse() {
    	StudentCourseService studentCourseServive = StudentCourseServiceFactory.getStudentCourseService();
    	
    	
    	StudentCourse enrollment = new StudentCourse();
    	
    	enrollment.setEnrollmentDate(LocalDateTime.now());
    	//This will come from the user
    	enrollment.setGrade("A+");
    	
    	Integer studentid = 4;
    	Integer courseId = 5;
    	
    	Integer id = studentCourseServive.EnrollStudentInCourse(studentid, courseId, enrollment);
    
    	if(id != null) {
    		System.out.println("Enroll Done!! Enroll Id :" + id);
    	}else {
    		System.out.println("Unable to enroll!!");
    	}
    }
    
    
    
    
    
    
    public static void optionSaveCourse() {
    	
    	CourseService courseService = CourseServiceFactory.getCourseService();
    	
    	Course course = CourseUtil.fillAndGetCourse();
    	
    	Integer id = courseService.saveCourse(course);
    	
    	if(id != null) {
    		System.out.println("Course Save for id :" + id);
    	}
    	else {
    		System.out.println("Unable to save course!!");
    	}
    	
    }
    
    
    
    
    public static void optionDeleteStudent() {
    	StudentService studentService = StudentServiceFactory.getStudentService();
    	
    	Scanner sc = new Scanner(System.in);
    	
    	Integer id = null;
    	
    	
    	System.out.print("Enter Student Id to be delete :");
    	id = sc.nextInt();
    	
    	
    	if(studentService.deleteStudent(id) == true) {
    		System.out.println("Delete Successfull!");
    	}
    	else {
    		System.out.println("Unable To delete record!!");
    	}
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public static void optionUpdateStudent() {
    	
    	StudentService studentService = StudentServiceFactory.getStudentService();
    	
    	Scanner sc = new Scanner(System.in);
    	
    	Integer id = null;
    	
    	
    	System.out.print("Enter Student Id to be update :");
    	id = sc.nextInt();
    	
    	
    	if(studentService.updateStudent(id) == true) {
    		System.out.println("Update Successfull!");
    	}
    	else {
    		System.out.println("Unable To update record!!");
    	}
    	sc.close();
    }
    
    
    
    
    
    
    public static void optionFetchAllStudent(){
    	
    	StudentService studentService = StudentServiceFactory.getStudentService();
    	
    	List<Student> students = studentService.fetchAllStudent();
    	
    	System.out.println("**************Student Information********************");
    	for(Student student : students) {
    		System.out.println("First Name 		: " + student.getFirstName());
    		System.out.println("Last Name 		: " + student.getLastName());
    		System.out.println("Email 			: " + student.getEmail());
    		System.out.println("Phone Number 		: -" + student.getPhone().getCountryCode() + " " + student.getPhone().getNumber());
    		System.out.println("Date Of Birth 		: " + student.getDateOfBirth());
    		System.out.println("Address			: " + student.getAddress());
    		System.out.println("-----------------------------------------------\n");
    	}
    	System.out.println("******************************************************");
    }
    
    
    
    
    public static void optionSaveStudent(){
    	    	
    	StudentService studentService = StudentServiceFactory.getStudentService();
    	
    	Student student = StudentUtil.fillAndGetStudent();
    	
    	
    	
    }
    

   
    
}
