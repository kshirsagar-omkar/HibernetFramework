package com.tca.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	private Integer cid;
	private String cname;

	
	
	@OneToMany(mappedBy="course", fetch=FetchType.LAZY)
	private List<StudentCourse> regs;



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



	public List<StudentCourse> getRegs() {
		return regs;
	}



	public void setRegs(List<StudentCourse> regs) {
		this.regs = regs;
	}
	
	
	
	
}
