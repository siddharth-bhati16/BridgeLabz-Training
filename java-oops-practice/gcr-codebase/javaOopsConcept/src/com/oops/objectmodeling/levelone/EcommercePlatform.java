package com.oops.objectmodeling.levelone;

import java.util.ArrayList;
import java.util.List;

// Product class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Order class
class Order {
    private int orderId;
    private List<Product> products; // Aggregation: Order has Products

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to Order " + orderId);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        double total = 0;
        for (Product p : products) {
            System.out.println("- " + p.getName() + " : $" + p.getPrice());
            total += p.getPrice();
        }
        System.out.println("Total: $" + total);
    }
}

// Customer class
class Customer {
    private String name;
    private List<Order> orders; // Aggregation: Customer has Orders

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order ID: " + order.orderId);
    }

    public void showOrders() {
        System.out.println("Orders of " + name + ":");
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}

// Main class to demonstrate
public class EcommercePlatform {
    public static void main(String[] args) {
        // Create Products
        Product p1 = new Product("Laptop", 1200.0);
        Product p2 = new Product("Mouse", 25.0);
        Product p3 = new Product("Keyboard", 45.0);

        // Create Customer
        Customer customer1 = new Customer("Alice");

        // Create Orders and add Products
        Order order1 = new Order(101);
        order1.addProduct(p1);
        order1.addProduct(p2);

        Order order2 = new Order(102);
        order2.addProduct(p2);
        order2.addProduct(p3);

        // Customer places orders
        customer1.placeOrder(order1);
        customer1.placeOrder(order2);

        // Show all orders of the customer
        customer1.showOrders();
    }
}
