package com.example.employee.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emp_table_new")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_info")
    private long contactInfo;

    @Column(name = "emp_designation")
    private String designation;

    @Column(name = "salary")
    private double salary;

    public Employee() {}

    public Employee(String firstName, String lastName, long contactInfo,
                    String designation, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
        this.designation = designation;
        this.salary = salary;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public long getContactInfo() { return contactInfo; }
    public void setContactInfo(long contactInfo) { this.contactInfo = contactInfo; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactInfo=" + contactInfo +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
