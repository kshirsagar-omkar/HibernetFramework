package com.tca.service;

import com.tca.entities.StudentCourse;

public interface StudentCourseService {
	public abstract Integer EnrollStudentInCourse(Integer studentId, Integer courseId, StudentCourse enrollment);
}
