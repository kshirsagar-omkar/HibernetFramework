package com.tca.dao;

import com.tca.entities.Course;

public interface CourseDao {
	public abstract Integer saveCourse(Course course);
	public abstract Course findCourse(Integer id);
}
