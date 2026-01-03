package com.oops.scenariobased;

//Interface (Abstraction)
interface Transferrable {
 void transferTo(User receiver, double amount);
}

//Transaction Class
class Transaction {
 private String type;
 private double amount;

 public Transaction(String type, double amount) {
     this.type = type;
     this.amount = amount;
 }

 public String toString() {
     return type + " : ₹" + amount;
 }
}

//Wallet Class
class Wallet {
 private double balance; // Encapsulation
 protected Transaction[] history = new Transaction[10];
 protected int count = 0;

 // Constructor without referral
 public Wallet() {
     this.balance = 0.0;
 }

 // Constructor with referral bonus
 public Wallet(double referralBonus) {
     this.balance = referralBonus;
     history[count++] = new Transaction("Referral Bonus", referralBonus);
 }

 protected void addMoney(double amount) {
     balance += amount;
     history[count++] = new Transaction("Money Added", amount);
 }

 protected boolean deductMoney(double amount) {
     if (balance >= amount) {
         balance -= amount;
         history[count++] = new Transaction("Money Deducted", amount);
         return true;
     }
     return false;
 }

 // Public getter
 public double getBalance() {
     return balance;
 }

 public void showHistory() {
     for (int i = 0; i < count; i++) {
         System.out.println(history[i]);
     }
 }
}

//User Class
class User {
 private String name;
 protected Wallet wallet;

 public User(String name, Wallet wallet) {
     this.name = name;
     this.wallet = wallet;
 }

 public String getName() {
     return name;
 }

 public Wallet getWallet() {
     return wallet;
 }
}

//Personal Wallet (Inheritance + Polymorphism)
class PersonalWallet extends Wallet implements Transferrable {

 public PersonalWallet(double referralBonus) {
     super(referralBonus);
 }

 @Override
 public void transferTo(User receiver, double amount) {
     double tax = amount * 0.02; // 2% tax
     double total = amount + tax;

     if (deductMoney(total)) {
         receiver.getWallet().addMoney(amount);
         System.out.println("Personal transfer successful (2% tax applied)");
     } else {
         System.out.println("Insufficient balance in personal wallet");
     }
 }
}

//Business Wallet (Inheritance + Polymorphism)
class BusinessWallet extends Wallet implements Transferrable {

 public BusinessWallet(double referralBonus) {
     super(referralBonus);
 }

 @Override
 public void transferTo(User receiver, double amount) {
     double cashback = amount * 0.01; // 1% cashback

     if (deductMoney(amount)) {
         receiver.getWallet().addMoney(amount);
         addMoney(cashback);
         System.out.println("Business transfer successful (1% cashback)");
     } else {
         System.out.println("Insufficient balance in business wallet");
     }
 }
}

//Main Class
public class EwalletApplication {
 public static void main(String[] args) {

     User alice = new User("Alice", new PersonalWallet(100));
     User bob = new User("Bob", new BusinessWallet(200));

     alice.getWallet().addMoney(500);
     bob.getWallet().addMoney(1000);

     // Polymorphism in transfer
     ((Transferrable) alice.getWallet()).transferTo(bob, 200);
     ((Transferrable) bob.getWallet()).transferTo(alice, 300);

     System.out.println("\nAlice Balance: ₹" + alice.getWallet().getBalance());
     System.out.println("Bob Balance: ₹" + bob.getWallet().getBalance());

     System.out.println("\nAlice Transaction History:");
     alice.getWallet().showHistory();
 }
}

