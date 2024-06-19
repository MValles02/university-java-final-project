import Exceptions.UserNotFoundException;

import model.Auth.*;
import model.Menu.*;
import model.Product.*;
import model.ProductManager.*;
import model.ShoppingCart.*;
import model.User.*;
import model.Utils.*;

public class Main {
    // Constants
    static final String USERS = "users.bin";
    static final String PRODUCTS = "products.json";
    // Main method
    public static void main(String[] args) {
        // Read products data from PRODUCTS file
        ProductManager products = new ProductManager(JSONUtils.readProducts(PRODUCTS));
        // Read users data from bin file
        Auth auth = new Auth(FILEUtils.readUsers(USERS));
        // Default admin account
        // Email: admin
        // Password: admin
        // Create admin account if not exist
        if (!auth.checkEmail("admin")) {
            Manager admin = new Manager("admin", "admin");
            auth.register(admin);
        }
        // Initialize needed variables
        // Int
        int mainOption;
        int category;
        int quantity;
        // User
        User account = null;
        // String
        String name;
        String email;
        String password;
        // Product
        Product product;
        // Menu
        Menu menu = new Menu();
        do {
            System.out.println();
            mainOption = menu.mainMenu();
            switch (mainOption) {
                case 1:
                    // LogIn verifying the credentials
                    System.out.println();
                    System.out.print("Enter email: ");
                    email = menu.getStringInput();
                    System.out.print("Enter password: ");
                    password = menu.getStringInput();
                    try {
                        account = auth.login(email, password);
                    } catch (UserNotFoundException e) {
                        System.out.println();
                        System.out.println(e.getMessagge());
                    } if (account instanceof Manager accountManager) {
                        // Get the account as Manager and products info through ProductManager
                        System.out.println();
                        System.out.println("Welcome " + accountManager.getEmail() + "!");
                        accountManager.setProductManager(products);
                        // Manager logic...
                        int managerOption;
                        do {
                            System.out.println();
                            managerOption = menu.managerMenu();
                            switch (managerOption) {
                                case 1:
                                    // Add product
                                    System.out.println();
                                    System.out.print("Enter product name: ");
                                    name = menu.getStringInput();
                                    System.out.print("Enter product price: ");
                                    double price = menu.getDoubleInput();
                                    System.out.print("Enter product stock: ");
                                    int stock = menu.getIntInput();
                                    category = menu.selectCategory();
                                    switch (category) {
                                        case 1:
                                            // Add food product
                                            System.out.print("Enter days until expiration: ");
                                            int consumeBefore = menu.getIntInput();
                                            accountManager.addProduct(new FoodProduct(name, price, stock, consumeBefore));
                                            System.out.println();
                                            System.out.println("Product added successfully");
                                            break;
                                        case 2:
                                            // Add electronic product
                                            System.out.print("Enter warranty years: ");
                                            int warrantyYears = menu.getIntInput();
                                            accountManager.addProduct(new ElectronicProduct(name, price, stock, warrantyYears));
                                            System.out.println();
                                            System.out.println("Product added successfully");
                                            break;
                                        case 3:
                                            // Add clothing product
                                            System.out.print("Enter size: ");
                                            String size = menu.getStringInput();
                                            System.out.print("Enter color: ");
                                            String color = menu.getStringInput();
                                            accountManager.addProduct(new ClothingProduct(name, price, stock, size, color));
                                            System.out.println();
                                            System.out.println("Product added successfully");
                                            break;
                                        default:
                                            System.out.println();
                                            System.out.println("Wrong option. Please try again");
                                            break;
                                    }
                                    break;
                                case 2:
                                    // Remove product
                                    System.out.println();
                                    System.out.print("Enter product name: ");
                                    name = menu.getStringInput();
                                    if (accountManager.removeProduct(name)) {
                                        System.out.println();
                                        System.out.println("Product removed successfully");
                                    } else {
                                        System.out.println();
                                        System.out.println("Product not found");
                                    }
                                    break;
                                case 3:
                                    // Add stock
                                    System.out.println();
                                    System.out.print("Enter product name: ");
                                    name = menu.getStringInput();
                                    product = accountManager.getProduct(name);
                                    if (product != null) {
                                        System.out.print("Enter quantity: ");
                                        quantity = menu.getIntInput();
                                        accountManager.addStock(product, quantity);
                                        System.out.println();
                                        System.out.println("Stock added successfully");
                                    } else {
                                        System.out.println();
                                        System.out.println("Product not found");
                                    }
                                    break;
                                case 4:
                                    // Remove stock
                                    System.out.println();
                                    System.out.print("Enter product name: ");
                                    name = menu.getStringInput();
                                    product = accountManager.getProduct(name);
                                    if (product != null) {
                                        System.out.print("Enter quantity: ");
                                        quantity = menu.getIntInput();
                                        accountManager.removeStock(product, quantity);
                                        System.out.println();
                                        System.out.println("Stock removed successfully");
                                    } else {
                                        System.out.println();
                                        System.out.println("Product not found");
                                    }
                                    break;
                                case 5:
                                    // Display options
                                    int displayManagerOption;
                                    do {
                                        System.out.println();
                                        displayManagerOption = menu.displayManagerMenu();
                                        switch (displayManagerOption) {
                                            case 1:
                                                // Display all products
                                                System.out.println();
                                                System.out.println(accountManager.displayProducts());
                                                break;
                                            case 2:
                                                // Display products by category
                                                System.out.println();
                                                category = menu.selectCategory();
                                                switch (category) {
                                                    case 1:
                                                        // Display food products
                                                        System.out.println();
                                                        System.out.println(accountManager.displayCategory("FoodProduct"));
                                                        break;
                                                    case 2:
                                                        // Display electronic products
                                                        System.out.println();
                                                        System.out.println(accountManager.displayCategory("ElectronicProduct"));
                                                        break;
                                                    case 3:
                                                        // Display clothing products
                                                        System.out.println();
                                                        System.out.println(accountManager.displayCategory("ClothingProduct"));
                                                        break;
                                                    default:
                                                        System.out.println("Wrong option. Please try again");
                                                        break;
                                                }
                                                break;
                                            case 3:
                                                // Display products by category A-Z
                                                System.out.println();
                                                System.out.println(accountManager.displayProductsByCategoryAToZ());
                                                break;
                                            case 4:
                                                // Display products by category Z-A
                                                System.out.println();
                                                System.out.println(accountManager.displayProductsByCategoryZToA());
                                                break;
                                            case 5:
                                                // Display products by price low-high
                                                System.out.println();
                                                System.out.println(accountManager.displayProductsByPriceLowToHigh());
                                                break;
                                            case 6:
                                                // Display products by price high-low
                                                System.out.println();
                                                System.out.println(accountManager.displayProductsByPriceHighToLow());
                                                break;
                                            case 7:
                                                // Display products with stock
                                                System.out.println();
                                                System.out.println(accountManager.displayProductsWithStock());
                                                break;
                                            case 8:
                                                // Display products by stock low-high
                                                System.out.println();
                                                System.out.println(accountManager.displayProductsByStockLowToHigh());
                                                break;
                                            case 9:
                                                // Display products by stock high-low
                                                System.out.println();
                                                System.out.println(accountManager.displayProductsByStockHighToLow());
                                                break;
                                            case 10:
                                                // Display products without stock
                                                System.out.println();
                                                System.out.println(accountManager.displayProductsWithoutStock());
                                                break;
                                            case 0:
                                                break;
                                            default:
                                                System.out.println();
                                                System.out.println("Wrong option. Please try again");
                                                break;
                                        }
                                    } while (displayManagerOption != 0);
                                    break;
                                case 0:
                                    // Update products with changes made
                                    products.setProducts(accountManager.getProductManager().getProducts());
                                    System.out.println();
                                    // Set product manager to null
                                    accountManager.setProductManager(null);
                                    accountManager = null;
                                    System.out.println("Logging out...");
                                    break;
                                default:
                                    System.out.println();
                                    System.out.println("Wrong option. Please try again");
                                    break;
                            }
                        } while (managerOption != 0);
                    } else if (account instanceof Client accountClient) {
                        // Get the account as Client and products info through ProductViewer
                        System.out.println();
                        System.out.println("Welcome " + accountClient.getEmail() + "!");
                        accountClient.setProductViewer(products);
                        // Initialize shopping cart
                        ShoppingCart shoppingCart;
                        shoppingCart = new ShoppingCart(products);
                        // Client logic...
                        int clientOption;
                        do {
                            System.out.println();
                            clientOption = menu.clientMenu();
                            switch (clientOption) {
                                case 1:
                                    // Display options
                                    int displayClientOption;
                                    do {
                                        System.out.println();
                                        displayClientOption = menu.displayClientMenu();
                                        switch (displayClientOption) {
                                            case 1:
                                                // Display all products
                                                System.out.println();
                                                System.out.println(accountClient.displayProducts());
                                                break;
                                            case 2:
                                                // Display products by category
                                                System.out.println();
                                                category = menu.selectCategory();
                                                switch (category) {
                                                    case 1:
                                                        // Display food products
                                                        System.out.println();
                                                        System.out.println(accountClient.displayCategory("FoodProduct"));
                                                        break;
                                                    case 2:
                                                        // Display electronic products
                                                        System.out.println();
                                                        System.out.println(accountClient.displayCategory("ElectronicProduct"));
                                                        break;
                                                    case 3:
                                                        // Display clothing products
                                                        System.out.println();
                                                        System.out.println(accountClient.displayCategory("ClothingProduct"));
                                                        break;
                                                    default:
                                                        System.out.println("Wrong option. Please try again");
                                                        break;
                                                }
                                                break;
                                            case 3:
                                                // Display products by category A-Z
                                                System.out.println();
                                                System.out.println(accountClient.displayProductsByCategoryAToZ());
                                                break;
                                            case 4:
                                                // Display products by category Z-A
                                                System.out.println();
                                                System.out.println(accountClient.displayProductsByCategoryZToA());
                                                break;
                                            case 5:
                                                // Display products by price low-high
                                                System.out.println();
                                                System.out.println(accountClient.displayProductsByPriceLowToHigh());
                                                break;
                                            case 6:
                                                // Display products by price high-low
                                                System.out.println();
                                                System.out.println(accountClient.displayProductsByPriceHighToLow());
                                                break;
                                            case 7:
                                                // Display products with stock
                                                System.out.println();
                                                System.out.println(accountClient.displayProductsWithStock());
                                                break;
                                            case 0:
                                                break;
                                            default:
                                                System.out.println();
                                                System.out.println("Wrong option. Please try again");
                                                break;
                                        }
                                    } while (displayClientOption != 0);
                                    break;
                                case 2:
                                    // Add product to cart
                                    System.out.println();
                                    System.out.print("Enter product name: ");
                                    name = menu.getStringInput();
                                    product = shoppingCart.getProductManager().getProduct(name);
                                    if (product != null) {
                                        System.out.print("Enter quantity: ");
                                        quantity = menu.getIntInput();
                                        if (shoppingCart.addToCart(product, quantity)) {
                                            System.out.println();
                                            System.out.println("Product added successfully");
                                        } else {
                                            System.out.println();
                                            System.out.println("Product not available");
                                        }
                                    } else {
                                        System.out.println();
                                        System.out.println("Product not found");
                                    }
                                    break;
                                case 3:
                                    // Remove product from cart
                                    System.out.println();
                                    System.out.print("Enter product name: ");
                                    name = menu.getStringInput();
                                    product = shoppingCart.getProductManager().getProduct(name);
                                    if (product != null) {
                                        System.out.print("Enter quantity: ");
                                        quantity = menu.getIntInput();
                                        if (shoppingCart.removeFromCart(product, quantity)) {
                                            System.out.println();
                                            System.out.println("Product removed successfully");
                                        } else {
                                            System.out.println();
                                            System.out.println("Product not found in the cart");
                                        }
                                    } else {
                                        System.out.println();
                                        System.out.println("Product not found");
                                    }
                                    break;
                                case 4:
                                    // Display cart
                                    System.out.println();
                                    System.out.println(shoppingCart.displayShoppingCart());
                                    break;
                                case 5:
                                    // Checkout
                                    System.out.println();
                                    System.out.println(shoppingCart.displayShoppingCart());
                                    int checkoutOption;
                                    do {
                                        checkoutOption = menu.confirmPurchase();
                                        switch (checkoutOption) {
                                            case 1:
                                                // Confirm purchase
                                                shoppingCart.clear();
                                                System.out.println();
                                                System.out.println("Purchase confirmed");
                                                System.out.println("Thank you for shopping with us");
                                                break;
                                            case 2:
                                                // Cancel purchase
                                                break;
                                            default:
                                                System.out.println();
                                                System.out.println("Wrong option. Please try again");
                                                break;
                                        }
                                    } while (checkoutOption != 1);
                                    break;
                                case 0:
                                    // Update products with changes made
                                    products.setProducts(shoppingCart.getProductManager().getProducts());
                                    System.out.println();
                                    // Set product viewer to null
                                    accountClient.setProductViewer(null);
                                    accountClient = null;
                                    System.out.println("Logging out...");
                                    break;
                                default:
                                    System.out.println();
                                    System.out.println("Wrong option. Please try again");
                                    break;
                            }
                        } while (clientOption != 0);
                    }
                    // Make account null again
                    account = null;
                    break;
                case 2:
                    /// SignUp
                    System.out.println();
                    System.out.print("Enter email: ");
                    email = menu.getStringInput();
                    if (auth.checkEmail(email)) {
                        System.out.println();
                        System.out.println("Email already exist. Please try another or login to your account");
                    } else {
                        System.out.print("Enter password: ");
                        password = menu.getStringInput();
                        Client client = new Client(email, password);
                        auth.register(client);
                        System.out.println();
                        System.out.println("Account created successfully");
                    }
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println();
                    System.out.println("Wrong option. Please try again");
                    break;
            }
        } while (mainOption != 0);

        // Close scanner
        menu.closeScanner();
        // Write changes made to products
        JSONUtils.writeProducts(PRODUCTS, products.getProducts());
        // Write changes made to users
        FILEUtils.writeUsers(USERS, auth.getUsers());
    }
}
