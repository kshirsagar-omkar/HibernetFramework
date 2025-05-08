package com.tca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;








@Entity
@Table(name="student")


/*======================================== NamedQuery ==========================================*/
/*
@NamedQuery(name="GET_ALL_STUDENTS", query="FROM Student")
@NamedQuery(name="GET_ALL_STUDENTS_CITYWISE", query="FROM Student WHERE city=:inputCity")
*/



/*======================================== NamedQueries ==========================================*/

@NamedQueries(
		value= {
				@NamedQuery(name="GET_ALL_STUDENTS", query="FROM Student"),
				@NamedQuery(name="GET_ALL_STUDENTS_CITYWISE", query="FROM Student WHERE city=:inputCity")
		})




public class Student {
	@Id
	@Column(name="RNO")
	private Integer rno;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PER")
	private Double per;
	
	@Column(name="CITY")
	private String city;
	
	
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	
	
	
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", per=" + per + ", city=" + city + "]";
	}
	
	
	
	
}

