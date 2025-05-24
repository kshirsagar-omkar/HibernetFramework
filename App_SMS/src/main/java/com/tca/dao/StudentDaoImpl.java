package com.tca.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tca.entities.Student;
import com.tca.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public Integer saveStudent(Student student) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Integer id = (Integer) session.save(student);
			
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
		finally {
			session.close();
		}
		
	}

}
