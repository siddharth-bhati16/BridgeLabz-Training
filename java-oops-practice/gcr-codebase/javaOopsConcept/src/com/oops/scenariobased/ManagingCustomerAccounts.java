package com.oops.scenariobased;

//Interface (Abstraction)
interface ITransaction {
 void deposit(double amount);
 void withdraw(double amount);
 double checkBalance();
 double calculateInterest();
}

//Base Account Class
class Account implements ITransaction {
 protected String accountNumber;
 private double balance; // Encapsulation

 // Constructor without opening balance
 public Account(String accountNumber) {
     this.accountNumber = accountNumber;
     this.balance = 0.0;
 }

 // Constructor with opening balance
 public Account(String accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }

 protected void setBalance(double balance) {
     this.balance = balance;
 }

 @Override
 public void deposit(double amount) {
     balance += amount;
 }

 @Override
 public void withdraw(double amount) {
     if (balance >= amount)
         balance -= amount;
     else
         System.out.println("Insufficient Balance");
 }

 @Override
 public double checkBalance() {
     return balance;
 }

 // Default interest (can be overridden)
 @Override
 public double calculateInterest() {
     return 0.0;
 }
}

//Savings Account Class
class SavingsAccount extends Account {
 private double interestRate = 4.0;

 public SavingsAccount(String accountNumber, double balance) {
     super(accountNumber, balance);
 }

 // Polymorphism
 @Override
 public double calculateInterest() {
     return checkBalance() * interestRate / 100; // operator usage
 }
}

//Current Account Class
class CurrentAccount extends Account {
 private double interestRate = 2.0;

 public CurrentAccount(String accountNumber) {
     super(accountNumber);
 }

 // Polymorphism
 @Override
 public double calculateInterest() {
     return checkBalance() * interestRate / 100;
 }
}

//Main Class
public class ManagingCustomerAccounts {
 public static void main(String[] args) {

     ITransaction savings = new SavingsAccount("SB101", 10000);
     ITransaction current = new CurrentAccount("CA201");

     savings.deposit(2000);
     current.deposit(5000);

     System.out.println("Savings Balance: ₹" + savings.checkBalance());
     System.out.println("Savings Interest: ₹" + savings.calculateInterest());

     System.out.println("Current Balance: ₹" + current.checkBalance());
     System.out.println("Current Interest: ₹" + current.calculateInterest());
 }
}

