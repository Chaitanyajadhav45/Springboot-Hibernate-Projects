package com.example.employee.dao.daoimpl;

//Brain of project
import com.example.employee.dao.EmployeeDao;
import com.example.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;

@Repository
//spring wants to know the implementation class for crud so we use @repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager theManager ;


    @Autowired
    public EmployeeDaoImpl(EntityManager theManager) {
        this.theManager = theManager;
    }

    @Override
    @Transactional
    //for adding ,updating , deleting use transactional annotations;
    public void save(Employee theEmployee) {
         theManager.persist(theEmployee);
    }

    @Override
    public Employee findById(int theId)
    {
       return theManager.find(Employee.class,theId);
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
    public List<Employee> fetchAll()
    {
        Query query = theManager.createQuery("Select e from Employee e");
                return query.getResultList();
    };

    @Transactional
    @Override
    public void update(int theId)
    {
        Scanner sc = new Scanner(System.in);

        Employee foundEmployee = theManager.find(Employee.class,theId);

        if (foundEmployee==null)
        {
            System.out.println("No Such Employee exist to update");
        }

        else
        {
            System.out.println("Enter Employee New Salary : ");
            foundEmployee.setSalary(sc.nextDouble());
            System.out.println("Salary updated successfully !");
        }

    }

    @Transactional
    @Override
    public void remove(int theId) {
        Employee foundEmployee = theManager.find(Employee.class, theId);

        if (foundEmployee != null) {
            theManager.remove(foundEmployee); // ✅ pass entity, not ID
            System.out.println("Employee removed successfully !");
        } else {
            System.out.println("No Such Employee found !");
        }
    }

}
