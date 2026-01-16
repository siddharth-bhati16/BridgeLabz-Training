package Week1.BookShelf;

import java.util.*;

class Customer {
 String name;
 Map<String, Integer> items; 

 Customer(String name) {
     this.name = name;
     this.items = new HashMap<>();
 }

 void addItem(String item, int quantity) {
     items.put(item, items.getOrDefault(item, 0) + quantity);
 }
}

public class SmartCheckout {

 static Queue<Customer> customerQueue = new LinkedList<>();

 static Map<String, Integer> priceMap = new HashMap<>();
 static Map<String, Integer> stockMap = new HashMap<>();

 static void addCustomer(Customer customer) {
     customerQueue.offer(customer);
     System.out.println(customer.name + " added to queue.");
 }

 static void processCustomer() {
     if (customerQueue.isEmpty()) {
         System.out.println("No customers in queue.");
         return;
     }

     Customer customer = customerQueue.poll();
     int totalBill = 0;

     System.out.println("Processing customer: " + customer.name);

     for (Map.Entry<String, Integer> entry : customer.items.entrySet()) {
         String item = entry.getKey();
         int quantity = entry.getValue();

         if (!priceMap.containsKey(item)) {
             System.out.println("Item not found: " + item);
             continue;
         }

         int availableStock = stockMap.getOrDefault(item, 0);

         if (availableStock < quantity) {
             System.out.println("Insufficient stock for " + item);
             continue;
         }

         int price = priceMap.get(item);
         totalBill += price * quantity;

         stockMap.put(item, availableStock - quantity);
     }

     System.out.println("Total Bill for " + customer.name + ": ₹" + totalBill);
 }

 public static void main(String[] args) {

     priceMap.put("Apple", 50);
     priceMap.put("Milk", 30);
     priceMap.put("Bread", 40);

     stockMap.put("Apple", 10);
     stockMap.put("Milk", 5);
     stockMap.put("Bread", 8);

     Customer c1 = new Customer("Amit");
     c1.addItem("Apple", 2);
     c1.addItem("Milk", 1);

     Customer c2 = new Customer("Neha");
     c2.addItem("Bread", 2);
     c2.addItem("Milk", 2);

     addCustomer(c1);
     addCustomer(c2);

     processCustomer();
     processCustomer();
     processCustomer();
 }
}

