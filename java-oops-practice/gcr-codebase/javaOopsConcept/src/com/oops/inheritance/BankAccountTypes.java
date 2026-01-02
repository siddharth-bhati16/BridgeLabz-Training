package com.oops.inheritance;

//Superclass
class BankAccount {
 String accountNumber;
 double balance;

 // Constructor
 BankAccount(String accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }

 void displayDetails() {
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Balance: $" + balance);
 }
}

//Subclass 1
class SavingsAccount extends BankAccount {
 double interestRate;

 SavingsAccount(String accountNumber, double balance, double interestRate) {
     super(accountNumber, balance);
     this.interestRate = interestRate;
 }

 void displayAccountType() {
     System.out.println("Account Type: Savings Account");
     System.out.println("Interest Rate: " + interestRate + "%");
 }
}

//Subclass 2
class CheckingAccount extends BankAccount {
 double withdrawalLimit;

 CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
     super(accountNumber, balance);
     this.withdrawalLimit = withdrawalLimit;
 }

 void displayAccountType() {
     System.out.println("Account Type: Checking Account");
     System.out.println("Withdrawal Limit: $" + withdrawalLimit);
 }
}

//Subclass 3
class FixedDepositAccount extends BankAccount {
 int lockInPeriod; // in months

 FixedDepositAccount(String accountNumber, double balance, int lockInPeriod) {
     super(accountNumber, balance);
     this.lockInPeriod = lockInPeriod;
 }

 void displayAccountType() {
     System.out.println("Account Type: Fixed Deposit Account");
     System.out.println("Lock-in Period: " + lockInPeriod + " months");
 }
}

//Main class
public class BankAccountTypes{
 public static void main(String[] args) {
     SavingsAccount savings = new SavingsAccount("SA101", 5000, 4.5);
     CheckingAccount checking = new CheckingAccount("CA202", 3000, 1000);
     FixedDepositAccount fixed = new FixedDepositAccount("FD303", 10000, 24);

     savings.displayDetails();
     savings.displayAccountType();
     System.out.println();

     checking.displayDetails();
     checking.displayAccountType();
     System.out.println();

     fixed.displayDetails();
     fixed.displayAccountType();
 }
}
