package com.oops.polymorphism;

//EmployeeManagementSystem.java

import java.util.*;

//Interface
interface Department {
 void assignDepartment(String departmentName);
 String getDepartmentDetails();
}

//Abstract class
abstract class Employee implements Department {
 // Encapsulated fields
 private int employeeId;
 private String name;
 protected double baseSalary;
 private String department;

 // Constructor
 public Employee(int employeeId, String name, double baseSalary) {
     this.employeeId = employeeId;
     this.name = name;
     this.baseSalary = baseSalary;
 }

 // Getters and Setters (Encapsulation)
 public int getEmployeeId() {
     return employeeId;
 }

 public String getName() {
     return name;
 }

 public double getBaseSalary() {
     return baseSalary;
 }

 public void setBaseSalary(double baseSalary) {
     this.baseSalary = baseSalary;
 }

 // Interface methods
 @Override
 public void assignDepartment(String departmentName) {
     this.department = departmentName;
 }

 @Override
 public String getDepartmentDetails() {
     return department;
 }

 // Abstract method
 public abstract double calculateSalary();

 // Concrete method
 public void displayDetails() {
     System.out.println("ID: " + employeeId);
     System.out.println("Name: " + name);
     System.out.println("Department: " + department);
     System.out.println("Salary: " + calculateSalary());
     System.out.println("---------------------------");
 }
}

//Full-time employee
class FullTimeEmployee extends Employee {

 public FullTimeEmployee(int employeeId, String name, double fixedSalary) {
     super(employeeId, name, fixedSalary);
 }

 @Override
 public double calculateSalary() {
     return baseSalary; // fixed monthly salary
 }
}

//Part-time employee
class PartTimeEmployee extends Employee {
 private int hoursWorked;
 private double hourlyRate;

 public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
     super(employeeId, name, 0);
     this.hourlyRate = hourlyRate;
     this.hoursWorked = hoursWorked;
 }

 @Override
 public double calculateSalary() {
     return hourlyRate * hoursWorked;
 }
}

//Main class
public class EmployeeManagementSystem {
 public static void main(String[] args) {

     // Polymorphism: Employee reference
     List<Employee> employees = new ArrayList<>();

     Employee e1 = new FullTimeEmployee(101, "Alice", 50000);
     Employee e2 = new PartTimeEmployee(102, "Bob", 500, 40);

     e1.assignDepartment("HR");
     e2.assignDepartment("IT");

     employees.add(e1);
     employees.add(e2);

     // Processing employees polymorphically
     for (Employee emp : employees) {
         emp.displayDetails();
     }
 }
}
