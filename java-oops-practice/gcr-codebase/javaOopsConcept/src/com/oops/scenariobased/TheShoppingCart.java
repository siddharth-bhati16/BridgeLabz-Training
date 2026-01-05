package com.oops.scenariobased;

import java.util.ArrayList;
import java.util.List;

interface ICheckout {
    double applyDiscount(double total);
    void generateBill();
}

abstract class Product {
    protected String name;
    protected double price;
    protected String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public abstract double getDiscount(double total);

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

class PerishableProduct extends Product {

    public PerishableProduct(String name, double price) {
        super(name, price, "Perishable");
    }

    public double getDiscount(double total) {
        return total * 0.10; 
    }
}

class NonPerishableProduct extends Product {

    public NonPerishableProduct(String name, double price) {
        super(name, price, "Non-Perishable");
    }

    @Override
    public double getDiscount(double total) {
        return total * 0.05; 
    }
}

class Cart implements ICheckout {

    private List<Product> products;   
    private double totalPrice;         

    public Cart() {
        products = new ArrayList<>();
        totalPrice = 0;
    }

    public Cart(List<Product> products) {
        this.products = products;
        calculateTotal();
    }

    public void addProduct(Product product, int quantity) {
        products.add(product);
        totalPrice += product.getPrice() * quantity; // price * quantity
    }

    private void calculateTotal() {
        totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.getPrice();
        }
    }

    public double applyDiscount(double coupon) {
        double discount = 0;

        for (Product p : products) {
            discount += p.getDiscount(totalPrice);
        }

        totalPrice = totalPrice - discount - coupon; // operator usage
        return totalPrice;
    }

    public void generateBill() {
        System.out.println("----- SwiftCart Bill -----");
        for (Product p : products) {
            System.out.println(p.getName() + " - $" + p.getPrice());
        }
        System.out.println("Total Payable: $" + totalPrice);
    }
}

public class TheShoppingCart {
    public static void main(String[] args) {

        Product milk = new PerishableProduct("Milk", 2.5);
        Product rice = new NonPerishableProduct("Rice", 5.0);

        Cart cart = new Cart();

        cart.addProduct(milk, 2);  
        cart.addProduct(rice, 1);

        cart.applyDiscount(1.0);  
        cart.generateBill();
    }
}
