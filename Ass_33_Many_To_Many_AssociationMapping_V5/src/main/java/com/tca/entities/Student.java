package com.tca.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	private Integer rno;
	private String name;
	
	@ManyToMany( cascade=CascadeType.ALL, fetch=FetchType.LAZY )
	@JoinTable( name="STUDENT_COURSE", joinColumns=@JoinColumn(name="FK_RNO"), inverseJoinColumns=@JoinColumn(name="FK_CID") )
	private List<Course> courses;

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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
