package com.tca.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tca.components.Phone;

@Entity
@Table(name="student")
public class Student {

	
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer studentId;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="email", nullable=false, unique=false)
	private String email;
	
	@Embedded
	@Column(name="phone", nullable=false, unique=false)
	private Phone phone;

	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name="address")
	private String address;

	
	
	
	
	
	
	
	
	@OneToMany(mappedBy="student", fetch=FetchType.LAZY)
	List<StudentCourse> enrollments;
	
	
	
	
	
	
	
	
	
	
	


	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public List<StudentCourse> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<StudentCourse> enrollments) {
		this.enrollments = enrollments;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
