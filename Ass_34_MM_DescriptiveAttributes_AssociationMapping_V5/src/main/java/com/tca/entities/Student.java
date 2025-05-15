package com.tca.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	private Integer rno;
	private String name;
	
	
	@OneToMany(mappedBy="student", fetch=FetchType.LAZY)
	private List<StudentCourse> regs;


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


	public List<StudentCourse> getRegs() {
		return regs;
	}


	public void setRegs(List<StudentCourse> regs) {
		this.regs = regs;
	}
	
}
