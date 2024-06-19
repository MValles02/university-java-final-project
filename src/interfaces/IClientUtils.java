package interfaces;

public interface IClientUtils {
    // Interface with methods that are used by the client
    String displayProducts();
    String displayCategory(String instance);
    String displayProductsByCategoryAToZ();
    String displayProductsByCategoryZToA();
    String displayProductsByPriceLowToHigh();
    String displayProductsByPriceHighToLow();
    String displayProductsWithStock();
}