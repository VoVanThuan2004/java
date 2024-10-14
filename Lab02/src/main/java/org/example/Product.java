package org.example;

public class Product {
    private int id;
    private String name;
    private double price;
    private String color;

    public Product(String name, double price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public void print() {
        System.out.println("ID: " + id + " Name: " + name + " Price: " + price + " Color: " + color);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}
