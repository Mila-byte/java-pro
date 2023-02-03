import homework6.Product;
import homework6.ProductManager;
import homework6.exceptions.NoSuchElement;

import java.util.*;

public class Main {
    static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        System.out.println("books worth more than 250:");
        getBooksCertainPrice();
        System.out.println("discount books:");
        getBooksWithDiscount();
        System.out.println("cheapest book:");
        getCheapestBook();
        System.out.println("3 newest products:");
        getNewestProducts();
        System.out.println("calculate products price by filter type, price, date adding:");
        calculateProductsPriceByParameters();
        System.out.println("group products by type:");
        groupProductsByType();
    }

    private static void printProducts(List<Product> products) {
        products.forEach(product -> {
            System.out.println(product.getType() + " " + product.getPrice() + " " + product.getDateAdding());
        });
    }

    private static void getBooksCertainPrice() {
        printProducts(productManager.getBooksCertainPrice());
    }

    private static void getBooksWithDiscount() {
        printProducts(productManager.getBooksWithDiscount());
    }

    private static void getCheapestBook() {
        try {
            System.out.println(productManager.getCheapestBook().getType() + " " + productManager.getCheapestBook().getPrice() + " " + productManager.getCheapestBook().getDateAdding());
        } catch (NoSuchElement e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getNewestProducts() {
        printProducts(productManager.getNewestProducts());
    }

    private static void calculateProductsPriceByParameters() {
        System.out.println(productManager.calculatePrice());
    }

    private static void groupProductsByType() {
        productManager.groupByType().forEach((type, values) -> {
            System.out.println(type + ":");
            values.forEach(value -> {
                System.out.println(value.getType() + " " + value.getPrice() + " " + value.getDateAdding());
            });
        });
    }
}