package InputOutputStreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static String fileName = "employees.txt";

    public static void main(String[] args) {

        while (true) {

            System.out.println("Main Menu");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    displayAll();
                    break;

                case 3:
                    System.out.println("Exiting the System");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
            System.out.println();
        }
    }

    public static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        try {
            FileWriter writer = new FileWriter(fileName, true);

            writer.write(id + " " + name + " " + age + " " + salary);
            writer.write(System.lineSeparator());

            writer.close();

        } catch (IOException e) {
            System.out.println("Error while storing employee details.");
        }
    }

    public static void displayAll() {

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            System.out.println("----Report----");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("----End of Report----");

            reader.close();

        } catch (IOException e) {
            System.out.println("No employee records found.");
        }
    }
}