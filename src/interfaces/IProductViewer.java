package interfaces;

import model.Product.Product;

import java.util.HashSet;

public interface IProductViewer {
    // Interface that limits the access of Client to the ProductManager class.
    // It is used to get the products from the ProductManager class and be able to see the stock without being able to access to manager functions.
    HashSet<Product> getProducts();
    void setProducts(HashSet<Product> products);
    Product getProduct(String name);
}