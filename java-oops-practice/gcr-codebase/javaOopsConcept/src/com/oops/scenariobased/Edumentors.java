package com.oops.scenariobased;

import java.util.*;

interface ICertifiable {
 void generateCertificate();
}

class User {
 protected String name;
 protected String email;
 protected int userId;

 public User(String name, String email, int userId) {
     this.name = name;
     this.email = email;
     this.userId = userId;
 }
}

class Learner extends User implements ICertifiable {
 private String courseType; 

 public Learner(String name, String email, int userId, String courseType) {
     super(name, email, userId);
     this.courseType = courseType;
 }

 public void generateCertificate() {
     if (courseType.equalsIgnoreCase("short")) {
         System.out.println("Short Course Certificate generated for " + name);
     } else {
         System.out.println("Full-Time Course Certificate generated for " + name);
     }
 }
}

class Instructor extends User {

 public Instructor(String name, String email, int userId) {
     super(name, email, userId);
 }

 public void createCourse() {
     System.out.println("Instructor " + name + " created a course.");
 }
}

class Quiz {
 private List<String> questions;
 private final List<String> answers; 
 private int score;

 public Quiz(String difficulty) {
     questions = new ArrayList<>();
     answers = new ArrayList<>();
     score = 0;

     if (difficulty.equalsIgnoreCase("easy")) {
         questions.add("What is Java?");
         answers.add("Programming Language");
     } else if (difficulty.equalsIgnoreCase("medium")) {
         questions.add("Explain OOP concepts.");
         answers.add("Encapsulation Inheritance Polymorphism Abstraction");
     } else {
         questions.add("Explain JVM architecture.");
         answers.add("ClassLoader Memory ExecutionEngine");
     }
 }

 public void evaluateQuiz(List<String> userAnswers) {
     for (int i = 0; i < userAnswers.size() && i < answers.size(); i++) {
         if (userAnswers.get(i).equalsIgnoreCase(answers.get(i))) {
             score += 10; // + operator
         }
     }
 }

 public double getPercentage() {
     return (score * 100.0) / (answers.size() * 10); 
 }
}

public class Edumentors {
 public static void main(String[] args) {

     Learner learner = new Learner("Alice", "alice@gmail.com", 101, "short");
     Instructor instructor = new Instructor("Dr. Smith", "smith@gmail.com", 201);

     instructor.createCourse();

     Quiz quiz = new Quiz("easy");

     List<String> userAnswers = new ArrayList<>();
     userAnswers.add("Programming Language");

     quiz.evaluateQuiz(userAnswers);

     System.out.println("Quiz Percentage: " + quiz.getPercentage() + "%");

     learner.generateCertificate();
 }
}
