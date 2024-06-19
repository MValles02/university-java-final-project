package model.Product;

import java.io.Serializable;

public class ElectronicProduct extends Product implements Serializable {
    // Attributes
    private int warrantyYears; // 1 year, 2 years, 3 years, etc.

    // Constructor
    public ElectronicProduct(String name, double price, int stock, int warrantyYears) {
        super(name, price, stock);
        this.warrantyYears = warrantyYears;
    }

    // Getters
    public int getWarrantyYears() {
        return warrantyYears;
    }

    // toString
    @Override
    public String toString() {
        return String.format("| %-20s | %-10.2f | %-5d | %-15s | %-15d | %-10s | %-10s |",
                getName(), getPrice(), getStock(), "N/A", warrantyYears, "N/A", "N/A");
    }
}