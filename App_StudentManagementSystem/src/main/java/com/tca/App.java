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
import com.tca.util.HibernateUtil;
import com.tca.util.StudentUtil;

/**
 * Hello world!
 */
public class App {
	
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n============== Student Course Management ==============");
            System.out.println("1. Save Student");
            System.out.println("2. Fetch All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Save Course");
            System.out.println("6. Enroll Student in Course");
            System.out.println("7. Assign Grade");
            System.out.println("8. Search Student and Enrollments");
            System.out.println("9. Paginated Student-Course View");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    optionSaveStudent();
                    break;
                case 2:
                    optionFetchAllStudent();
                    break;
                case 3:
                    optionUpdateStudent();
                    break;
                case 4:
                    optionDeleteStudent();
                    break;
                case 5:
                    optionSaveCourse();
                    break;
                case 6:
                    optionEnrollStudentInCourse();
                    break;
                case 7:
                    optionAssignGrade();
                    break;
                case 8:
                    optionSearchStudent();
                    break;
                case 9:
                    optionPaginationSearchStudentCourse();
                    break;
                case 0:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        HibernateUtil.closeSessionFactory();
        sc.close();
        System.out.println("Done!");
    }

    
    
    
    
    public static void optionPaginationSearchStudentCourse() {
    	
    	StudentCourseService studentCourseService = StudentCourseServiceFactory.getStudentCourseService();
    	
    	
    	Integer currentPage = 1;
    	String choice = null;
    	
    	Scanner sc = new Scanner(System.in);
    	
		List<StudentCourse> enrollments = studentCourseService.paginationSearchStudentCourse(currentPage);

    	while(true) {

    		if(enrollments == null || enrollments.isEmpty()) {
        		System.out.println("No Record Found!!\n");
        		return;
        	}
        	else {
        		for(StudentCourse enrollment : enrollments) {
        			
        			
        			
        			Student student = enrollment.getStudent();
        			
            		System.out.println("\n**************Student Information********************");
                	
            		System.out.println("First Name 	: " + student.getFirstName());
            		System.out.println("Last Name 	: " + student.getLastName());
            		System.out.println("Email 		: " + student.getEmail());
            		System.out.println("Phone Number 	: +" + student.getPhone().getCountryCode() + " " + student.getPhone().getNumber());
            		System.out.println("Date Of Birth 	: " + student.getDateOfBirth());
            		System.out.println("Address		: " + student.getAddress());
            		
            	
                	System.out.println("\n---------------Enrolled Course---------------");
        			
        			
        			Course course = enrollment.getCourse();
        			
        			System.out.println("Course Id 	: " + course.getCourseId());
        			System.out.println("Course Name 	: "+ course.getCourseName());
        			System.out.println("Course Code 	: " + course.getCourseCode());
        			System.out.println("Course Credits 	: " + course.getCredits());
        			System.out.println("Grade		: " + enrollment.getGrade());
        			System.out.println("Enroll Date 	: " + enrollment.getEnrollmentDate());
        			System.out.println("-----------------------------------------------\n\n\n");
        		}
        	}
    		
    		System.out.print("Press p [Previous], n [Next] :");
    		choice = sc.next().toLowerCase();
    		
    		enrollments = switch(choice) {
				case "p" -> studentCourseService.paginationSearchStudentCourse(--currentPage);
				case "n" -> studentCourseService.paginationSearchStudentCourse(++currentPage);
				default -> null;
    		};
    		
    	}
    	
    	
    }
    
    
    
    
    
    
    public static void optionSearchStudent() {
    	
    	StudentCourseService studentCourseService = StudentCourseServiceFactory.getStudentCourseService();
    	
    	Integer studentId = null;
    	
    	Scanner sc = new Scanner(System.in);
    	
    	
    	System.out.print("Enter Student Id :");
    	studentId = sc.nextInt();
    	
    	
    	List<StudentCourse> enrollments = studentCourseService.findStudent(studentId);
    	
    	if(enrollments == null || enrollments.isEmpty()) {
    		System.out.println("No Record Found!!\n");
    	}
    	else {
    		
    		Student student = enrollments.get(0).getStudent();
    		System.out.println("**************Student Information********************");
        	
    		System.out.println("First Name 		: " + student.getFirstName());
    		System.out.println("Last Name 		: " + student.getLastName());
    		System.out.println("Email 			: " + student.getEmail());
    		System.out.println("Phone Number 		: +" + student.getPhone().getCountryCode() + " " + student.getPhone().getNumber());
    		System.out.println("Date Of Birth 		: " + student.getDateOfBirth());
    		System.out.println("Address			: " + student.getAddress());
    		System.out.println("-----------------------------------------------\n");
    	
        	System.out.println("**************Enrolled Courses********************");
    		
    		for(StudentCourse enrollment : enrollments) {
    			Course course = enrollment.getCourse();
    			
    			System.out.println("Course Id 		: " + course.getCourseId());
    			System.out.println("Course Name 	: "+ course.getCourseName());
    			System.out.println("Course Code 	: " + course.getCourseCode());
    			System.out.println("Course Credits 	: " + course.getCredits());
    			System.out.println("Grade		: " + enrollment.getGrade());
    			System.out.println("Enroll Date 	: " + enrollment.getEnrollmentDate());
    			System.out.println("-----------------------------------------------");
    		}
    	}
    	
//    	sc.close();
    }
    
    
    
    public static void optionAssignGrade() {
    	
    	StudentCourseService studentCourseServive = StudentCourseServiceFactory.getStudentCourseService();
    	
    	Integer studentId = null;
    	Integer courseId = null;
    	String grade = null;
    	
    	Scanner sc = new Scanner(System.in);
    	
    	
    	System.out.print("Enter Student Id :");
    	studentId = sc.nextInt();

    	System.out.print("Enter Course Id :");
    	courseId = sc.nextInt();
    	
    	System.out.print("Enter Grade :");
    	grade = sc.next();
    	
    	
    	if( studentCourseServive.assignGrade(studentId, courseId, grade) == true) {
    		
    		System.out.println("Grade Assign successfull for student : " + studentId + " to course : " + courseId);
    		
    	}else {
    		System.out.println("Unable to assign grade!!");
    	}
    	
    	sc.close();
    	
    }
    
    
    
    
    public static void optionEnrollStudentInCourse() {
    	StudentCourseService studentCourseServive = StudentCourseServiceFactory.getStudentCourseService();
    	
    	
    	StudentCourse enrollment = new StudentCourse();
    	
    	enrollment.setEnrollmentDate(LocalDateTime.now());
    	//This will come from the user
//    	enrollment.setGrade("A+");   	
    	
    	Integer studentId = null;
    	Integer courseId = null;
    	
    	
    	Scanner sc = new Scanner(System.in);
    	
    	
    	System.out.print("Enter Student id :");
    	studentId = sc.nextInt();
    	
    	System.out.print("Enter Course id :");
    	courseId = sc.nextInt();
    	

    	Integer id = studentCourseServive.EnrollStudentInCourse(studentId, courseId, enrollment);
    
    	if(id != null) {
    		System.out.println("Enroll Done!! Enroll Id :" + id);
    	}else {
    		System.out.println("Unable to enroll!!");
    	}
    	
    	
//    	sc.close();
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
//    	sc.close();
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
    	
    	Integer id = studentService.saveStudent(student);
    	
    	if(id != null) {
    		System.out.println("Record saved successfully for id : " + id);
    	}
    	else {
    		System.out.println("Unable to save record!!!");
    	}
    	
    }
    

   
    
}
