package com.oops.scenariobased;

import java.util.Random;

interface IInteractable {
 void feed();
 void play();
 void sleep();
}

abstract class Pet {
 protected String name;
 protected String type;
 protected int age;

 private int hunger; 
 private int energy; 
 private int mood;   

 protected Random random = new Random();

 public Pet(String name, String type, int age) {
     this.name = name;
     this.type = type;
     this.age = age;
     this.hunger = random.nextInt(40) + 30;
     this.energy = random.nextInt(40) + 30;
     this.mood = random.nextInt(40) + 30;
 }

 // Encapsulated modifiers
 protected void increaseEnergy(int value) {
     energy = Math.min(100, energy + value);
 }

 protected void decreaseEnergy(int value) {
     energy = Math.max(0, energy - value);
 }

 protected void increaseMood(int value) {
     mood = Math.min(100, mood + value);
 }

 protected void decreaseHunger(int value) {
     hunger = Math.max(0, hunger - value);
 }

 protected void increaseHunger(int value) {
     hunger = Math.min(100, hunger + value);
 }

 public void showStatus() {
     System.out.println(name + " (" + type + ")");
     System.out.println("Age: " + age);
     System.out.println("Hunger: " + hunger);
     System.out.println("Energy: " + energy);
     System.out.println("Mood: " + mood);
     System.out.println("--------------------");
 }

 public abstract void makeSound();
}

class Dog extends Pet implements IInteractable {

 public Dog(String name, int age) {
     super(name, "Dog", age);
 }

 public void feed() {
     decreaseHunger(20);
     increaseMood(10);
 }

 public void play() {
     decreaseEnergy(15);
     increaseMood(20);
     increaseHunger(10);
 }

 public void sleep() {
     increaseEnergy(30);
 }

 public void makeSound() {
     System.out.println(name + " says: Woof! Woof!");
 }
}

class Cat extends Pet implements IInteractable {

 public Cat(String name, int age) {
     super(name, "Cat", age);
 }

 public void feed() {
     decreaseHunger(15);
     increaseMood(5);
 }

 public void play() {
     decreaseEnergy(10);
     increaseMood(15);
     increaseHunger(5);
 }

 public void sleep() {
     increaseEnergy(40);
 }

 public void makeSound() {
     System.out.println(name + " says: Meow!");
 }
}

//Bird class
class Bird extends Pet implements IInteractable {

 public Bird(String name, int age) {
     super(name, "Bird", age);
 }

 public void feed() {
     decreaseHunger(10);
     increaseMood(10);
 }

 public void play() {
     decreaseEnergy(5);
     increaseMood(20);
 }

 public void sleep() {
     increaseEnergy(25);
 }

 public void makeSound() {
     System.out.println(name + " says: Tweet Tweet!");
 }
}

public class PetpalVirtualCareApp{
 public static void main(String[] args) {

     Pet dog = new Dog("Buddy", 3);
     Pet cat = new Cat("Whiskers", 2);
     Pet bird = new Bird("Sky", 1);

     dog.makeSound();
     ((IInteractable) dog).play();
     dog.showStatus();

     cat.makeSound();
     ((IInteractable) cat).feed();
     cat.showStatus();

     bird.makeSound();
     ((IInteractable) bird).sleep();
     bird.showStatus();
 }
}
