import java.util.*;
import java.util.stream.*;

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Electronics", "Laptop", 85000),
            new Product("Electronics", "Smartphone", 55000),
            new Product("Furniture", "Chair", 4000),
            new Product("Furniture", "Table", 7000),
            new Product("Grocery", "Rice", 60),
            new Product("Grocery", "Oil", 120),
            new Product("Electronics", "TV", 60000)
        );

        // Group by category
        System.out.println("--- Products Grouped by Category ---");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        grouped.forEach((cat, list) -> {
            System.out.println(cat + ": " + list);
        });

        // Find most expensive product
        System.out.println("\nMost Expensive Product:");
        products.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .ifPresent(System.out::println);

        // Average price per category
        System.out.println("\n--- Average Price per Category ---");
        Map<String, Double> avgPrice = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));
        avgPrice.forEach((cat, avg) -> System.out.println(cat + ": " + avg));
    }
}
