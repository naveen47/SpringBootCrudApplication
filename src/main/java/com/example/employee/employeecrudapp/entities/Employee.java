package com.example.employee.employeecrudapp.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String designation;
    private float salary;
    private String company;
    
    public Employee() {

    }

    public Employee(Integer id, String name, String designation, float salary, String company) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee [company=" + company + ", designation=" + designation + ", id=" + id + ", name=" + name
                + ", salary=" + salary + "]";
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    
}
