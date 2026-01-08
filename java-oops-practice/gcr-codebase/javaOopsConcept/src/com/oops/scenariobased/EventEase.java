package com.oops.scenariobased;

interface ISchedulable {
 void schedule();
 void reschedule(String newDate);
 void cancel();
}

class User {
 private String name;
 private String email;

 public User(String name, String email) {
     this.name = name;
     this.email = email;
 }

 public String getName() {
     return name;
 }

 
 public String getEmail() {
     return email;
 }
}

//Base Event Class
class Event implements ISchedulable {
 private static int counter = 1000;

 protected final int eventId; // cannot be modified once assigned
 protected String eventName;
 protected String location;
 protected String date;
 protected int attendees;
 protected User organizer;

 private double venueCost;
 private double serviceCost;
 private double discount;

 public Event(String eventName, String location, String date, int attendees, User organizer, double venueCost) {
     this.eventId = counter++;
     this.eventName = eventName;
     this.location = location;
     this.date = date;
     this.attendees = attendees;
     this.organizer = organizer;
     this.venueCost = venueCost;
     this.serviceCost = 0;
     this.discount = 0;
 }

 public Event(String eventName, String location, String date, int attendees,
              User organizer, double venueCost, double serviceCost, double discount) {
     this.eventId = counter++;
     this.eventName = eventName;
     this.location = location;
     this.date = date;
     this.attendees = attendees;
     this.organizer = organizer;
     this.venueCost = venueCost;
     this.serviceCost = serviceCost;
     this.discount = discount;
 }

 public double calculateTotalCost() {
     return venueCost + serviceCost - discount;
 }

 @Override
 public void schedule() {
     System.out.println("Event scheduled: " + eventName + " on " + date);
 }

 @Override
 public void reschedule(String newDate) {
     this.date = newDate;
     System.out.println("Event rescheduled to " + newDate);
 }

 @Override
 public void cancel() {
     System.out.println("Event cancelled: " + eventName);
 }
}

class BirthdayEvent extends Event {

 public BirthdayEvent(String eventName, String location, String date, int attendees,
                      User organizer, double venueCost, double serviceCost) {
     super(eventName, location, date, attendees, organizer, venueCost, serviceCost, 100);
 }

 @Override
 public void schedule() {
     System.out.println("🎉 Birthday Event scheduled with cake & decorations!");
 }
}

class ConferenceEvent extends Event {

 public ConferenceEvent(String eventName, String location, String date, int attendees,
                        User organizer, double venueCost, double serviceCost) {
     super(eventName, location, date, attendees, organizer, venueCost, serviceCost, 200);
 }

 @Override
 public void schedule() {
     System.out.println("📊 Conference scheduled with speakers & AV setup.");
 }
}

public class EventEase {
 public static void main(String[] args) {

     User user1 = new User("Alice", "alice@email.com");

     Event birthday = new BirthdayEvent(
             "Alice Birthday",
             "Banquet Hall",
             "12-06-2026",
             50,
             user1,
             5000,
             2000
     );

     Event conference = new ConferenceEvent(
             "Tech Conference",
             "Convention Center",
             "25-08-2026",
             300,
             user1,
             20000,
             8000
     );

     birthday.schedule();
     System.out.println("Total Cost: " + birthday.calculateTotalCost());

     conference.schedule();
     System.out.println("Total Cost: " + conference.calculateTotalCost());

     conference.reschedule("30-08-2026");
     birthday.cancel();
 }
}

