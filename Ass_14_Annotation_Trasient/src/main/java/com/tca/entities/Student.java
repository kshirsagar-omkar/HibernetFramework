package com.tca.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Student {
	
	@Id
	private Integer rno;

	private String name;
	
	private Double per;

	
	@Transient
	//Suppose this field is only needed in java side for temperory use
	//This Field is not created in database side
	private Integer age;
	

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
	
	
	
	
}
