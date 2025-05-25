package com.tca.dao;

import java.util.List;

import com.tca.entities.Student;

public interface StudentDao {
	
	public abstract Integer saveStudent(Student student);
	public abstract Student findById(Integer id);
	public abstract List<Student> findByName(String name);
	
	public abstract Integer updateStudent(Student student);
	public abstract Integer deleteStudent(Student student);
}
