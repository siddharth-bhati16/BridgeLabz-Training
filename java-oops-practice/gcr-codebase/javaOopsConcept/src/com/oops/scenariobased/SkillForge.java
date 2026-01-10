package com.oops.scenariobased;

import java.util.*;

interface ICertifiable {
 String generateCertificate();
}

abstract class User {
 protected String name;
 protected String email;

 public User(String name, String email) {
     this.name = name;
     this.email = email;
 }
}

class Instructor extends User {
 public Instructor(String name, String email) {
     super(name, email);
 }

 public void createCourse(Course course) {
     System.out.println("Instructor " + name + " created course: " + course.getTitle());
 }
}

class Student extends User {
 private Map<Course, Integer> courseProgress; 
 public Student(String name, String email) {
     super(name, email);
     courseProgress = new HashMap<>();
 }

 public void enroll(Course course) {
     courseProgress.put(course, 0);
     System.out.println(name + " enrolled in " + course.getTitle());
 }

 public void updateProgress(Course course, int progress) {
     if(courseProgress.containsKey(course)) {
         int current = courseProgress.get(course);
         current += progress;
         if(current > 100) current = 100;
         courseProgress.put(course, current);
         System.out.println(name + "'s progress in " + course.getTitle() + " is now " + current + "%");
     }
 }

 public void completeCourse(Course course) {
     courseProgress.put(course, 100);
     System.out.println(name + " completed " + course.getTitle());
 }

 public int getProgress(Course course) {
     return courseProgress.getOrDefault(course, 0);
 }
}

//Course class
class Course implements ICertifiable {
 private String title;
 private Instructor instructor;
 private double rating; // encapsulated rating
 private List<String> modules;
 
 // Internal reviews (read-only)
 private final List<String> internalReviews;

 // Constructors
 public Course(String title, Instructor instructor) {
     this(title, instructor, new ArrayList<>());
 }

 public Course(String title, Instructor instructor, List<String> modules) {
     this.title = title;
     this.instructor = instructor;
     this.modules = modules;
     this.rating = 0.0;
     this.internalReviews = new ArrayList<>();
 }

 protected void setRating(double rating) {
     if(rating >= 0 && rating <= 5)
         this.rating = rating;
 }

 public double getRating() {
     return rating;
 }

 public String getTitle() {
     return title;
 }

 public void addModule(String module) {
     modules.add(module);
 }

 public void addInternalReview(String review) {
     internalReviews.add(review);
 }

 public List<String> getInternalReviews() {
     return Collections.unmodifiableList(internalReviews); 
 }

 public List<String> getModules() {
     return modules;
 }

 @Override
 public String generateCertificate() {
     if(modules.size() <= 3) {
         return "Certificate of Completion for " + title + " [Beginner Level]";
     } else if(modules.size() <= 6) {
         return "Certificate of Completion for " + title + " [Intermediate Level]";
     } else {
         return "Certificate of Completion for " + title + " [Advanced Level]";
     }
 }
}

public class SkillForge {
 public static void main(String[] args) {
     Instructor alice = new Instructor("Alice", "alice@skillforge.com");
     Student bob = new Student("Bob", "bob@student.com");

     Course javaCourse = new Course("Java Basics", alice, Arrays.asList("OOP", "Classes", "Objects"));
     Course pythonCourse = new Course("Python Advanced", alice);
     pythonCourse.addModule("Decorators");
     pythonCourse.addModule("Generators");
     pythonCourse.addModule("Async");
     pythonCourse.addModule("Testing");
     pythonCourse.addModule("Web Frameworks");

     alice.createCourse(javaCourse);
     alice.createCourse(pythonCourse);

     bob.enroll(javaCourse);
     bob.enroll(pythonCourse);

     bob.updateProgress(javaCourse, 40);
     bob.updateProgress(javaCourse, 30); // simulate operator '+'
     bob.completeCourse(javaCourse);

     javaCourse.setRating(4.5);
     pythonCourse.setRating(4.8);

     System.out.println(javaCourse.getTitle() + " Rating: " + javaCourse.getRating());
     System.out.println(pythonCourse.getTitle() + " Rating: " + pythonCourse.getRating());

     System.out.println(javaCourse.generateCertificate());
     System.out.println(pythonCourse.generateCertificate());

     javaCourse.addInternalReview("Needs more examples on OOP.");
     System.out.println("Internal Reviews: " + javaCourse.getInternalReviews());
 }
}
