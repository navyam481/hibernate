package com.wipro.hibernate.entities;



public class Employee {
    private Long empId;
    private String empName;

    public Employee() {}

    public Employee(String empName) {
        this.empName = empName;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
