package com.oops.scenariobased;

interface IBookable {
 void book();
 void cancel();
}

class Transport {
 private double cost;

 public Transport(double cost) {
     this.cost = cost;
 }

 public double getCost() {
     return cost;
 }
}

class Hotel {
 private double cost;

 public Hotel(double cost) {
     this.cost = cost;
 }

 public double getCost() {
     return cost;
 }
}

class Activity {
 private double cost;

 public Activity(double cost) {
     this.cost = cost;
 }

 public double getCost() {
     return cost;
 }
}

class Trip implements IBookable {
 protected String destination;
 protected int duration;
 protected double budget;

 protected Transport transport;
 protected Hotel hotel;
 protected Activity activity;

 public Trip(String destination, int duration,
             Transport transport, Hotel hotel, Activity activity) {

     this.destination = destination;
     this.duration = duration;
     this.transport = transport;
     this.hotel = hotel;
     this.activity = activity;

     this.budget = transport.getCost() + hotel.getCost() + activity.getCost();
 }

 @Override
 public void book() {
     System.out.println("Booking generic trip to " + destination);
 }

 @Override
 public void cancel() {
     System.out.println("Trip to " + destination + " has been cancelled.");
 }

 public void showDetails() {
     System.out.println("Destination: " + destination);
     System.out.println("Duration: " + duration + " days");
     System.out.println("Total Budget: $" + budget);
 }
}

class DomesticTrip extends Trip {

 public DomesticTrip(String destination, int duration,
                     Transport transport, Hotel hotel, Activity activity) {
     super(destination, duration, transport, hotel, activity);
 }

 @Override
 public void book() {
     System.out.println("Booking Domestic Trip to " + destination);
     System.out.println("ID proof required.");
 }
}

class InternationalTrip extends Trip {

 public InternationalTrip(String destination, int duration,
                          Transport transport, Hotel hotel, Activity activity) {
     super(destination, duration, transport, hotel, activity);
 }

 @Override
 public void book() {
     System.out.println("Booking International Trip to " + destination);
     System.out.println("Passport and Visa required.");
 }
}

public class TourMate {
 public static void main(String[] args) {

     Transport transport = new Transport(500);
     Hotel hotel = new Hotel(800);
     Activity activity = new Activity(300);

     Trip domesticTrip = new DomesticTrip(
             "Goa", 5, transport, hotel, activity);

     Trip internationalTrip = new InternationalTrip(
             "Paris", 7, transport, hotel, activity);

     domesticTrip.book();
     domesticTrip.showDetails();

     System.out.println();

     internationalTrip.book();
     internationalTrip.showDetails();
 }
}

