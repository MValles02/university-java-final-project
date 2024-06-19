package model.User;

import interfaces.IClientUtils;
import interfaces.IProductViewer;

import model.Product.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class Client extends User implements IClientUtils, Serializable {
    // Attributes
    private IProductViewer productViewer;

    // Constructor
    public Client(String email,String password) {
        super(email, password);
        productViewer = null;
    }

    // Setters
    public void setProductViewer(IProductViewer productViewer) {
        this.productViewer = productViewer;
    }

    // @Override methods from IClientUtils
    @Override
    public String displayProducts() {
        // Use a StringBuilder to display all products
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-20s | %-10s | %-5s | %-15s | %-15s | %-10s | %-10s |\n",
                "Name", "Price", "Stock", "Consume Before", "Warranty Years", "Size", "Color"));
        sb.append("|----------------------|------------|-------|-----------------|-----------------|------------|------------|\n");
        for (Product product : productViewer.getProducts()) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String displayCategory(String instance) {
        // Use a StringBuilder to display products depending on their category
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-20s | %-10s | %-5s | %-15s | %-15s | %-10s | %-10s |\n",
                "Name", "Price", "Stock", "Consume Before", "Warranty Years", "Size", "Color"));
        sb.append("|----------------------|------------|-------|-----------------|-----------------|------------|------------|\n");
        for (Product product : productViewer.getProducts()) {
            if (product.getClass().getSimpleName().equals(instance)) {
                sb.append(product.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String displayProductsByCategoryAToZ() {
        // Use a StringBuilder to display products depending on their category, A to Z
        // Create an array of products, then use it to sort the products by category
        // Return the products sorted by category
        ArrayList<Product> products = new ArrayList<>(productViewer.getProducts());
        products.sort((product1, product2) -> product1.getClass().getSimpleName().compareTo(product2.getClass().getSimpleName()));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-20s | %-10s | %-5s | %-15s | %-15s | %-10s | %-10s |\n",
                "Name", "Price", "Stock", "Consume Before", "Warranty Years", "Size", "Color"));
        sb.append("|----------------------|------------|-------|-----------------|-----------------|------------|------------|\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String displayProductsByCategoryZToA() {
        // Use a StringBuilder to display products depending on their category, Z to A
        // Create an array of products, then use it to sort the products by category
        // Return the products sorted by category
        ArrayList<Product> products = new ArrayList<>(productViewer.getProducts());
        products.sort((product1, product2) -> product2.getClass().getSimpleName().compareTo(product1.getClass().getSimpleName()));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-20s | %-10s | %-5s | %-15s | %-15s | %-10s | %-10s |\n",
                "Name", "Price", "Stock", "Consume Before", "Warranty Years", "Size", "Color"));
        sb.append("|----------------------|------------|-------|-----------------|-----------------|------------|------------|\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String displayProductsByPriceLowToHigh() {
        // Use a StringBuilder to display products depending on their price, low to high
        // Create an array of products, then use it to sort the products by price
        // Return the products sorted by price
        ArrayList<Product> products = new ArrayList<>(productViewer.getProducts());
        products.sort((product1, product2) -> Double.compare(product1.getPrice(), product2.getPrice()));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-20s | %-10s | %-5s | %-15s | %-15s | %-10s | %-10s |\n",
                "Name", "Price", "Stock", "Consume Before", "Warranty Years", "Size", "Color"));
        sb.append("|----------------------|------------|-------|-----------------|-----------------|------------|------------|\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String displayProductsByPriceHighToLow() {
        // Use a StringBuilder to display products depending on their price, high to low
        // Create an array of products, then use it to sort the products by price
        // Return the products sorted by price
        ArrayList<Product> products = new ArrayList<>(productViewer.getProducts());
        products.sort((product1, product2) -> Double.compare(product2.getPrice(), product1.getPrice()));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-20s | %-10s | %-5s | %-15s | %-15s | %-10s | %-10s |\n",
                "Name", "Price", "Stock", "Consume Before", "Warranty Years", "Size", "Color"));
        sb.append("|----------------------|------------|-------|-----------------|-----------------|------------|------------|\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String displayProductsWithStock() {
        // Use a StringBuilder to display products with stock
        // Return the products with stock
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-20s | %-10s | %-5s | %-15s | %-15s | %-10s | %-10s |\n",
                "Name", "Price", "Stock", "Consume Before", "Warranty Years", "Size", "Color"));
        sb.append("|----------------------|------------|-------|-----------------|-----------------|------------|------------|\n");
        for (Product product : productViewer.getProducts()) {
            if (product.getStock() > 0) {
                sb.append(product.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}