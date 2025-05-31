package com.tca.service;

import java.util.List;

import com.tca.dao.StudentCourseDao;
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
		
		if(student == null || course == null) {
			return null;
		}
		
		enrollment.setStudent(student);
		enrollment.setCourse(course);
		
		
		return StudentCourseDaoFactory.getStudentCourseDao().EnrollStudentInCourse(enrollment);
	}

	@Override
	public Boolean assignGrade(Integer studentId, Integer courseId, String grade) {
		
		StudentCourseDao studentCourseDao = StudentCourseDaoFactory.getStudentCourseDao();
		
		StudentCourse enrollment = studentCourseDao.findEnrollmentByStudentIdAndCourseId(studentId, courseId);
		
		if(enrollment != null ) {
			enrollment.setGrade(grade);
			return studentCourseDao.assignGrade(enrollment);
		}		
		return false;
	}

	@Override
	public List<StudentCourse> findStudent(Integer studentId) {
		return StudentCourseDaoFactory.getStudentCourseDao().findStudent(studentId);
	}

	
	
	@Override
	public List<StudentCourse> paginationSearchStudentCourse(Integer pageNumber) {
		//decrementing pageNumber by 1 because the page number start from 1 for front end side
		//And pagination works from 0

		return StudentCourseDaoFactory.getStudentCourseDao().paginationSearchStudentCourse(--pageNumber);
	}

}























