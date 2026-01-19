package JavaGenerics;

import java.util.ArrayList;
import java.util.List;

interface Category {
    String getName();
}

enum BookCategory implements Category {
    FICTION, EDUCATIONAL, COMICS;

    public String getName() {
        return name();
    }
}

enum ClothingCategory implements Category {
    MEN, WOMEN, KIDS;

    public String getName() {
        return name();
    }
}

enum GadgetCategory implements Category {
    MOBILE, LAPTOP, ACCESSORY;

    public String getName() {
        return name();
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " | Category: " + category.getName() + " | Price: $" + price;
    }
}

class ProductCatalog {
    private List<Product<?>> products = new ArrayList<>();

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public void showCatalog() {
        products.forEach(System.out::println);
    }
}

class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Programming", 500.0, BookCategory.EDUCATIONAL);

        Product<ClothingCategory> shirt =
                new Product<>("T-Shirt", 300.0, ClothingCategory.MEN);

        Product<GadgetCategory> phone =
                new Product<>("Smartphone", 20000.0, GadgetCategory.MOBILE);

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        System.out.println("=== BEFORE DISCOUNT ===");
        catalog.showCatalog();

        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 5);

        System.out.println("\n=== AFTER DISCOUNT ===");
        catalog.showCatalog();
    }
}

