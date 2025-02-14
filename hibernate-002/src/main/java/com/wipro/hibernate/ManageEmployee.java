package com.wipro.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ManageEmployee {
    public static void main(String[] args) {
    	 Configuration con = new Configuration().addAnnotatedClass(Employee1.class);
         SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory();
         Session session = sf.openSession();
         Transaction tx = session.beginTransaction();

        // Adding Employees
        Employee1 emp1 = new Employee1("Zara", "Ali", 1000);
        Employee1 emp2 = new Employee1("Daisy", "Das", 5000);
        Employee1 emp3 = new Employee1("John", "Paul", 10000);
        
        session.persist(emp1);
        session.persist(emp2);
        session.persist(emp3);
        
        tx.commit();

        // Listing Employees
        listEmployees(session);

        // Updating Employee
        updateEmployee(session, emp1.getId(), 5000);

        // Deleting Employee
        deleteEmployee(session, emp2.getId());

        // Listing Employees after update and delete
        listEmployees(session);
    }

    public static void listEmployees(Session session) {
        Transaction tx = session.beginTransaction();
        List<Employee1> employees = session.createQuery("FROM Employee1", Employee1.class).list();
        for (Employee1 employee : employees) {
            System.out.println("ID: " + employee.getId() + ", Name: " + employee.getFirstName() + " " + employee.getLastName() + ", Salary: " + employee.getSalary());
        }
        tx.commit();
    }

    public static void updateEmployee(Session session, Integer employeeID, int newSalary) {
        Transaction tx = session.beginTransaction();
        Employee1 employee = session.get(Employee1.class, employeeID);
        if (employee != null) {
            employee.setSalary(newSalary);
            session.update(employee);
        }
        tx.commit();
    }

    public static void deleteEmployee(Session session, Integer employeeID) {
        Transaction tx = session.beginTransaction();
        Employee1 employee = session.get(Employee1.class, employeeID);
        if (employee != null) {
            session.delete(employee);
        }
        tx.commit();
    }
}
