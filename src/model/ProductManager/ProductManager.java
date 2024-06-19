package model.ProductManager;

import interfaces.IProductViewer;

import model.Product.Product;

import java.io.Serializable;
import java.util.HashSet;

public class ProductManager implements IProductViewer, Serializable {
    // Attributes
    private HashSet<Product> products;

    // Constructor (gets a HashSet of products from the Main class)
    public ProductManager(HashSet<Product> products) {
        this.products = products;
    }

    // Methods
    public void addProduct(Product product) {
        // Adds a product to the products HashSet
        products.add(product);
    }

    public boolean removeProduct(String name) {
        // Returns true if the product was removed, false otherwise
        return products.removeIf(product -> product.getName().equals(name));
    }

    public void addStock(Product product, int quantity) {
        // Adds stock to a product
        product.setStock(product.getStock() + quantity);
    }

    public void removeStock(Product product, int quantity) {
        // Removes stock from a product
        // If the stock is less than 0, it sets it to 0
        if (product.getStock() - quantity < 0) {
            product.setStock(0);
        } else {
            product.setStock(product.getStock() - quantity);
        }
    }

    @Override
    public Product getProduct(String name) {
        // Returns the product if it exists, null otherwise
        return products.stream().filter(product -> product.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public HashSet<Product> getProducts() {
        // Returns the products HashSet
        return products;
    }

    @Override
    public void setProducts(HashSet<Product> products) {
        // Sets the products HashSet
        this.products = products;
    }
}