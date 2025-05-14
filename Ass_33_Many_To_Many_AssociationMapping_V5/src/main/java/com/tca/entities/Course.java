package com.tca.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	private Integer cid;
	private String cname;

	
	@ManyToMany( mappedBy="courses", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Student> students;


	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
