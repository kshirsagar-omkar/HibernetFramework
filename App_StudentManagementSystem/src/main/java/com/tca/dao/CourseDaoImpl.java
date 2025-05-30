package com.tca.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tca.entities.Course;
import com.tca.util.HibernateUtil;

public class CourseDaoImpl implements CourseDao{

	@Override
	public Integer saveCourse(Course course) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = sf.openSession();
			transaction = session.beginTransaction();			
			
			Integer id = (Integer)session.save(course);
			
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
	public Course findCourse(Integer id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();

		try(Session session = sf.openSession()) {
			return session.get(Course.class, id);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
}
