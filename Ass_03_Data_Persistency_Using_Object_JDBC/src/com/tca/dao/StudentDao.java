package com.tca.dao;

import java.util.List;

import com.tca.entity.Student;

public interface StudentDao {
	
	public abstract String save(Student ob);

	public abstract List<Student> fetchAll();
	
}
