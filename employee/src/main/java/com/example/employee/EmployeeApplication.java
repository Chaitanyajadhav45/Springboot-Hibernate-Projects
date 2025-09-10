//package com.example.employee;
//
//import com.example.employee.dao.MoviesDao;
//import com.example.employee.entity.Movies;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import java.util.Scanner;
//
//@SpringBootApplication
//public class EmployeeApplication {
//
//    @Bean
//    public CommandLineRunner commandLineRunner(MoviesDao moviesDao) {
//        return runner -> {
//            Scanner sc = new Scanner(System.in);
//
//            System.out.print("How Many Movies You Want to Add: ");
//            int add = sc.nextInt();
//            sc.nextLine(); // consume newline
//
//            for (int i = 0; i < add; i++) {
//                System.out.println("Enter The Movie Name: ");
//                String name = sc.nextLine();
//
//                System.out.println("Enter Director: ");
//                String director = sc.nextLine();
//
//                System.out.println("Enter Movie Budget: ");
//                double budget = sc.nextDouble();
//                sc.nextLine(); // consume newline
//
//                System.out.println("Enter Duration: ");
//                String duration = sc.nextLine();
//
//                // ✅ Save Movie
//                moviesDao.save(new Movies(name, director, budget, duration));
//                System.out.println("Movie Saved Successfully!");
//            }
//        };
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(EmployeeApplication.class, args);
//    }
//}
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
//            System.out.println("Enter Employee First Name");
//            String firstName = sc.nextLine();
//
//            System.out.println("Enter Employee Last Name");
//            String lastName = sc.nextLine();
//
//            System.out.println("Enter Employee Contact No.");
//            long contact = sc.nextLong();
//            sc.nextLine();
//
//            System.out.println("Enter Employee Designation");
//            String design = sc.nextLine();
//
//            System.out.println("Enter Employee Salary");
//            double salary = sc.nextDouble();
//            sc.nextLine();
//
//            theEmployeeDao.save(new Employee(firstName, lastName, contact, design, salary));
//            System.out.println("Employee Saved SuccessFully!!");
//
//
//            System.out.println("Enter The Employee ID To Fetch : ");
//            Employee byId = theEmployeeDao.findById(sc.nextInt());
//            if (byId!=null){
//                System.out.println(byId);
//                System.out.println("Employee Found !");
//            }
//            else{
//                System.out.println("Employee Not Found !");
//            }
//
//            System.out.println("Enter The Employee Contact Number : ");
//            Employee byContact = theEmployeeDao.findByPhoneNo(sc.nextLong());
//            if (byContact!=null){
//                System.out.println(byContact);
//                System.out.println("Employee Contact Found !");
//            }
//            else{
//                System.out.println("Employee Contact Not Found !");
//            }

//            List<Employee> employees = theEmployeeDao.fetchAll();
//            for (Employee emp : employees)
//            {
//                System.out.println(emp);
//            }

//            System.out.println("Enter employee Id whose salary to be updated : ");
//            theEmployeeDao.update(sc.nextInt());

            System.out.print("Enter employee Id to be removed : ");
            theEmployeeDao.remove(sc.nextInt());

        };
    }


	public static void main(String[] args) {

        SpringApplication.run(EmployeeApplication.class, args);
	}

}
