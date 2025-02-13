package com.wipro.hibernate.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wipro.hibernate.entities.Employee;
import com.wipro.hibernate.utilities.SessionFactoryProvider;

public class Create {
    public static void main(String[] args) {
        Transaction t = null;
        try (SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
             Session session = sessionFactory.openSession()) {

            t = session.beginTransaction();

            Employee emp = new Employee("John");
            session.save(emp); // Using session.save() as we rely on XML mapping

            t.commit();
            System.out.println("Employee record inserted successfully, ID: " + emp.getEmpId());

        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }
    }
}
