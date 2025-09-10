package com.example.employee.dao;

import com.example.employee.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    void save(Employee theEmployee);

    Employee findById(int theId);

    Employee findByPhoneNo(long contactInfo);

    List<Employee> fetchAll();

    void updateSalary(int theId, double newSalary);

    void updateDesignation(int theId, String newDesignation);

    void updateContact(int theId, long newContact);

    void remove(int theId);
}
