package org.example.collections;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomSorting {
    public static void main(String[] args) {

        List<Product> productList = productList();

        System.out.println("1. Sort by price (ascending)");
        productList.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);

        System.out.println("\n2. Sort by category, then price ascending");
        productList.stream()
                .sorted(Comparator.comparing(Product::getCategory)
                        .thenComparing(Product::getPrice))
                .forEach(System.out::println);

        System.out.println("\n3. Sort by name (case-insensitive)");
        productList.stream()
                .sorted(Comparator.comparing(p -> p.getProductName().toLowerCase()))
                .forEach(System.out::println);

        System.out.println("\n4. Sort by price descending, then name ascending");
        productList.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed()
                        .thenComparing(Product::getProductName))
                .forEach(System.out::println);

        System.out.println("\n5. Sort by category, nulls last");
        productList.stream()
                .sorted(Comparator.comparing(
                        Product::getCategory,
                        Comparator.nullsLast(String::compareTo)))
                .forEach(System.out::println);

        System.out.println("\n6. Category 'sports' first, then by price");
        productList.stream()
                .sorted(Comparator.comparing((Product p) -> !p.getCategory().equalsIgnoreCase("sports"))
                        .thenComparing(Product::getPrice))
                .forEach(System.out::println);

        System.out.println("\n7. Sort by product name length");
        productList.stream()
                .sorted(Comparator.comparingInt(p -> p.getProductName().length()))
                .forEach(System.out::println);

        System.out.println("\n8. Filter out zero/negative price and sort by price");
        productList.stream()
                .filter(p -> p.getPrice() > 0)
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);

        System.out.println("\n9. Efficient sorting for large lists: use parallelStream()");
        productList.parallelStream()
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);

        System.out.println("\n10. Stream-based sort by price descending");
        List<Product> sortedByStream = productList.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
        sortedByStream.forEach(System.out::println);

        System.out.println("\n11. Custom category order: Book > sports > drawing > others");
        List<String> customOrder = Arrays.asList("Book", "sports", "drawing");
        productList.stream()
                .sorted(Comparator.comparingInt(p ->
                        customOrder.contains(p.getCategory()) ?
                                customOrder.indexOf(p.getCategory()) : Integer.MAX_VALUE))
                .forEach(System.out::println);

        System.out.println("\n12. Generic sort using comparator (e.g. by price)");
        sortBy(productList, Comparator.comparing(Product::getPrice)).forEach(System.out::println);

        System.out.println("\n13. Sort by price with nulls last");
        productListWithNullPrices().stream()
                .sorted(Comparator.comparing(
                        Product::getPrice,
                        Comparator.nullsLast(Double::compareTo)))
                .forEach(System.out::println);

        System.out.println("\n14. Sort products in Map by name");
        Map<Integer, Product> productMap = productList.stream()
                .collect(Collectors.toMap(Product::getProductId, Function.identity()));
        productMap.values().stream()
                .sorted(Comparator.comparing(Product::getProductName))
                .forEach(System.out::println);

        System.out.println("\n15. Sort List<String[]> by price column (index 2)");
        List<String[]> csvProducts = Arrays.asList(
                new String[]{"1001", "Lord of the rings", "1500"},
                new String[]{"1002", "Cricket bat", "3000"},
                new String[]{"1003", "Coloured pencil", "120"}
        );
        csvProducts.stream()
                .sorted(Comparator.comparingDouble(arr -> Double.parseDouble(arr[2])))
                .forEach(arr -> System.out.println(Arrays.toString(arr)));

        System.out.println("\n16. Sort by complex rule (price > 1000 and category = Book)");
        productList.stream()
                .sorted(Comparator.comparing((Product p) ->
                        p.getPrice() > 1000 && "Book".equals(p.getCategory()) ? 0 : 1))
                .forEach(System.out::println);

        System.out.println("\n17. Explain Comparable vs Comparator – See explanation below");
        // → In a real interview, you'd explain this verbally

        System.out.println("\n18. Stable sort: Elements with same price maintain order");
        productList.stream()
                .sorted(Comparator.comparing(Product::getPrice)) // Stable in Java 8+
                .forEach(System.out::println);

        System.out.println("\n19. Return sorted list without modifying original");
        List<Product> sortedCopy = productList.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
        sortedCopy.forEach(System.out::println);

        System.out.println("\n20. Dynamic sort field and direction from UI");
        String field = "price"; // assume frontend sends this
        String direction = "desc";
        Comparator<Product> dynamicComparator = getComparator(field, direction);
        productList.stream().sorted(dynamicComparator).forEach(System.out::println);

        // Bonus Q&A: High-level or system design ones → Verbal

        System.out.println("\n21–25. Refer to notes — answer them during discussions.");
    }

    private static List<Product> sortBy(List<Product> list, Comparator<Product> comparator) {
        return list.stream().sorted(comparator).collect(Collectors.toList());
    }

    private static Comparator<Product> getComparator(String field, String direction) {
        Comparator<Product> comparator = switch (field) {
            case "name" -> Comparator.comparing(Product::getProductName);
            case "price" -> Comparator.comparing(Product::getPrice);
            case "category" -> Comparator.comparing(Product::getCategory);
            default -> Comparator.comparing(Product::getProductId);
        };
        return "desc".equalsIgnoreCase(direction) ? comparator.reversed() : comparator;
    }

    private static List<Product> productList() {
        return Arrays.asList(
                new Product(1001, "Lord of the rings", 1500.0, "Book"),
                new Product(1002, "Coloured pencil", 120.0, "drawing"),
                new Product(1003, "tennis ball", 200.0, "sports"),
                new Product(1004, "Shuttle cork", 150.0, "sports"),
                new Product(1005, "Harry Potter series", 3000.0, "Book"),
                new Product(1006, "Cricket bat", 3000.0, "sports")
        );
    }

    private static List<Product> productListWithNullPrices() {
        return Arrays.asList(
                new Product(1001, "Lord of the rings", null, "Book"),
                new Product(1002, "Coloured pencil", 120.0, "drawing"),
                new Product(1003, "tennis ball", 200.0, "sports")
        );
    }
}
