package homework6;

import homework6.exceptions.NoSuchElement;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductManager {
    Supplier<Stream<Product>> products;

    public ProductManager() {
        addProducts();
    }

    private void addProducts() {
        this.products = () -> Stream.of(
                new Product("book", 55, true, new Date(2023 - 1900, Calendar.MAY, 29)),
                new Product("book", 55, true, new Date(2023 - 1900, Calendar.MAY, 29)),
                new Product("pen", 23, false, new Date(2023 - 1900, Calendar.JUNE, 22)),
                new Product("book", 200, false, new Date(2023 - 1900, Calendar.APRIL, 12)),
                new Product("pencil", 249, true, new Date(2021 - 1900, Calendar.DECEMBER, 4)),
                new Product("toy", 249, true, new Date(2021 - 1900, Calendar.DECEMBER, 4)),
                new Product("book", 313, false, new Date(2022 - 1900, Calendar.JULY, 3)),
                new Product("book", 250, false, new Date(2020 - 1900, Calendar.AUGUST, 5)),
                new Product("toy", 250, false, new Date(2020 - 1900, Calendar.AUGUST, 5)),
                new Product("notebook", 1000, true, new Date(2023 - 1900, Calendar.SEPTEMBER, 15)),
                new Product("book", 432, true, new Date(2020 - 1900, Calendar.OCTOBER, 25)),
                new Product("book", 122, false, new Date(2021 - 1900, Calendar.MARCH, 24)),
                new Product("book", 33, false, new Date(2022 - 1900, Calendar.FEBRUARY, 27)),
                new Product("book", 11.2, true, new Date(2023 - 1900, Calendar.MAY, 29))
        );
    }

    public List<Product> getBooksCertainPrice() {
        int minPrice = 250;
        return products
                .get()
                .filter(product -> product.getType().equalsIgnoreCase("book") && product.getPrice() > minPrice)
                .collect(Collectors.toList());
    }

    public List<Product> getBooksWithDiscount() {
        double discount = 0.1;
        return products
                .get()
                .filter(product -> product.getType().equalsIgnoreCase("book") && product.isPossibleDiscount())
                .peek(book -> book.setPrice(book.getPrice() * (1 - discount)))
                .collect(Collectors.toList());
    }

    public Product getCheapestBook() throws NoSuchElement {
        String searchingCategory = "book";
        return products
                .get()
                .filter(product -> product.getType().equalsIgnoreCase(searchingCategory))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElement("product [type: " + searchingCategory + "] not found"));
    }

    public List<Product> getNewestProducts() {
        return products
                .get()
                .sorted(Comparator.comparing(Product::getDateAdding).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public double calculatePrice() {
        int maxPrice = 75;
        int yearNow = new Date().getYear();
        return products
                .get()
                .filter(product -> product.getType().equalsIgnoreCase("book") && product.getPrice() < maxPrice && product.getDateAdding().getYear() == yearNow)
                .mapToDouble(Product::getPrice).sum();
    }

    public Map<String, List<Product>> groupByType() {
        return products
                .get()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
