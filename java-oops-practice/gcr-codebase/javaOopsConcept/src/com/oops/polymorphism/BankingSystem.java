package com.oops.polymorphism;

import java.util.*;

//Interface
interface Loanable {
 void applyForLoan();
 double calculateLoanEligibility();
}

//Abstract class
abstract class BankAccount {
 // Encapsulation: private fields
 private String accountNumber;
 private String holderName;
 protected double balance;

 // Constructor
 public BankAccount(String accountNumber, String holderName, double balance) {
     this.accountNumber = accountNumber;
     this.holderName = holderName;
     this.balance = balance;
 }

 // Getters
 public String getAccountNumber() {
     return accountNumber;
 }

 public String getHolderName() {
     return holderName;
 }

 public double getBalance() {
     return balance;
 }

 // Concrete methods
 public void deposit(double amount) {
     balance += amount;
 }

 public void withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
     } else {
         System.out.println("Insufficient balance");
     }
 }

 // Abstract method
 public abstract double calculateInterest();

 // Display method
 public void displayDetails() {
     System.out.println("Account No: " + accountNumber);
     System.out.println("Holder Name: " + holderName);
     System.out.println("Balance: " + balance);
 }
}

//Savings Account
class SavingsAccount extends BankAccount implements Loanable {

 public SavingsAccount(String accNo, String name, double balance) {
     super(accNo, name, balance);
 }

 // 4% interest
 public double calculateInterest() {
     return balance * 0.04;
 }

 public void applyForLoan() {
     System.out.println("Loan applied from Savings Account");
 }

 public double calculateLoanEligibility() {
     return balance * 5;
 }
}

//Current Account
class CurrentAccount extends BankAccount implements Loanable {

 public CurrentAccount(String accNo, String name, double balance) {
     super(accNo, name, balance);
 }

 // 2% interest
 public double calculateInterest() {
     return balance * 0.02;
 }

 public void applyForLoan() {
     System.out.println("Loan applied from Current Account");
 }

 public double calculateLoanEligibility() {
     return balance * 3;
 }
}

//Main class
public class BankingSystem{
 public static void main(String[] args) {

     // Polymorphism
     List<BankAccount> accounts = new ArrayList<>();

     accounts.add(new SavingsAccount("SA101", "Alice", 50000));
     accounts.add(new CurrentAccount("CA202", "Bob", 80000));

     for (BankAccount acc : accounts) {
         acc.displayDetails();

         double interest = acc.calculateInterest();
         System.out.println("Interest: " + interest);

         Loanable loanAcc = (Loanable) acc;
         loanAcc.applyForLoan();
         System.out.println("Loan Eligibility: " + loanAcc.calculateLoanEligibility());

         System.out.println("--------------------------");
     }
 }
}
