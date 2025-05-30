package com.tca.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tca.entities.StudentCourse;
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

}
