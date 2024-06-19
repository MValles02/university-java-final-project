package interfaces;

import model.Product.Product;

public interface IManagerUtils extends IClientUtils {
    // Interface with additional methods for managers, it extends from Client interface
    String displayProductsByStockLowToHigh();
    String displayProductsByStockHighToLow();
    String displayProductsWithoutStock();
    void addProduct(Product product);
    boolean removeProduct(String name);
    void addStock(Product product, int quantity);
    void removeStock(Product product, int quantity);
    Product getProduct(String name);
}