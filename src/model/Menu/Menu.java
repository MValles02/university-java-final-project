package model.Menu;

import java.util.Scanner;

public class Menu {
    // Attributes
    private Scanner scanner;

    // Constructor
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    // Menus
    public int mainMenu() {
        System.out.println("+----------------------------------------+");
        System.out.println("+         VALLOVAL's SUPERMARKET         +");
        System.out.println("+----------------------------------------+");
        System.out.println("+ 1. Log in                              +");
        System.out.println("+ 2. Sign up                             +");
        System.out.println("+ 0. Exit                                +");
        System.out.println("+----------------------------------------+");
        System.out.print("Enter an option: ");
        return getIntInput();
    }

    public int managerMenu() {
        System.out.println("+----------------------------------------+");
        System.out.println("+         VALLOVAL's SUPERMARKET         +");
        System.out.println("+----------------------------------------+");
        System.out.println("+ 1. Add product                         +");
        System.out.println("+ 2. Remove product                      +");
        System.out.println("+ 3. Add stock                           +");
        System.out.println("+ 4. Remove stock                        +");
        System.out.println("+ 5. Display options                     +");
        System.out.println("+ 0. Log out                             +");
        System.out.println("+----------------------------------------+");
        System.out.print("Enter an option: ");
        return getIntInput();
    }

    public int displayManagerMenu() {
        System.out.println("+----------------------------------------+");
        System.out.println("+         VALLOVAL's SUPERMARKET         +");
        System.out.println("+----------------------------------------+");
        System.out.println("+ 1. Display products                    +");
        System.out.println("+ 2. Display category                    +");
        System.out.println("+ 3. Display products by category A-Z    +");
        System.out.println("+ 4. Display products by category Z-A    +");
        System.out.println("+ 5. Display products by price low-high  +");
        System.out.println("+ 6. Display products by price high-low  +");
        System.out.println("+ 7. Display products with stock         +");
        System.out.println("+ 8. Display products by stock low-high  +");
        System.out.println("+ 9. Display products by stock high-low  +");
        System.out.println("+ 10. Display products without stock     +");
        System.out.println("+ 0. Back                                +");
        System.out.println("+----------------------------------------+");
        System.out.print("Enter an option: ");
        return getIntInput();
    }

    public int clientMenu() {
        System.out.println("+----------------------------------------+");
        System.out.println("+         VALLOVAL's SUPERMARKET         +");
        System.out.println("+----------------------------------------+");
        System.out.println("+ 1. Display options                     +");
        System.out.println("+ 2. Add product to cart                 +");
        System.out.println("+ 3. Remove product from cart            +");
        System.out.println("+ 4. Display cart                        +");
        System.out.println("+ 5. Checkout                            +");
        System.out.println("+ 0. Log out                             +");
        System.out.println("+----------------------------------------+");
        System.out.print("Enter an option: ");
        return getIntInput();
    }

    public int displayClientMenu() {
        System.out.println("+----------------------------------------+");
        System.out.println("+         VALLOVAL's SUPERMARKET         +");
        System.out.println("+----------------------------------------+");
        System.out.println("+ 1. Display products                    +");
        System.out.println("+ 2. Display category                    +");
        System.out.println("+ 3. Display products by category A-Z    +");
        System.out.println("+ 4. Display products by category Z-A    +");
        System.out.println("+ 5. Display products by price low-high  +");
        System.out.println("+ 6. Display products by price high-low  +");
        System.out.println("+ 7. Display products with stock         +");
        System.out.println("+ 0. Back                                +");
        System.out.println("+----------------------------------------+");
        System.out.print("Enter an option: ");
        return getIntInput();
    }

    public int confirmPurchase() {
        System.out.println("+ 1. Yes");
        System.out.println("+ 2. No");
        System.out.print("Confirm purchase: ");
        return getIntInput();
    }

    public int selectCategory() {
        System.out.println("+ 1. Food");
        System.out.println("+ 2. Electronics");
        System.out.println("+ 3. Clothes");
        System.out.print("Select a category: ");
        return getIntInput();
    }

    // Methods
    public int getIntInput() {
        // This method is used to get an integer input from the user
        // It also manages the case if the user enters other than an integer
        int input;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            input = -1;
        }
        scanner.nextLine(); // This line is used to clear the buffer
        return input;
    }

    public String getStringInput() {
        // This method is used to get a string input from the user
        // It also manages the case if the user enters other than a string
        String input;
        try {
            input = scanner.nextLine();
        } catch (Exception e) {
            input = "";
        }
        return input;
    }

    public double getDoubleInput() {
        // This method is used to get a double input from the user
        // It also manages the case if the user enters other than a double
        double input;
        try {
            input = scanner.nextDouble();
        } catch (Exception e) {
            input = -1;
        }
        scanner.nextLine(); // This line is used to clear the buffer
        return input;
    }

    public void closeScanner() {
        scanner.close();
    }
}