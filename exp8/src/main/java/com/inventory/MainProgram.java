package com.inventory;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainProgram {

    public static void main(String[] args) {

        // Create SessionFactory
        SessionFactory factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Product.class)
                        .buildSessionFactory();

        // Create DAO
        ProductDAO dao = new ProductDAO(factory);

        try {

            // =========================
            // CREATE / ADD
            // =========================

            Product p1 = new Product(
                    "Laptop",
                    "Electronics",
                    55000,
                    10
            );

            Product p2 = new Product(
                    "Keyboard",
                    "Accessories",
                    1200,
                    25
            );

            dao.addProduct(p1);
            dao.addProduct(p2);


            // =========================
            // READ / VIEW
            // =========================

            System.out.println("\n===== PRODUCT INVENTORY =====");

            List<Product> products = dao.getAllProducts();

            for (Product p : products) {
                System.out.println(p);
            }


            // =========================
            // UPDATE
            // =========================

            System.out.println("\n===== UPDATE =====");

            dao.updateProduct(
                    1,
                    "Dell Laptop",
                    "Electronics",
                    60000,
                    15
            );


            // =========================
            // VIEW AFTER UPDATE
            // =========================

            System.out.println("\n===== AFTER UPDATE =====");

            products = dao.getAllProducts();

            for (Product p : products) {
                System.out.println(p);
            }


            // =========================
            // DELETE
            // =========================

            System.out.println("\n===== DELETE =====");

            dao.deleteProduct(2);


            // =========================
            // FINAL VIEW
            // =========================

            System.out.println("\n===== FINAL INVENTORY =====");

            products = dao.getAllProducts();

            for (Product p : products) {
                System.out.println(p);
            }

        } finally {

            factory.close();
        }
    }
}