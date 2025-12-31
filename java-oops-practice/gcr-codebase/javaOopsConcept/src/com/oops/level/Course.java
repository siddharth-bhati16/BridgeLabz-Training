package com.oops.level;


public class Course 
{
    // Instance Variables
    private String courseName;
    private int duration; 
    private double fee;

   
    private static String instituteName;

  
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance Method to display course details
    public void displayCourseDetails() 
    {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: Rs. " + fee);
        System.out.println("Institute Name: " + instituteName);
    }

    // Class Method to update institute name
    public static void updateInstituteName(String newInstituteName) 
    {
        instituteName = newInstituteName;
    }

    
    public static void main(String[] args) 
    {
        
        Course.updateInstituteName("BridgeLabz");

        // Create course instances
        Course course1 = new Course("Java full stack Programming", 12, 500.0);
        Course course2 = new Course("Agentic AI", 10, 25000.0);

        // Display course details
        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
    }
}
