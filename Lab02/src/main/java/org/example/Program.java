package org.example;

import java.util.*;
import java.sql.*;

public class Program {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO<>(args);

        while (true) {
            System.out.println("1. Read all products\n" +
                    "2. Read a product by input id\n" +
                    "3. Add a new product\n"  +
                    "4. Update a product\n" +
                    "5. Delete a product by id\n" +
                    "6. Exit"
            );
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    List<Product> products = dao.readAll();
                    if (products.isEmpty()) {
                        System.out.println("No products found");
                    }
                    for (Product product : products) {
                        product.print();
                    }
                    break;

                case 2:
                    System.out.println("Enter product id: ");
                    int id = sc.nextInt();
                    Product p = (Product) dao.read(id);
                    p.print();
                    break;

                case 3:
                    sc.nextLine();
                    System.out.println("Enter product's name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter product's price: ");
                    Double price = sc.nextDouble();
                    System.out.println("Enter product's color: ");
                    String color = sc.next();

                    Product product = new Product(name, price, color);
                    dao.add(product);
                    System.out.println("Product added successfully");
                    break;

                case 4:
                    System.out.println("Enter product id: ");
                    int id_update = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter product name: ");
                    String name_update = sc.nextLine();
                    System.out.println("Enter product price: ");
                    Double price_update = sc.nextDouble();
                    System.out.println("Enter product color: ");
                    String color_update = sc.next();

                    Product p1 = new Product(name_update, price_update, color_update);
                    p1.setId(id_update);

                    boolean result = dao.update(p1);
                    if (result) {
                        System.out.println("Product updated successfully");
                    }
                    else {
                        System.out.println("Please check again the id!");
                    }
                    break;

                case 5:
                    System.out.println("Enter product id: ");
                    int id_delete = sc.nextInt();
                    boolean rs = dao.delete(id_delete);
                    if (rs) {
                        System.out.println("Product deleted successfully");
                    }
                    else {
                        System.out.println("Please check again the id!");
                    }
                    break;

                case 6:
                    System.out.println("Exit program!!");
                    return;

                default:
                    System.out.println("Please enter again!!");
                    break;
            }
        }


    }

}


