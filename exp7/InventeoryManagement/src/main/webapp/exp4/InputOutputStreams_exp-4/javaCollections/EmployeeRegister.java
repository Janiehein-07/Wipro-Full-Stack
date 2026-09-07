package javaCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeRegister {

    // Employee class
    static class Employee {

        String firstName;
        String lastName;
        String mobile;
        String email;
        String address;

        public Employee(String firstName, String lastName, String mobile,
                        String email, String address) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.mobile = mobile;
            this.email = email;
            this.address = address;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Generic ArrayList to store Employee objects
        ArrayList<Employee> employees = new ArrayList<Employee>();

        System.out.println("Enter the Number of Employees");
        int numberOfEmployees = sc.nextInt();
        sc.nextLine();

        // Get employee details
        for (int i = 1; i <= numberOfEmployees; i++) {

            System.out.println("Enter Employee " + i + " Details:");

            System.out.println("Enter the Firstname");
            String firstName = sc.nextLine();

            System.out.println("Enter the Lastname");
            String lastName = sc.nextLine();

            System.out.println("Enter the Mobile");
            String mobile = sc.nextLine();

            System.out.println("Enter the Email");
            String email = sc.nextLine();

            System.out.println("Enter the Address");
            String address = sc.nextLine();

            Employee employee = new Employee(
                    firstName,
                    lastName,
                    mobile,
                    email,
                    address
            );

            employees.add(employee);
        }

        // Sort employees by First Name
        Collections.sort(employees, new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.firstName.compareTo(e2.firstName);
            }
        });

        // Display employee details
        System.out.println();
        System.out.println("Employee List:");

        System.out.printf(
                "%-15s %-15s %-15s %-30s %-15s%n",
                "FirstName",
                "SecondName",
                "MobileNumber",
                "Email",
                "Address"
        );

        for (Employee employee : employees) {

            System.out.printf(
                    "%-15s %-15s %-15s %-30s %-15s%n",
                    employee.firstName,
                    employee.lastName,
                    employee.mobile,
                    employee.email,
                    employee.address
            );
        }

        sc.close();
    }
}