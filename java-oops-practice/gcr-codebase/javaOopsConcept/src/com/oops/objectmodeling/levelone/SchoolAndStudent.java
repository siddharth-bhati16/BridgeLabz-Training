package com.oops.objectmodeling.levelone;

import java.util.*;

//Course class (associated with Student)
class Course {
 private String courseName;
 private List<Student> enrolledStudents;

 public Course(String courseName) {
     this.courseName = courseName;
     this.enrolledStudents = new ArrayList<>();
 }

 public String getCourseName() {
     return courseName;
 }

 // Association: Course ↔ Student
 public void addStudent(Student student) {
     if (!enrolledStudents.contains(student)) {
         enrolledStudents.add(student);
     }
 }

 public void showEnrolledStudents() {
     System.out.println("Students enrolled in " + courseName + ":");
     for (Student s : enrolledStudents) {
         System.out.println("  " + s.getName());
     }
 }
}

//Student class
class Student {
 private String name;
 private List<Course> courses;

 public Student(String name) {
     this.name = name;
     this.courses = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 // Association: Student ↔ Course
 public void enrollCourse(Course course) {
     courses.add(course);
     course.addStudent(this);
 }

 public void viewCourses() {
     System.out.println("Courses enrolled by " + name + ":");
     for (Course c : courses) {
         System.out.println("  " + c.getCourseName());
     }
 }
}

//School class (aggregation with Student)
class School {
 private String schoolName;
 private List<Student> students;

 public School(String schoolName) {
     this.schoolName = schoolName;
     this.students = new ArrayList<>();
 }

 // Aggregation: School has Students
 public void addStudent(Student student) {
     students.add(student);
 }

 public void showStudents() {
     System.out.println("Students in " + schoolName + ":");
     for (Student s : students) {
         System.out.println("  " + s.getName());
     }
 }
}

//Main class
public class SchoolAndStudent {
 public static void main(String[] args) {

     School school = new School("Green Valley School");

     Student s1 = new Student("Alice");
     Student s2 = new Student("Bob");

     school.addStudent(s1);
     school.addStudent(s2);

     Course c1 = new Course("Math");
     Course c2 = new Course("Science");

     s1.enrollCourse(c1);
     s1.enrollCourse(c2);
     s2.enrollCourse(c1);

     s1.viewCourses();
     s2.viewCourses();

     c1.showEnrolledStudents();
     c2.showEnrolledStudents();
 }
}
