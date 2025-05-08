package com.tca.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	private Integer rno;
	
	private String name;
	private Double per;
	private String city;
	
	
	@Embedded
	private ContactNumber phoneNumber;
	
	
	public ContactNumber getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(ContactNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPer() {
		return per;
	}
	public void setPer(Double per) {
		this.per = per;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}
