package com.tca.dao;

import java.util.List;

import com.tca.entities.StudentCourse;

public interface StudentCourseDao {
	public abstract Integer EnrollStudentInCourse(StudentCourse enrollment) ;
	public abstract Boolean assignGrade(StudentCourse enrollment);
	public abstract List<StudentCourse> findStudent(Integer studentId);
	
	public abstract List<StudentCourse> paginationSearchStudentCourse(Integer pageNumber);
	
	public abstract StudentCourse findEnrollmentByStudentIdAndCourseId(Integer studentId, Integer courseId);
}
