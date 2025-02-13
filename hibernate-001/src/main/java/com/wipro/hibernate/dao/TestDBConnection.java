package com.wipro.hibernate.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";  // Update if needed
        String user = "NAVYASREE";
        String password = "MANIGINTI";

        try {
            Class.forName("oracle.jdbc.OracleDriver");  // Load Oracle Driver
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successful!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
