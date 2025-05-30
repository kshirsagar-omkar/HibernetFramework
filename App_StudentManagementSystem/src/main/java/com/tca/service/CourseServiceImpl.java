package com.tca.service;

import com.tca.entities.Course;
import com.tca.factory.CourseDaoFactory;

public class CourseServiceImpl implements CourseService{

	@Override
	public Integer saveCourse(Course course) {
		return CourseDaoFactory.getCourseDao().saveCourse(course);
	}

}
