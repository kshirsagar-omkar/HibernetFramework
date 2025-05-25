package com.tca.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="student")
public class Student {

	@Id
	@Column(name="rno")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer rno;
	
	@Column(name="name")
	private String name;
	
	@Column(name="per")
	private Double per;
	
	@Column(name="city")
	private String city;
	
	
	@CreationTimestamp
	@Column(name="created_at")
	private LocalDateTime createdAt;

	
	@UpdateTimestamp
	@Column(name="updated_at")
	private LocalDateTime updatedAt;


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


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
	
	
}
