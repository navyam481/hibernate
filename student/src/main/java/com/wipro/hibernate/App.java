package com.wipro.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Students Data");
        
        Student student1 = new Student();
        student1.setStudentId(11);
        student1.setStudentName("Navyasree");
        student1.setMarks(87);
        
        /**
         * First we have to add dependencies to create the below object and everything 
         * Configuration --> it is class 
         * 		buildSessionFactory() --> return type is "SessionFactory" like that SessionFactory object created
         * SessionFactory , Session --> both are interfaces
         */
        Configuration con = new Configuration().addAnnotatedClass(Student.class);
        SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        session.save(student1);
        
        Transaction tx = session.beginTransaction();
        
        /**
         * Because of this one line : we need to write JDBC 7 steps code to store / to perform crud operations with DB
         * This single "save(object)" can store data into DB 
         */

        tx.commit();
    }
}
