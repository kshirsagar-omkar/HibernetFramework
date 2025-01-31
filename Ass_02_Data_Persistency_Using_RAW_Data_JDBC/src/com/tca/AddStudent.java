package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddStudent {

	public final static String URL = "jdbc:postgresql://localhost:5432/hbf?ssl=true&sslmode=require";
    public final static String USER = "root";
    public final static String PASSWORD = "root@123";
    public final static String DRIVER = "org.postgresql.Driver";
    
	
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			int rno = 111;
			String name = "OM";
			double per=95.88;
			
			ps = conn.prepareStatement("INSERT INTO student VALUES(?,?,?)");
			
			ps.setInt(1, rno);
			ps.setString(2, name);
			ps.setDouble(3, per);
			
			int sVal = ps.executeUpdate();
			
			if(sVal == 1) {
				System.out.println("Record Added Successfully!.");
			}
			else {
				System.out.println("Unable To Add Record!!!.");
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
		

	}

}
