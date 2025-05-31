package com.tca.util;

import java.time.LocalDate;
import java.util.Scanner;

import com.tca.components.Phone;
import com.tca.entities.Student;

public class StudentUtil {
	
	
	public static Student fillAndGetStudent(){
    	
    	System.out.println("*******************Insert Student Details************************");
    	
    	    	
    	Student student = new Student();
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Enter First Name : ");
    	student.setFirstName( sc.next() );
    	
    	System.out.print("Enter Last Name : ");
    	student.setLastName( sc.next() );
    	
    	System.out.print("Enter Email : ");
    	student.setEmail( sc.next() );
    	
    	
    	Phone phone = new Phone();
    	
    	System.out.print("Enter Country Code ex:(+91) : ");
    	phone.setCountryCode( sc.nextInt() );
    	
    	System.out.print("Enter Phone Number : ");
    	phone.setNumber( sc.next() );
    	
    	student.setPhone(phone);

	    	
	    System.out.println("Enter Your Birth Date-");
	    student.setDateOfBirth(getDateFromUser());
    	
    	sc.nextLine();
    	System.out.print("Enter Address : ");
    	student.setAddress( sc.nextLine() );

    	
    	System.out.println("************************************************************");
    	
//    	sc.close();
    	
    	return student;
    }
    
    
    
    private static LocalDate getDateFromUser() {
    	
    	Integer chance = 1;
    	Scanner sc = new Scanner(System.in);	
    	
    	while(true) {
    		try{
    			
    	    	Integer year = null;
    	    	Integer month = null;
    	    	Integer day = null;
    	    	
    	    	System.out.print("Enter Year : ");
    	    	year = sc.nextInt();
    	    	
    	    	System.out.print("Enter month : ");
    	    	month = sc.nextInt();
    	    	
    	    	System.out.print("Enter day : ");
    	    	day = sc.nextInt();
    	    	
    	    	LocalDate date =  LocalDate.of(year, month, day);
    	    	
    	    	return date;
        	}catch(Exception e){
        		System.out.println("Enter a Valid date!!\n");
        		if(chance == 3) {
        			System.out.println("Multiple try's therefore date is set to be null. You can change it latter~!!");
//        			sc.close();
        	    	return null;
        		}
        		++chance;
        	}
    	}
    	
    	
	}
}
