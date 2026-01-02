package com.oops.inheritance;

//Base class
class Order {
 String orderId;
 String orderDate;

 // Constructor
 Order(String orderId, String orderDate) {
     this.orderId = orderId;
     this.orderDate = orderDate;
 }

 // Method to get order status
 String getOrderStatus() {
     return "Order Placed";
 }
}

//Subclass 1
class ShippedOrder extends Order {
 String trackingNumber;

 // Constructor
 ShippedOrder(String orderId, String orderDate, String trackingNumber) {
     super(orderId, orderDate);
     this.trackingNumber = trackingNumber;
 }

 // Override method
 @Override
 String getOrderStatus() {
     return "Order Shipped (Tracking No: " + trackingNumber + ")";
 }
}

//Subclass 2 (multilevel inheritance)
class DeliveredOrder extends ShippedOrder {
 String deliveryDate;

 // Constructor
 DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
     super(orderId, orderDate, trackingNumber);
     this.deliveryDate = deliveryDate;
 }

 // Override method
 @Override
 String getOrderStatus() {
     return "Order Delivered on " + deliveryDate;
 }
}

//Main class
public class RetailOrderManagement {
 public static void main(String[] args) {
     DeliveredOrder order = new DeliveredOrder(
         "ORD123",
         "2024-01-10",
         "TRK98765",
         "2024-01-15"
     );

     System.out.println("Order ID: " + order.orderId);
     System.out.println("Order Date: " + order.orderDate);
     System.out.println("Status: " + order.getOrderStatus());
 }
}
