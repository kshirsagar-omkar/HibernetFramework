package com.tca.service;

import com.tca.dao.StudentDao;
import com.tca.entities.Student;
import com.tca.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public Integer saveStudent(Student student) {
		
		return StudentDaoFactory.getStudentDao().saveStudent(student);
		
	}

}
