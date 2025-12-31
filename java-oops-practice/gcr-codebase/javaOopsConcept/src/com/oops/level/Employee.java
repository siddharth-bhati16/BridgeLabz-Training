package com.oops.level;

public class Employee 
{

   
    public int employeeID;
    protected String department;
    private double salary;

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    
    public double getSalary() 
    {
        return salary;
    }

    
    public void setSalary(double salary) 
    {
        if (salary > 0) 
        {
            this.salary = salary;
        }
    }

  
    public void incrementSalary(double amount)
    {
        if (amount > 0) 
        {
            salary += amount;
        }
    }
}
