package com.tca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.tca.entity.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String save(Student ob) {
		
		final String URL = "jdbc:postgresql://localhost:5432/hbf?ssl=true&sslmode=require";
	    final String USER = "root";
	    final String PASSWORD = "root@123";
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

}
