package com.tca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="rno")
	private Integer rno;
	
	@Column(name="name", nullable=false)
	private String name;
	
	
	//Error cause because of this columnDefinition ... when the hbm2ddl = create
	@Column(name = "per", columnDefinition = "CHECK(per >= 0 AND per <= 100)")
	private Double per;
	
	@Column(name="email", length=50, unique=true)
	private String email;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	
	
	
}
