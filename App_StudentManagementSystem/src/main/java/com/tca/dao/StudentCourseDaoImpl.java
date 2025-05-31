package com.tca.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tca.entities.StudentCourse;
import com.tca.factory.StudentCourseDaoFactory;
import com.tca.util.HibernateUtil;

public class StudentCourseDaoImpl implements StudentCourseDao{

	@Override
	public Integer EnrollStudentInCourse(StudentCourse enrollment) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Integer id = (Integer) session.save(enrollment);
			
			transaction.commit();
			return id;
		}
		catch(Exception e) {
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
			return null;
		}
	}

	
	
	
	





	@Override
	public Boolean assignGrade(StudentCourse enrollment) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			session.update(enrollment);
			
			transaction.commit();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
			return false;
		}
	}

	
	
	
	
	
	

	@Override
	public List<StudentCourse> findStudent(Integer studentId) {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			String hql = "FROM StudentCourse sc WHERE sc.student.studentId =: studentId";
			
			return session.createQuery(hql).setParameter("studentId", studentId).getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	
	
	
	
	
	
	



	@Override
	public List<StudentCourse> paginationSearchStudentCourse(Integer pageNumber) {
		
		Integer maxResultCount = 3;

		pageNumber *= maxResultCount;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			String hql = "FROM StudentCourse";
			
			return session.createQuery(hql).setMaxResults(maxResultCount).setFirstResult(pageNumber).getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	
	
	
	
	@Override
	public StudentCourse findEnrollmentByStudentIdAndCourseId(Integer studentId, Integer courseId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			String hql = "FROM StudentCourse WHERE student.studentId =: studentId AND course.courseId =: courseId";
			
			return session.createQuery(hql, StudentCourse.class)
					.setParameter("studentId", studentId)
					.setParameter("courseId", courseId)
					.uniqueResultOptional()
					.orElse(null);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}





























}
