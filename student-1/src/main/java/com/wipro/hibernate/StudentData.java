package com.wipro.hibernate;

import jakarta.persistence.*;

@Entity  // Mark this as a Hibernate Entity
@Table(name = "student")  // Maps to "student" table in Oracle
public class StudentData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private int rollNumber;

    @Column(name = "name", nullable = false)
    private String name;

    // Constructors
    public StudentData() {}

    public StudentData(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
