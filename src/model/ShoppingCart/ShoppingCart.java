package model.ShoppingCart;

import model.Product.*;
import model.ProductManager.ProductManager;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart<T extends Product> implements Serializable {
    // Attributes
    private Map<T, Integer> shoppingCart; // Products in the shopping cart
    private ProductManager productManager; // Products available in the store

    // Constructor (ProductManager is needed to check if the product is available in the store)
    public ShoppingCart(ProductManager productManager) {
        this.shoppingCart = new HashMap<>();
        this.productManager = productManager;
    }

    // Getters
    public ProductManager getProductManager() {
        return productManager;
    }

    // Methods
    public boolean addToCart(T product, int quantity) {
        // Check if the product is available in the store
        // If it is, add it to the shopping cart
        // If it is already in the shopping cart, update the quantity
        boolean added = false;
        if (product.getStock() >= quantity) {
            if (shoppingCart.containsKey(product)) {
                shoppingCart.put(product, shoppingCart.get(product) + quantity);
            } else {
                shoppingCart.put(product, quantity);
            }
            added = true;
            productManager.removeStock(product, quantity);
        }
        return added;
    }

    public boolean removeFromCart(T product, int quantity) {
        // Check if the product is in the shopping cart
        // If it is, remove it from the shopping cart
        // If the quantity is greater than the one in the shopping cart, remove all of them
        boolean removed = false;
        int auxStock = shoppingCart.get(product).intValue(); // This is needed to add the stock back to the store when the user enters a quantity greater than the stock, because otherwise the stock would be more than the original stock
        if (shoppingCart.containsKey(product)) {
            if (auxStock > quantity) {
                shoppingCart.put(product, shoppingCart.get(product) - quantity);
                productManager.addStock(product, quantity);
            } else {
                shoppingCart.remove(product);
                productManager.addStock(product,auxStock);
            }
            removed = true;
        }
        return removed;
    }

    public double getTotal() {
        // Calculate the total price of the products in the shopping cart
        double total = 0;
        for (Map.Entry<T, Integer> entry : shoppingCart.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public String displayShoppingCart() {
        // Use a StringBuilder to display the products in the shopping cart
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %-20s | %-10s | %-10s |\n", "Product Name", "Quantity", "Total Price"));
        sb.append("+----------------------+------------+------------+\n");
        for (Map.Entry<T, Integer> entry : shoppingCart.entrySet()) {
            double totalPricePerProduct = entry.getKey().getPrice() * entry.getValue();
            sb.append(String.format("| %-20s | %-10d | %-10.2f |\n", entry.getKey().getName(), entry.getValue(), totalPricePerProduct));
        }
        sb.append("+----------------------+------------+------------+\n");
        sb.append(String.format("| %-20s | %-10s | %-10.2f |\n", "Total", "", getTotal()));
        return sb.toString();
    }

    public void clear() {
        // Clear the shopping cart
        shoppingCart.clear();
    }
}
