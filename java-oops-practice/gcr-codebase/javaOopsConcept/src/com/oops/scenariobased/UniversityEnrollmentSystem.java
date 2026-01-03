package com.oops.scenariobased;

//Interface (Abstraction)
interface Graded {
 void assignGrade(String grade);
}

//Course Class
class Course {
 private String courseCode;
 private String courseName;
 private int credits;

 public Course(String courseCode, String courseName, int credits) {
     this.courseCode = courseCode;
     this.courseName = courseName;
     this.credits = credits;
 }

 public int getCredits() {
     return credits;
 }

 public String getCourseName() {
     return courseName;
 }
}

//Base Student Class
class Student {
 protected int studentId;
 protected String name;
 private double gpa; // Encapsulation

 public Student(int studentId, String name) {
     this.studentId = studentId;
     this.name = name;
     this.gpa = 0.0;
 }

 protected void setGpa(double gpa) {
     this.gpa = gpa;
 }

 // Public method to access transcript
 public double getTranscript() {
     return gpa;
 }
}

//Undergraduate Class
class Undergraduate extends Student implements Graded {

 public Undergraduate(int studentId, String name) {
     super(studentId, name);
 }

 // Letter grading
 @Override
 public void assignGrade(String grade) {
     if (grade.equals("A"))
         setGpa(4.0);
     else if (grade.equals("B"))
         setGpa(3.0);
     else if (grade.equals("C"))
         setGpa(2.0);
     else
         setGpa(0.0);
 }
}

//Postgraduate Class
class Postgraduate extends Student implements Graded {

 public Postgraduate(int studentId, String name) {
     super(studentId, name);
 }

 // Pass/Fail grading
 @Override
 public void assignGrade(String grade) {
     if (grade.equalsIgnoreCase("Pass"))
         setGpa(4.0);
     else
         setGpa(0.0);
 }
}

//Faculty Class
class Faculty {
 private String facultyName;

 public Faculty(String facultyName) {
     this.facultyName = facultyName;
 }

 public void gradeStudent(Graded student, String grade) {
     student.assignGrade(grade);
 }
}

//Enrollment Class
class Enrollment {
 private Student student;
 private Course course;

 public Enrollment(Student student, Course course) {
     this.student = student;
     this.course = course;
 }

 public void showEnrollment() {
     System.out.println(student.name + " enrolled in " + course.getCourseName());
 }
}

//Main Class
public class UniversityEnrollmentSystem {
 public static void main(String[] args) {

     Course java = new Course("CS101", "Java Programming", 4);

     Student ug = new Undergraduate(1, "Ananya");
     Student pg = new Postgraduate(2, "Rohit");

     Enrollment e1 = new Enrollment(ug, java);
     Enrollment e2 = new Enrollment(pg, java);

     e1.showEnrollment();
     e2.showEnrollment();

     Faculty faculty = new Faculty("Dr. Sharma");

     // Polymorphism in grading
     faculty.gradeStudent((Graded) ug, "A");
     faculty.gradeStudent((Graded) pg, "Pass");

     // GPA calculation and comparison
     System.out.println("UG GPA: " + ug.getTranscript());
     System.out.println("PG GPA: " + pg.getTranscript());

     if (ug.getTranscript() > pg.getTranscript()) {
         System.out.println("Undergraduate has higher GPA");
     } else {
         System.out.println("Postgraduate has equal or higher GPA");
     }
 }
}

