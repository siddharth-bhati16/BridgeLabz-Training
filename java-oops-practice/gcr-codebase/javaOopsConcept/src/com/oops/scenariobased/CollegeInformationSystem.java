package com.oops.scenariobased;

import java.util.ArrayList;
import java.util.List;

// Base class
class Person {
    protected String name;
    protected String email;
    protected int id;

    public Person(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public void printDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
    }
}

// Interface for course actions
interface ICourseActions {
    void enrollCourse(Course course);
    void dropCourse(Course course);
}

// Student class
class Student extends Person implements ICourseActions {
    private List<Course> courses;
    private List<Double> grades; // private as required

    public Student(String name, String email, int id) {
        super(name, email, id);
        courses = new ArrayList<>();
        grades = new ArrayList<>();
    }

    @Override
    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
            grades.add(0.0); // initialize grade to 0
        }
    }

    @Override
    public void dropCourse(Course course) {
        int index = courses.indexOf(course);
        if (index >= 0) {
            courses.remove(index);
            grades.remove(index);
            course.removeStudent(this);
        }
    }

    public void setGrade(Course course, double grade) {
        int index = courses.indexOf(course);
        if (index >= 0) {
            grades.set(index, grade);
        }
    }

    public double calculateGPA() {
        double sum = 0;
        for (double g : grades) sum += g;
        return grades.size() == 0 ? 0.0 : sum / grades.size();
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Role: Student, GPA: " + calculateGPA());
    }
}

// Faculty class
class Faculty extends Person {
    private List<Course> courses;

    public Faculty(String name, String email, int id) {
        super(name, email, id);
        courses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.setFaculty(this);
        }
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Role: Faculty, Courses Teaching: " + courses.size());
    }
}

// Course class
class Course {
    private String name;
    private int code;
    private Faculty faculty;
    private List<Student> students;

    public Course(String name, int code) {
        this.name = name;
        this.code = code;
        students = new ArrayList<>();
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void printCourseDetails() {
        System.out.println("Course: " + name + " (" + code + ")");
        System.out.println("Faculty: " + (faculty != null ? faculty.name : "None"));
        System.out.println("Enrolled Students: " + students.size());
    }
}

// Main class to test everything
public class CollegeInformationSystem {
    public static void main(String[] args) {
        // Create students
        Student s1 = new Student("Alice", "alice@mail.com", 101);
        Student s2 = new Student("Bob", "bob@mail.com", 102);

        // Create faculty
        Faculty f1 = new Faculty("Dr. Smith", "smith@mail.com", 201);

        // Create courses
        Course c1 = new Course("Mathematics", 301);
        Course c2 = new Course("Physics", 302);

        // Assign faculty to courses
        f1.assignCourse(c1);

        // Students enroll
        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s1.enrollCourse(c2);

        // Assign grades
        s1.setGrade(c1, 3.5);
        s1.setGrade(c2, 4.0);
        s2.setGrade(c1, 3.0);

        // Print details
        s1.printDetails();
        s2.printDetails();
        f1.printDetails();
        c1.printCourseDetails();
        c2.printCourseDetails();
    }
}


