package com.example.employee.dao.daoimpl;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager theManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager theManager) {
        this.theManager = theManager;
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        theManager.persist(theEmployee);
        System.out.println("Employee saved successfully!");
    }

    @Override
    public Employee findById(int theId) {
        return theManager.find(Employee.class, theId);
    }

    @Override
    public Employee findByPhoneNo(long contactNo) {
        var results = theManager.createQuery(
                        "select e from Employee e where e.contactInfo = :contactInfo", Employee.class)
                .setParameter("contactInfo", contactNo)
                .getResultList();

        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public List<Employee> fetchAll() {
        Query query = theManager.createQuery("Select e from Employee e");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateSalary(int theId, double newSalary) {
        Employee emp = theManager.find(Employee.class, theId);
        if (emp != null) {
            emp.setSalary(newSalary);
            theManager.merge(emp);
            System.out.println("Salary updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    @Override
    @Transactional
    public void updateDesignation(int theId, String newDesignation) {
        Employee emp = theManager.find(Employee.class, theId);
        if (emp != null) {
            emp.setDesignation(newDesignation);
            theManager.merge(emp);
            System.out.println("Designation updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    @Override
    @Transactional
    public void updateContact(int theId, long newContact) {
        Employee emp = theManager.find(Employee.class, theId);
        if (emp != null) {
            emp.setContactInfo(newContact);
            theManager.merge(emp);
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    @Override
    @Transactional
    public void remove(int theId) {
        Employee emp = theManager.find(Employee.class, theId);
        if (emp != null) {
            theManager.remove(emp);
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("No such employee found!");
        }
    }
}
