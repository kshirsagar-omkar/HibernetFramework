package com.tca.service;

import java.util.List;

import com.tca.entities.Student;

public interface StudentService {
	public abstract Integer saveStudent(Student student);
	public abstract List<Student> fetchAllStudent();
	public abstract Boolean updateStudent(Integer Id);
	public abstract Boolean deleteStudent(Integer Id);
	
}
