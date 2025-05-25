package com.tca.service;

import java.util.List;

import com.tca.dao.StudentDao;
import com.tca.entities.Student;
import com.tca.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public Integer saveStudent(Student student) {
		
		return StudentDaoFactory.getStudentDao().saveStudent(student);
		
	}

	@Override
	public Student findById(Integer id) {
		return StudentDaoFactory.getStudentDao().findById(id);
	}

	@Override
	public List<Student> findByName(String name) {
		return StudentDaoFactory.getStudentDao().findByName(name);
	}

	@Override
	public Integer updateStudent(Student student) {
		return StudentDaoFactory.getStudentDao().updateStudent(student);
	}

	@Override
	public Integer deleteStudent(Integer id) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		
		Student student = studentDao.findById(id);
		if(student != null) {
			return studentDao.deleteStudent(student);
		}else {
			return null;
		}
		
	}

}
