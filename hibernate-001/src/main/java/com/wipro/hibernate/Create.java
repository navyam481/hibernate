package com.wipro.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class Create 
{
    public static void main( String[] args )
    {
        Employee emp = new Employee();
        emp.setEmpId(111L);
        emp.setEmpName("Navyasree");
        
        /**
         * First we have to add dependencies to create the below object and everything 
         * Configuration --> it is class 
         * 		buildSessionFactory() --> return type is "SessionFactory" like that SessionFactory object created
         * SessionFactory , Session --> both are interfaces
         */
        Configuration con = new Configuration().addAnnotatedClass(Employee.class);
        SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        
        
        Transaction tx = session.beginTransaction();
        
        /**
         * Because of this one line : we need to write JDBC 7 steps code to store / to perform crud operations with DB
         * This single "save(object)" can store data into DB 
         */
        session.save(emp);
        
        tx.commit();
    }
}



