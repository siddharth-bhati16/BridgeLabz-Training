package com.oops.objectmodeling.levelone;

import java.util.*;

//Company class (owns Departments)
class Company {
 private String companyName;
 private List<Department> departments;

 public Company(String companyName) {
     this.companyName = companyName;
     this.departments = new ArrayList<>();
 }

 // Company creates and owns Departments
 public void addDepartment(String deptName) {
     departments.add(new Department(deptName));
 }

 public void showCompanyDetails() {
     System.out.println("Company: " + companyName);
     for (Department d : departments) {
         d.showDepartmentDetails();
     }
 }

 // When Company is destroyed, Departments & Employees are destroyed
 public void closeCompany() {
     departments.clear(); // removes all departments and employees
     System.out.println("Company closed. All departments and employees removed.");
 }

 // Inner Department class (cannot exist without Company)
 class Department {
     private String departmentName;
     private List<Employee> employees;

     private Department(String departmentName) {
         this.departmentName = departmentName;
         this.employees = new ArrayList<>();
     }

     // Department creates and owns Employees
     public void addEmployee(String empName) {
         employees.add(new Employee(empName));
     }

     public void showDepartmentDetails() {
         System.out.println("  Department: " + departmentName);
         for (Employee e : employees) {
             System.out.println("    Employee: " + e.getName());
         }
     }

     // Inner Employee class (cannot exist without Department)
     class Employee {
         private String name;

         private Employee(String name) {
             this.name = name;
         }

         public String getName() {
             return name;
         }
     }
 }

 // Helper method to add employees easily
 public void addEmployeeToDepartment(String deptName, String empName) {
     for (Department d : departments) {
         if (d.departmentName.equals(deptName)) {
             d.addEmployee(empName);
         }
     }
 }
}

//Main class
public class CompanyAndDepartment {
 public static void main(String[] args) {

     Company company = new Company("Tech Solutions");

 }
}
