package com.tca;

import com.tca.dao.StudentDao;
import com.tca.dao.StudentDaoImpl;
import com.tca.entity.Student;

public class App {
	
	public static void main(String[] args) {
		
		Student student = new Student();
		student.setRno(101);
		student.setName("Sachin");
		student.setPer(75.56);
		
		
		StudentDao dao = new StudentDaoImpl();
		
		String sVal = dao.save(student);
		
		if(sVal.equals("SUCCESS")) {
			System.out.println("Record Saved Successfully!!");
		}
		else if(sVal.equals("FAILED")) {
			System.out.println("Unable To Save Record!!!..");
		}
		
	}
	
}
