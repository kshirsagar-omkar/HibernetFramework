package com.tca.dao;

import java.util.List;

import javax.persistence.Query;

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
	
	
	@Override
	public Student findById(Integer id) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			return session.get(Student.class, id);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			session.close();
		}
	}



	@Override
	public List<Student> findByName(String name) {
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			String sql = "FROM Student WHERE name LIKE '%" + name + "%'";
			
			Query query = session.createQuery(sql);
			
			return query.getResultList();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			session.close();
		}
	}


	@Override
	public Integer updateStudent(Student student) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.update(student);
			
			transaction.commit();
			return student.getRno();
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
	
	@Override
	public Integer deleteStudent(Student student) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.delete(student);
			
			transaction.commit();
			return student.getRno();
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
