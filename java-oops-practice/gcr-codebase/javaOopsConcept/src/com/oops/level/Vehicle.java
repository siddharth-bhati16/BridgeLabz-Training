package com.oops.level;


public class Vehicle 
{
    // Instance Variables
    private String ownerName;
    private String vehicleType;

    
    private static double registrationFee = 1000.0;

    // Constructor
    public Vehicle(String ownerName, String vehicleType) 
    {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance Method to display vehicle details
    public void displayVehicleDetails() 
    {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: Rs. " + registrationFee);
    }

    // Class Method to update registration fee
    public static void updateRegistrationFee(double newFee) 
    {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: Rs." + registrationFee);
    }

    
    public static void main(String[] args) 
    {
        Vehicle vehicle1 = new Vehicle("Han", "Car");
        Vehicle vehicle2 = new Vehicle("Valentino Rossi", "Motorcycle");

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

      
        Vehicle.updateRegistrationFee(1500.0);

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}

