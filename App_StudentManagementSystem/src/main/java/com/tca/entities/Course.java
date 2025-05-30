package com.tca.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="course_id")
	private Integer courseId;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="course_code")
	private String courseCode;
	
	@Column(name="credits")
	private Integer credits;


	
	@OneToMany(mappedBy="course", fetch=FetchType.LAZY)
	private List<StudentCourse> enrollments;


	
	

	public Integer getCourseId() {
		return courseId;
	}



	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}



	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public String getCourseCode() {
		return courseCode;
	}



	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}



	public Integer getCredits() {
		return credits;
	}



	public void setCredits(Integer credits) {
		this.credits = credits;
	}



	public List<StudentCourse> getEnrollments() {
		return enrollments;
	}



	public void setEnrollments(List<StudentCourse> enrollments) {
		this.enrollments = enrollments;
	}

}
