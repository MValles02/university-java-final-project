package model.Utils;

import model.Product.*;

import java.io.FileWriter;
import java.util.HashSet;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
    // This class is used to convert Product objects to JSON objects and vice versa
    public static JSONObject convertToJSONObject(Product product) throws JSONException {
        // This method converts a Product object to a JSON object
        // The JSON object will have the following keys:
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("category", product.getClass().getSimpleName()); // This is the subclass of Product
        jsonObject.put("name", product.getName());
        jsonObject.put("price", product.getPrice());
        jsonObject.put("stock", product.getStock());
        // The following keys are specific to each subclass of Product
        switch (product.getClass().getSimpleName()) {
            case "ClothingProduct":
                ClothingProduct clothingProduct = (ClothingProduct) product;
                jsonObject.put("size", clothingProduct.getSize());
                jsonObject.put("color", clothingProduct.getColor());
                break;
            case "ElectronicProduct":
                ElectronicProduct electronicProduct = (ElectronicProduct) product;
                jsonObject.put("warrantyYears", electronicProduct.getWarrantyYears());
                break;
            case "FoodProduct":
                FoodProduct foodProduct = (FoodProduct) product;
                jsonObject.put("consumeBefore", foodProduct.getConsumeBefore());
                break;
        }
        return jsonObject;
    }

    public static Product convertToProduct(JSONObject jsonObject) throws JSONException {
        // This method converts a JSON object to a Product object
        // The JSON object should have the following
        String category = jsonObject.getString("category");
        String name = jsonObject.getString("name");
        double price = jsonObject.getDouble("price");
        int stock = jsonObject.getInt("stock");
        Product product = null;
        // The following keys are specific to each subclass of Product
        switch (category) {
            case "ClothingProduct":
                String size = jsonObject.getString("size");
                String color = jsonObject.getString("color");
                product = new ClothingProduct(name, price, stock, size, color);
                break;
            case "ElectronicProduct":
                int warrantyYears = jsonObject.getInt("warrantyYears");
                product = new ElectronicProduct(name, price, stock, warrantyYears);
                break;
            case "FoodProduct":
                int consumeBefore = jsonObject.getInt("consumeBefore");
                product = new FoodProduct(name, price, stock, consumeBefore);
                break;
        }
        return product;
    }

    public static HashSet<Product> readProducts(String filePath) {
        // This method reads a JSON file and returns a HashSet of Product objects
        // The JSON file should contain an array of JSON objects
        HashSet<Product> products = new HashSet<>();
        // Read the file and convert the content to a JSONArray
        // Iterate over the JSONArray and convert each JSONObject to a Product object
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Product product = convertToProduct(jsonObject);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void writeProducts(String filePath, HashSet<Product> products) {
        // This method writes a HashSet of Product objects to a JSON file
        // The JSON file will contain an array of JSON objects
        // Read the HashSet and convert each Product object to a JSONObject
        // Iterate over the HashSet and convert each Product object to a JSONObject
        try {
            JSONArray jsonArray = new JSONArray();
            for (Product product : products) {
                JSONObject jsonObject = convertToJSONObject(product);
                jsonArray.put(jsonObject);
            }
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonArray.toString(2)); // The argument is the number of spaces to indent for readability
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}