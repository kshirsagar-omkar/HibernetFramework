package com.tca.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.tca.components.Phone;
import com.tca.dao.StudentDao;
import com.tca.entities.Student;
import com.tca.factory.StudentDaoFactory;
import com.tca.util.StudentUtil;

public class StudentServiceImpl implements StudentService {

	@Override
	public Integer saveStudent(Student student) {
		return StudentDaoFactory.getStudentDao().saveStudent(student);
	}

	@Override
	public List<Student> fetchAllStudent() {
		return StudentDaoFactory.getStudentDao().fetchAllStudent();
	}

	@Override
	public Boolean updateStudent(Integer Id) {
		
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		
		Student student = studentDao.findStudent(Id);
		
		if( student == null ) return false;
		
		

		System.out.println("**************Current Student Information********************");
		
		System.out.println("First Name 		: " + student.getFirstName());
		System.out.println("Last Name 		: " + student.getLastName());
		System.out.println("Email 			: " + student.getEmail());
		System.out.println("Phone Number 		: -" + student.getPhone().getCountryCode() + " " + student.getPhone().getNumber());
		System.out.println("Date Of Birth 		: " + student.getDateOfBirth());
		System.out.println("Address			: " + student.getAddress());
//		System.out.println("-----------------------------------------------\n");

    	System.out.println("******************************************************\n");
		
    	
    	System.out.println("**Enter The Updated Record**");
    	
    	
    	
    	
    	student = StudentUtil.fillAndGetStudent();
    	student.setStudentId(Id);
    	
    	
    	
		return studentDao.updateStudent(student);
	}
	

	@Override
	public Boolean deleteStudent(Integer Id) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		
		Student student = studentDao.findStudent(Id);
		
		if( student == null ) return false;
		
		return studentDao.deleteStudent(student);
	}
	
}


















