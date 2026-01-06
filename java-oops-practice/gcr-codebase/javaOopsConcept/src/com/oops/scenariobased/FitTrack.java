package com.oops.scenariobased;

import java.util.*;

interface ITrackable {
 void startWorkout();
 void stopWorkout();
}

class UserProfile {
 private String name;
 private int age;
 private double weight; 
 private double dailyCalorieGoal;

 public UserProfile(String name, int age, double weight) {
     this.name = name;
     this.age = age;
     this.weight = weight;
     this.dailyCalorieGoal = 2000; // default
 }

 public UserProfile(String name, int age, double weight, double goal) {
     this.name = name;
     this.age = age;
     this.weight = weight;
     this.dailyCalorieGoal = goal;
 }

 public double getWeight() {
     return weight;
 }

 public double getDailyCalorieGoal() {
     return dailyCalorieGoal;
 }

 public String getName() {
     return name;
 }

 public void setWeight(double weight) {
     if (weight > 0) {
         this.weight = weight;
     }
 }
}

class Workout implements ITrackable {
 protected String type;
 protected int duration; 
 protected double caloriesBurned;
 
 private static List<String> workoutLogs = new ArrayList<>();

 public Workout(String type, int duration) {
     this.type = type;
     this.duration = duration;
     this.caloriesBurned = 0;
 }

 @Override
 public void startWorkout() {
     System.out.println(type + " workout started!");
 }

 @Override
 public void stopWorkout() {
     System.out.println(type + " workout stopped!");
     logWorkout();
 }

 private void logWorkout() {
     workoutLogs.add(type + " - " + duration + " mins - " + caloriesBurned + " cal");
 }

 public double calculateCalories() {
     caloriesBurned = duration * 5;
     return caloriesBurned;
 }

 public static void showLogs() {
     System.out.println("Workout Logs:");
     for (String log : workoutLogs) {
         System.out.println(log);
     }
 }
}

class CardioWorkout extends Workout {
 public CardioWorkout(int duration) {
     super("Cardio", duration);
 }

 @Override
 public double calculateCalories() {
     caloriesBurned = duration * 8;
     return caloriesBurned;
 }
}

class StrengthWorkout extends Workout {
 public StrengthWorkout(int duration) {
     super("Strength", duration);
 }

 @Override
 public double calculateCalories() {
     caloriesBurned = duration * 6;
     return caloriesBurned;
 }
}

public class FitTrack {
 public static void main(String[] args) {

     UserProfile user1 = new UserProfile("John", 25, 70);
     UserProfile user2 = new UserProfile("Alice", 30, 60, 1800);

     Workout cardio = new CardioWorkout(30);
     Workout strength = new StrengthWorkout(45);

     cardio.startWorkout();
     strength.startWorkout();

     double cardioCalories = cardio.calculateCalories();
     double strengthCalories = strength.calculateCalories();

     cardio.stopWorkout();
     strength.stopWorkout();

     double remainingCaloriesUser1 = user1.getDailyCalorieGoal() - (cardioCalories + strengthCalories);
     double remainingCaloriesUser2 = user2.getDailyCalorieGoal() - cardioCalories;

     System.out.println(user1.getName() + " burned " + (cardioCalories + strengthCalories) + " cal. Remaining: " + remainingCaloriesUser1);
     System.out.println(user2.getName() + " burned " + cardioCalories + " cal. Remaining: " + remainingCaloriesUser2);

     Workout.showLogs();
 }
}
