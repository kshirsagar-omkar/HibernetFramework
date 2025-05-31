package com.tca.service;

import java.util.List;

import com.tca.entities.StudentCourse;

public interface StudentCourseService {
	public abstract Integer EnrollStudentInCourse(Integer studentId, Integer courseId, StudentCourse enrollment);
	public abstract Boolean assignGrade(Integer studentId, Integer courseId, String grade);
	public abstract List<StudentCourse> findStudent(Integer studentId);
	
	public abstract List<StudentCourse> paginationSearchStudentCourse(Integer pageNumber);
}
