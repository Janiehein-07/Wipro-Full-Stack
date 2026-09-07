package javaCollections;

import java.util.ArrayList;
import java.util.Scanner;

public class OperationsOnStringList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> items = new ArrayList<String>();

        while (true) {

            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter the item to be inserted:");
                    String insertItem = sc.nextLine();

                    items.add(insertItem);

                    System.out.println("Inserted successfully");
                    break;

                case 2:
                    System.out.println("Enter the item to search :");
                    String searchItem = sc.nextLine();

                    if (items.contains(searchItem)) {
                        System.out.println("Item found in the list.");
                    } else {
                        System.out.println("Item not found in the list.");
                    }
                    break;

                case 3:
                    System.out.println("Enter the item to delete :");
                    String deleteItem = sc.nextLine();

                    if (items.remove(deleteItem)) {
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("Item does not exist.");
                    }
                    break;

                case 4:
                    System.out.println("The Items in the list are :");

                    for (String item : items) {
                        System.out.println(item);
                    }
                    break;

                case 5:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }

            System.out.println();
        }
    }
}