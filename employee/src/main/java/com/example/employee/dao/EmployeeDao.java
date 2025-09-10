package com.example.employee.dao;

import com.example.employee.entity.Employee;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EmployeeDao {

    public void save(Employee theEmployee);

    public Employee findById(int theId);

    public Employee findByPhoneNo(long contactInfo);

    List<Employee> fetchAll();

    @Transactional
    void update(int theId);

    @Transactional
    void remove(int theId);
}
