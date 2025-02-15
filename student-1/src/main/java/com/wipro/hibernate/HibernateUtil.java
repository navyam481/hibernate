package com.wipro.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .setProperty("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver")
                    .setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe")
                    .setProperty("hibernate.connection.username", "NAVYASREE")
                    .setProperty("hibernate.connection.password", "MANIGINTI")
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect") // Fix deprecated dialect warning
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.show_sql", "true")
                    .addAnnotatedClass(StudentData.class) // 🔥 Register entity
                    .buildSessionFactory();
        } catch (Exception ex) {
            throw new RuntimeException("SessionFactory creation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
