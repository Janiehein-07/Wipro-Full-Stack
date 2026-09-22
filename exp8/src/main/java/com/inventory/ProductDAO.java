package com.inventory;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDAO {

    private SessionFactory factory;

    public ProductDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public void addProduct(Product product) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.persist(product);
            session.getTransaction().commit();
            System.out.println("Product added successfully!");
        } finally {
            session.close();
        }
    }

    public List<Product> getAllProducts() {
        Session session = factory.openSession();
        try {
            return session.createQuery("from Product", Product.class)
                    .getResultList();
        } finally {
            session.close();
        }
    }

    public void updateProduct(int id, String name, String category,
                              double price, int quantity) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            Product product = session.get(Product.class, id);

            if (product != null) {
                product.setName(name);
                product.setCategory(category);
                product.setPrice(price);
                product.setQuantity(quantity);
                System.out.println("Product updated successfully!");
            } else {
                System.out.println("Product not found!");
            }

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void deleteProduct(int id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            Product product = session.get(Product.class, id);

            if (product != null) {
                session.remove(product);
                System.out.println("Product deleted successfully!");
            } else {
                System.out.println("Product not found!");
            }

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}