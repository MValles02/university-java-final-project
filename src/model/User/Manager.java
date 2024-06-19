package model.User;

import interfaces.IManagerUtils;

import model.Product.Product;
import model.ProductManager.ProductManager;

import java.io.Serializable;
import java.util.ArrayList;

public class Manager extends User implements Serializable, IManagerUtils {
    // Attributes
    private ProductManager productManager;

    // Constructor
    public Manager(String email, String password) {
        super(email, password);
        productManager = null;
    }

    // Getters
    public ProductManager getProductManager() {
        return productManager;
    }

    // Setters
    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    // Override methods from IManagerUtils
    @Override
    public String displayProductsByStockLowToHigh() {
        // Use a StringBuilder to display products depending on their stock, low to high
        // Create an array of products, then use it to sort the products by stock
        // Return the products sorted by stock
        StringBuilder sb = new StringBuilder();
        ArrayList<Product> products = new ArrayList<>(productManager.getProducts());
        products.sort((p1, p2) -> p1.getStock() - p2.getStock());
        sb.append(String.format("| %-20s | %-10s | %-5s | %-15s | %-15s | %-10s | %-10s |\n",
                "Name", "Price", "Stock", "Consume Before", "Warranty Years", "Size", "Color"));
        sb.append("|----------------------|------------|-------|-----------------|-----------------|------------|------------|\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String displayProductsByStockHighToLow() {
        // Use a StringBuilder to display products depending on their stock, high to low
        // Create an array of products, then use it to sort the products by stock
        // Return the products sorted by stock
        StringBuilder sb = new StringBuilder();
        ArrayList<Product> products = new ArrayList<>(productManager.getProducts());
        products.sort((p1, p2) -> p2.getStock() - p1.getStock());
        sb.append(String.format("| %-20s | %-10s | %-5s | %-15s | %-15s | %-10s | %-10s |\n",
                "Name", "Price", "Stock", "Consume Before", "Warranty Years", "Size", "Color"));
        sb.append("|----------------------|------------|-------|-----------------|-----------------|------------|------------|\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String displayProductsWithoutStock() {
        // Use a StringBuilder to display products without stock
        // Return the products without stock
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-20s | %-10s | %-5s | %-15s | %-15s | %-10s | %-10s |\n",
                "Name", "Price", "Stock", "Consume Before", "Warranty Years", "Size", "Color"));
        sb.append("|----------------------|------------|-------|-----------------|-----------------|------------|------------|\n");
        for (Product product : productManager.getProducts()) {
            if (product.getStock() == 0) {
                sb.append(product.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public void addProduct(Product product) {
        // Add a product to the product manager
        productManager.addProduct(product);
    }

    @Override
    public boolean removeProduct(String name) {
        // Remove a product from the product manager
        return productManager.removeProduct(name);
    }

    @Override
    public void addStock(Product product, int quantity) {
        // Add stock to a product
        productManager.addStock(product, quantity);
    }

    @Override
    public void removeStock(Product product, int quantity) {
        // Remove stock from a product
        productManager.removeStock(product, quantity);
    }

    @Override
    public Product getProduct(String name) {
        // Get a product from the product manager
        return productManager.getProduct(name);
    }

    // @Override methods from IClientUtils
    @Override
    public String displayProducts() {
        // Use a StringBuilder to display all products
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-20s | %-10s | %-5s | %-15s | %-15s | %-10s | %-10s |\n",
                "Name", "Price", "Stock", "Consume Before", "Warranty Years", "Size", "Color"));
        sb.append("|----------------------|------------|-------|-----------------|-----------------|------------|------------|\n");
        for (Product product : productManager.getProducts()) {
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
        for (Product product : productManager.getProducts()) {
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
        ArrayList<Product> products = new ArrayList<>(productManager.getProducts());
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
        ArrayList<Product> products = new ArrayList<>(productManager.getProducts());
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
        ArrayList<Product> products = new ArrayList<>(productManager.getProducts());
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
        ArrayList<Product> products = new ArrayList<>(productManager.getProducts());
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
        for (Product product : productManager.getProducts()) {
            if (product.getStock() > 0) {
                sb.append(product.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}