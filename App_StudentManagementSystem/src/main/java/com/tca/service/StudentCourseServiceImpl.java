package com.tca.service;

import com.tca.entities.Course;
import com.tca.entities.Student;
import com.tca.entities.StudentCourse;
import com.tca.factory.CourseDaoFactory;
import com.tca.factory.StudentCourseDaoFactory;
import com.tca.factory.StudentDaoFactory;

public class StudentCourseServiceImpl implements StudentCourseService{

	@Override
	public Integer EnrollStudentInCourse(Integer studentId, Integer courseId, StudentCourse enrollment) {
		
		Student student = StudentDaoFactory.getStudentDao().findStudent(studentId);
		Course course = CourseDaoFactory.getCourseDao().findCourse(courseId);
		
		enrollment.setStudent(student);
		enrollment.setCourse(course);
		
		
		return StudentCourseDaoFactory.getStudentCourseDao().EnrollStudentInCourse(enrollment);
	}

}
