package com.aubrey.hibernate1;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DAO {
	private static SessionFactory factory;

	private static void setupFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			;
		}
		Configuration configuration = new Configuration();
		// modify these to match your XML files
		configuration.configure("hibernate.cfg.xml");
		configuration.addResource("book.hbm.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static int addBook(Book p) {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		// save this specific record
		int i = (Integer) hibernateSession.save(p);
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return i;
	}

	public static List<Book> getAllBooks() {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		List<Book> books = hibernateSession.createQuery("FROM Book").list();
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return books;
	}
	 /* Method to DELETE an employee from the records */
	   public static Book deleteBook(Integer rank){
		   if (factory == null)
				setupFactory();
			Session hibernateSession = factory.openSession();
			hibernateSession.getTransaction().begin();
			 Book b = (Book)hibernateSession.get(Book.class, rank);
			hibernateSession.delete(b);
			hibernateSession.getTransaction().commit();
			hibernateSession.close();
			return b;
	      }
}