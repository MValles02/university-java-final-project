package model.Product;

import java.io.Serializable;

public abstract class Product implements Serializable {
    // Attributes
    private String name; // Name of the product
    private double price; // Price of the product
    private int stock; // Stock of the product

    // Constructor
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setStock(int stock) {
        this.stock = stock;
    }

    // toString
    @Override
    public String toString() {
        return String.format("| %-20s | %-10.2f | %-5d | %-15s | %-15s | %-10s | %-10s |",
                name, price, stock, "N/A", "N/A", "N/A", "N/A");
    }
}