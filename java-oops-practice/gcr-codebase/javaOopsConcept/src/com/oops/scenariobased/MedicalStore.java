package com.oops.scenariobased;

import java.time.LocalDate;

interface ISellable {
    double sell(int qty);          
    boolean checkExpiry();         
}

abstract class Medicine implements ISellable {
    private String name;
    private double price;           
    private LocalDate expiryDate;
    private int quantity;           

    public Medicine(String name, double price, LocalDate expiryDate) {
        this(name, price, expiryDate, 10); 
    }

    public Medicine(String name, double price, LocalDate expiryDate, int quantity) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    // private sensitive pricing logic
    private double applyDiscount(double total) {
        if (total > 500) {
            return total * 0.9; 
        }
        return total;
    }

    public double sell(int qty) {
        if (qty > quantity) {
            System.out.println("Insufficient stock for " + name);
            return 0;
        }

        quantity -= qty;                 
        double total = price * qty;     
        total = applyDiscount(total);    

        return total;
    }

    protected LocalDate getExpiryDate() {
        return expiryDate;
    }

    public abstract boolean checkExpiry();
}

class Tablet extends Medicine {
    public Tablet(String name, double price, LocalDate expiryDate, int quantity) {
        super(name, price, expiryDate, quantity);
    }

    // Preserved medicine – longer safe usage
    @Override
    public boolean checkExpiry() {
        return getExpiryDate().isBefore(LocalDate.now());
    }
}

class Syrup extends Medicine {
    public Syrup(String name, double price, LocalDate expiryDate) {
        super(name, price, expiryDate);
    }

    @Override
    public boolean checkExpiry() {
        return getExpiryDate().isBefore(LocalDate.now().minusDays(7));
    }
}

class Injection extends Medicine {
    public Injection(String name, double price, LocalDate expiryDate, int quantity) {
        super(name, price, expiryDate, quantity);
    }

    @Override
    public boolean checkExpiry() {
        return getExpiryDate().isBefore(LocalDate.now().minusDays(3));
    }
}

public class MedicalStore {
    public static void main(String[] args) {

        Medicine tab = new Tablet(
                "Paracetamol",
                5.0,
                LocalDate.of(2026, 1, 1),
                100
        );

        Medicine syrup = new Syrup(
                "Cough Syrup",
                120.0,
                LocalDate.of(2025, 12, 20)
        );

        Medicine inj = new Injection(
                "Insulin",
                250.0,
                LocalDate.of(2025, 10, 1),
                20
        );

        System.out.println("Selling Paracetamol (50 units): Rs." + tab.sell(50));
        System.out.println("Remaining Stock: " + tab.getQuantity());

        System.out.println("Selling Cough Syrup (5 units): Rs." + syrup.sell(5));
        System.out.println("Is Syrup Expired? " + syrup.checkExpiry());

        System.out.println("Selling Injection (3 units): Rs." + inj.sell(3));
        System.out.println("Is Injection Expired? " + inj.checkExpiry());
    }
}
