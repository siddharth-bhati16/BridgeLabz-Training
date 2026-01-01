package com.oops.objectmodeling.levelone;

import java.util.*;

//Faculty class (Aggregation: can exist independently)
class Faculty {
 private String name;

 public Faculty(String name) {
     this.name = name;
 }

 public String getName() {
     return name;
 }
}

//University class
class University {
 private String universityName;
 private List<Department> departments;   // Composition
 private List<Faculty> facultyMembers;   // Aggregation

 public University(String universityName) {
     this.universityName = universityName;
     this.departments = new ArrayList<>();
     this.facultyMembers = new ArrayList<>();
 }

 // Aggregation: Faculty can exist without University
 public void addFaculty(Faculty faculty) {
     facultyMembers.add(faculty);
 }

 // Composition: University creates and owns Departments
 public void addDepartment(String deptName) {
     departments.add(new Department(deptName));
 }

 public void showUniversityDetails() {
     System.out.println("University: " + universityName);

     System.out.println("Departments:");
     for (Department d : departments) {
         System.out.println("  " + d.getDepartmentName());
     }

     System.out.println("Faculty Members:");
     for (Faculty f : facultyMembers) {
         System.out.println("  " + f.getName());
     }
 }

 // Composition effect: deleting University deletes Departments
 public void closeUniversity() {
     departments.clear();
     System.out.println("University closed. All departments deleted.");
 }

 // Inner class → Department cannot exist without University
 class Department {
     private String departmentName;

     private Department(String departmentName) {
         this.departmentName = departmentName;
     }

     public String getDepartmentName() {
         return departmentName;
     }
 }
}

//Main class
public class FacultyAndDepartment {
 public static void main(String[] args) {

     // Faculty can exist independently
     Faculty f1 = new Faculty("Dr. Smith");
     Faculty f2 = new Faculty("Dr. Johnson");

     University uni = new University("Global University");

     uni.addFaculty(f1);
     uni.addFaculty(f2);

     uni.addDepartment("Computer Science");
     uni.addDepartment("Mechanical Engineering");

     uni.showUniversityDetails();

     // Deleting University (Composition demonstration)
     uni.closeUniversity();

     // Faculty still exists independently
     System.out.println("Faculty still exists after university closure:");
     System.out.println("  " + f1.getName());
     System.out.println("  " + f2.getName());
 }
}
