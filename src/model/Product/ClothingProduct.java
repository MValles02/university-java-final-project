package model.Product;

import java.io.Serializable;

public class ClothingProduct extends Product implements Serializable {
    // Attributes
    private String size; // XS, S, M, L, XL, etc.
    private String color; // Black, White, Red, Blue, etc.

    // Constructor
    public ClothingProduct(String name, double price, int stock, String size, String color) {
        super(name, price, stock);
        this.size = size;
        this.color = color;
    }

    // Getters
    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    // toString
    @Override
    public String toString() {
        return String.format("| %-20s | %-10.2f | %-5d | %-15s | %-15s | %-10s | %-10s |",
                getName(), getPrice(), getStock(), "N/A", "N/A", size, color);
    }
}