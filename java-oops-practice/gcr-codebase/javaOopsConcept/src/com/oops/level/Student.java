package com.oops.level;



class Student 
{
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor
    public Student(int rollNumber, String name, double CGPA) 
    {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to get CGPA
    public double getCGPA() 
    {
        return CGPA;
    }

    // Public method to set CGPA
    public void setCGPA(double CGPA) 
    {
        this.CGPA = CGPA;
    }
}
