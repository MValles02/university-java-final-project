package model.Product;

import java.io.Serializable;

public class FoodProduct extends Product implements Serializable {
    // Attributes
    private int consumeBefore; // Days before the product expires

    // Constructor
    public FoodProduct(String name, double price, int stock, int consumeBefore) {
        super(name, price, stock);
        this.consumeBefore = consumeBefore;
    }

    // Getters
    public int getConsumeBefore() {
        return consumeBefore;
    }

    // toString
    @Override
    public String toString() {
        return String.format("| %-20s | %-10.2f | %-5d | %-15d | %-15s | %-10s | %-10s |",
                getName(), getPrice(), getStock(), consumeBefore, "N/A", "N/A", "N/A");
    }
}