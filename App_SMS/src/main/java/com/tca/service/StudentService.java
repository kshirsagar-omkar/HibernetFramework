package com.tca.service;

import java.util.List;

import com.tca.entities.Student;

public interface StudentService {
	
	public abstract Integer saveStudent(Student student);
	public abstract Student findById(Integer id);
	public abstract List<Student> findByName(String name);
	
	public abstract Integer updateStudent(Student student);
	public abstract Integer deleteStudent(Integer id);
}
