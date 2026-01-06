package com.oops.scenariobased;

import java.util.*;

abstract class User {
 protected String name;
 protected String email;
 protected String userId;

 public User(String name, String email, String userId) {
     this.name = name;
     this.email = email;
     this.userId = userId;
 }
}

class Learner extends User {
 public Learner(String name, String email, String userId) {
     super(name, email, userId);
 }
}

class Instructor extends User {
 public Instructor(String name, String email, String userId) {
     super(name, email, userId);
 }
}

interface ICertifiable {
 String generateCertificate();
}

abstract class Course implements ICertifiable {
 protected String courseName;

 public Course(String courseName) {
     this.courseName = courseName;
 }
}

class ShortCourse extends Course {
 public ShortCourse(String courseName) {
     super(courseName);
 }

 @Override
 public String generateCertificate() {
     return "Certificate of Completion: " + courseName;
 }
}

class FullTimeCourse extends Course {
 public FullTimeCourse(String courseName) {
     super(courseName);
 }

 @Override
 public String generateCertificate() {
     return "Professional Diploma Awarded: " + courseName;
 }
}

class Quiz {

 private List<String> questions;

 private final List<String> correctAnswers;

 private int score;
 private String difficulty;

 public Quiz(List<String> questions, List<String> answers, String difficulty) {
     this.questions = questions;
     this.correctAnswers = Collections.unmodifiableList(answers);
     this.difficulty = difficulty;
     this.score = 0;
 }

 public double submitQuiz(List<String> userAnswers) {
     for (int i = 0; i < correctAnswers.size(); i++) {
         if (correctAnswers.get(i).equals(userAnswers.get(i))) {
             score++; // operator usage
         }
     }
     return (score * 100.0) / correctAnswers.size();
 }

 public int getScore() {
     return score;
 }
}

public class EduMentor {
 public static void main(String[] args) {

     Learner learner = new Learner("Alex", "alex@email.com", "L001");

     Quiz quiz = new Quiz(
             Arrays.asList("What is Java?", "What is OOP?"),
             Arrays.asList("Programming Language", "Object Oriented Programming"),
             "Medium"
     );

     double percentage = quiz.submitQuiz(
             Arrays.asList("Programming Language", "Object Oriented Programming")
     );

     System.out.println("Score: " + quiz.getScore());
     System.out.println("Percentage: " + percentage + "%");

     Course shortCourse = new ShortCourse("Java Basics");
     Course fullTimeCourse = new FullTimeCourse("AI Engineering");

     System.out.println(shortCourse.generateCertificate());
     System.out.println(fullTimeCourse.generateCertificate());
 }
}

