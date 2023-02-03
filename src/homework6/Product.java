package homework6;

import java.util.Date;

public class Product {
    private String type;
    private double price;
    private boolean isPossibleDiscount;
    private Date dateAdding;

    public Product(String type, double price, boolean isPossibleDiscount, Date dateAdding) {
        this.type = type;
        this.price = price;
        this.isPossibleDiscount = isPossibleDiscount;
        this.dateAdding = dateAdding;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double setPrice(double price) {
        return this.price = price;
    }

    public boolean isPossibleDiscount() {
        return isPossibleDiscount;
    }

    public Date getDateAdding() {
        return dateAdding;
    }
}
