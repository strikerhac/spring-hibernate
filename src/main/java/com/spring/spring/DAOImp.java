package com.spring.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void savePerson(Person p) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}
	
	public void delPerson(int id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Person person = session.get(Person.class, id);
		session.delete(person);
		session.getTransaction().commit();
	}
	
	public void updatePerson(Person p) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
	}
	
	public Person getPerson(int id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Person person = session.get(Person.class, id);
		session.getTransaction().commit();
		return person;
	}
}
