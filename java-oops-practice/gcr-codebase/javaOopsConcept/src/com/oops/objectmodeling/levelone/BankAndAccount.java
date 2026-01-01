package com.oops.objectmodeling.levelone;

import java.util.*;

//Account class (represents a bank account)
class Account {
 private static int nextAccountNumber = 1001;
 private int accountNumber;
 private double balance;
 private Bank bank;

 public Account(Bank bank) {
     this.accountNumber = nextAccountNumber++;
     this.balance = 0.0;
     this.bank = bank;
 }

 public int getAccountNumber() {
     return accountNumber;
 }

 public double getBalance() {
     return balance;
 }

 public Bank getBank() {
     return bank;
 }

 public void deposit(double amount) {
     balance += amount;
 }
}

//Customer class
class Customer {
 private String name;
 private List<Account> accounts;

 public Customer(String name) {
     this.name = name;
     this.accounts = new ArrayList<>();
 }

 public void addAccount(Account account) {
     accounts.add(account);
 }

 // Customer communicates with Account
 public void viewBalance() {
     System.out.println("Balances for " + name + ":");
     for (Account acc : accounts) {
         System.out.println(
             "Bank: " + acc.getBank().getName() +
             ", Account No: " + acc.getAccountNumber() +
             ", Balance: $" + acc.getBalance()
         );
     }
 }

 public String getName() {
     return name;
 }
}

//Bank class
class Bank {
 private String name;
 private List<Customer> customers;

 public Bank(String name) {
     this.name = name;
     this.customers = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 // Bank communicates with Customer
 public Account openAccount(Customer customer) {
     Account account = new Account(this);
     customer.addAccount(account);

     if (!customers.contains(customer)) {
         customers.add(customer);
     }

     System.out.println("Account opened for " + customer.getName() +
                        " at " + name +
                        " (Account No: " + account.getAccountNumber() + ")");
     return account;
 }
}

//Main class
public class BankAndAccount {
 public static void main(String[] args) {

     Bank bank = new Bank("National Bank");

     Customer c1 = new Customer("Alice");
     Customer c2 = new Customer("Bob");

     Account a1 = bank.openAccount(c1);
     Account a2 = bank.openAccount(c1);
     Account a3 = bank.openAccount(c2);

     a1.deposit(500);
     a2.deposit(1200);
     a3.deposit(300);

     c1.viewBalance();
     c2.viewBalance();
 }
}
