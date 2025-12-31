package com.oops.level;

public class CarRental 
{
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double dailyRate = 150.0; 
    
    // Constructor to initialize rental details
    
    public CarRental(String customerName, String carModel, int rentalDays)
    {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total cost
    
    public double calculateTotalCost() 
    {
        return rentalDays * dailyRate;
    }

    
    // Getters for the attributes
    public String getCustomerName()
    {
        return customerName;
    }

    public String getCarModel() 
    {
        return carModel;
    }

    public int getRentalDays() 
    {
        return rentalDays;
    }

    // Main method for testing
    
    public static void main(String[] args) 
    {
        CarRental rental = new CarRental("Han", "Mazda RX-7", 5);
        System.out.println("Customer Name: " + rental.getCustomerName());
        System.out.println("Car Model: " + rental.getCarModel());
        System.out.println("Rental Days: " + rental.getRentalDays());
        System.out.println("Total Cost: $" + rental.calculateTotalCost());
    }
}
