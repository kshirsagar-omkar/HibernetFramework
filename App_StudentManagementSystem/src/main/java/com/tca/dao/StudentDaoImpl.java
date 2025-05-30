package com.tca.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tca.entities.Student;
import com.tca.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public Integer saveStudent(Student student) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			Integer id = (Integer) session.save(student);
			
			transaction.commit();
			return id;
			
		}catch(Exception e) {
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
			return null;
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Student> fetchAllStudent() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();

		try(Session session = sf.openSession()){
						
			return session.createQuery("FROM Student").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Boolean updateStudent(Student student) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = null;
		Transaction transaction = null;
		
		try{
		
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			session.update(student);
			
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
			return false;
		}
	}
	
	@Override
	public Boolean deleteStudent(Student student) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = null;
		Transaction transaction = null;
		
		try{
		
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			session.delete(student);
			
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
			return false;
		}
	}

	@Override
	public Student findStudent(Integer id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();

		try(Session session = sf.openSession()) {
			return session.get(Student.class, id);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
