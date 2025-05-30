package com.tca.factory;

import com.tca.dao.CourseDao;
import com.tca.dao.CourseDaoImpl;

public class CourseDaoFactory {
	private static CourseDao courseDao = null;
	
	private CourseDaoFactory() {}
	
	public static CourseDao getCourseDao() {
		if( courseDao == null ) {
			courseDao = new CourseDaoImpl();
		}
		return courseDao;
	}
	
}
