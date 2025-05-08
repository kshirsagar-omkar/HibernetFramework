package com.tca.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name="student")

/*

//Single parameter filter

@FilterDef(name="cityFilter", parameters=@ParamDef(name="cityName", type="string"))
@Filter(name="cityFilter", condition="city=:cityName")
*/


//Double parameter filter
@FilterDef( name="perCityFilter", parameters= {
		@ParamDef(name="inputPer", type="double"),
		@ParamDef(name="inputCity", type="string")
} )

@Filter( name="perCityFilter", condition="per >= :inputPer and city = :inputCity" )


public class Student {
	
	@Id
	private Integer rno;
	
	private String name;
	private Double per;
	private String city;
	
	
	
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
