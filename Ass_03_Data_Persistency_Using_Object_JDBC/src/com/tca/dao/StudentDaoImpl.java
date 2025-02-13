package com.tca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tca.entity.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String save(Student ob) {
		
		final String URL = "jdbc:postgresql://localhost:5432/hbf?ssl=true&sslmode=require";
//		final String URL = "jdbc:postgresql://dpg-cueugilumphs73alureg-a.singapore-postgres.render.com:5432/mydb";
		final String USER = "root";
	    final String PASSWORD = "root@123";
//	    final String PASSWORD = "v1ByWJInSbmGRPjVvAHi7LVo0vevig4E";
	    final String DRIVER = "org.postgresql.Driver";
	    
	    
	    Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
						
			ps = conn.prepareStatement("INSERT INTO student VALUES(?,?,?)");
			
			ps.setInt(1, ob.getRno());
			ps.setString(2, ob.getName());
			ps.setDouble(3, ob.getPer());
			
			int sVal = ps.executeUpdate();
			
			if(sVal == 1) {
				return "SUCCESS";
			}
			else {
				return "FAILED";
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return "FAILED";
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}		
	}

	
	
	//Fetch All Records
	@Override
	public List<Student> fetchAll() {
		
		final String URL = "jdbc:postgresql://localhost:5432/hbf?sslmode=disable";
		final String USER = "root";
	    final String PASSWORD = "root@123";
	    final String DRIVER = "org.postgresql.Driver";
	    
	    
	    Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Student> students = null;
		
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM student");
			
			students = new ArrayList<>();
			
			while(rs.next()) {
				
				Student ob = new Student();
				
				ob.setRno(rs.getInt("rno"));
				ob.setName(rs.getString("name"));
				ob.setPer(rs.getDouble("per"));
				
				students.add(ob);
				
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	    
		
		if(students.isEmpty()) return null;
		
		return students;
	}
	
	

}
