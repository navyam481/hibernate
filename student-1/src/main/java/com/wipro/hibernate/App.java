package com.wipro.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	 public static void main(String[] args) {
	        // Get Hibernate Session
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        // Start Transaction
	        Transaction transaction = session.beginTransaction();

	        // Create Student object
	        StudentData student = new StudentData("Navyasree");

	        // Save to database
	        session.save(student);

	        // Commit and close session
	        transaction.commit();
	        session.close();

	        System.out.println("Student inserted successfully!");

	        // Close the Hibernate session factory when the application ends
	        HibernateUtil.getSessionFactory().close();
	 }
}
