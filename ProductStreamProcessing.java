import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private double price;

    // Constructor
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price;
    }

    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1200.00));
        products.add(new Product("Smartphone", "Electronics", 800.00));
        products.add(new Product("Shirt", "Clothing", 50.00));
        products.add(new Product("Jeans", "Clothing", 80.00));
        products.add(new Product("Blender", "Home Appliances", 100.00));
        products.add(new Product("Toaster", "Home Appliances", 30.00));

        // 1. Group products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Grouped Products by Category:");
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // 2. Find the most expensive product in each category
        System.out.println("\nMost Expensive Product in Each Category:");
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, 
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));

        mostExpensiveByCategory.forEach((category, product) -> 
            product.ifPresent(p -> System.out.println(category + ": " + p))
        );

        // 3. Calculate the average price of all products
        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage Price of All Products: $" + averagePrice);
    }
}
