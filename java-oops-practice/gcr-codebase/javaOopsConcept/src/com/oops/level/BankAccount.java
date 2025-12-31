package com.oops.level;


class BankAccount 
{
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

   
    
    public double getBalance() 
    {
        return balance;
    }

    
    public void deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
        } 
        else
        {
            System.out.println("Deposit amount must be positive.");
        }
    }

    
    public void withdraw(double amount)
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
        } 
        else 
        {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }
}

