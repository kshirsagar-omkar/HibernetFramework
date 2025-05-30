package com.tca.dao;

import java.util.List;

import com.tca.entities.Student;

public interface StudentDao {
	public abstract Integer saveStudent(Student student);
	public abstract List<Student> fetchAllStudent();
	public abstract Boolean updateStudent(Student student);
	public abstract Boolean deleteStudent(Student student);
	public abstract Student findStudent(Integer id);
}
