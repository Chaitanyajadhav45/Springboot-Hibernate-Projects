package com.example.employee;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EmployeeApplication {

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeDao theEmployeeDao) {
        return runner -> {
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n===== Employee Management Menu =====");
                System.out.println("1. Add Employee");
                System.out.println("2. Find Employee by ID");
                System.out.println("3. Find Employee by Contact No");
                System.out.println("4. Fetch All Employees");
                System.out.println("5. Update Salary");
                System.out.println("6. Update Designation");
                System.out.println("7. Update Contact Info");
                System.out.println("8. Remove Employee");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 :  {
                        System.out.print("Enter First Name: ");
                        String firstName = sc.nextLine();
                        System.out.print("Enter Last Name: ");
                        String lastName = sc.nextLine();
                        System.out.print("Enter Contact No: ");
                        long contact = sc.nextLong(); sc.nextLine();
                        System.out.print("Enter Designation: ");
                        String designation = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();
                        Employee emp = new Employee(firstName, lastName, contact, designation, salary);
                        theEmployeeDao.save(emp);
                    }
                    case 2 : {
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        Employee emp = theEmployeeDao.findById(id);
                        System.out.println(emp != null ? emp : "Employee not found!");
                    }
                    case 3 : {
                        System.out.print("Enter Contact No: ");
                        long contact = sc.nextLong();
                        Employee emp = theEmployeeDao.findByPhoneNo(contact);
                        System.out.println(emp != null ? emp : "Employee not found!");
                    }
                    case 4 : {
                        List<Employee> employees = theEmployeeDao.fetchAll();
                        employees.forEach(System.out::println);
                    }
                    case 5 : {
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter New Salary: ");
                        double salary = sc.nextDouble();
                        theEmployeeDao.updateSalary(id, salary);
                    }
                    case 6 : {
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Enter New Designation: ");
                        String designation = sc.nextLine();
                        theEmployeeDao.updateDesignation(id, designation);
                    }
                    case 7 :  {
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter New Contact No: ");
                        long contact = sc.nextLong();
                        theEmployeeDao.updateContact(id, contact);
                    }
                    case 8 :{
                        System.out.print("Enter Employee ID to remove: ");
                        int id = sc.nextInt();
                        theEmployeeDao.remove(id);
                    }
                    case 9 : {
                        System.out.println("Exiting...!");
                        return;
                    }
                    default:System.out.println("Invalid choice!");
                }
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }
}
