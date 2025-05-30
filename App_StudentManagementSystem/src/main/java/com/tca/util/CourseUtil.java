package com.tca.util;

import java.util.Scanner;

import com.tca.entities.Course;

public class CourseUtil {
	public static Course fillAndGetCourse() {
		
		Course course = new Course();
		
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("Enter Course Name : ");
			course.setCourseName( sc.nextLine() );
			
			System.out.print("Enter Course Code : ");
			course.setCourseCode( sc.nextLine() );
				
			System.out.print("Enter Course Credits : ");
			course.setCredits( sc.nextInt() );
		}
		
		return course;
	}
}
