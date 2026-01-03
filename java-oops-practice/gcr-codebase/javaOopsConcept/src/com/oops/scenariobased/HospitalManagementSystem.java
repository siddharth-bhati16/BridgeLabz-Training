package com.oops.scenariobased;
// Interface (Abstraction)
interface Payable {
    double calculatePayment();
}

// Base Class (Encapsulation + Inheritance)
class Patient {
    private int patientId;
    private String name;
    private int age;
    private String medicalHistory; // sensitive data (private)

    // Normal admission constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = "Not Provided";
    }

    // Emergency admission constructor (Overloading)
    public Patient(int patientId, String name, int age, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    // Getter (Encapsulation)
    public String getSummary() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    // Polymorphism
    public void displayInfo() {
        System.out.println(getSummary());
    }
}

// InPatient class (Inheritance)
class InPatient extends Patient {
    private int daysAdmitted;

    public InPatient(int id, String name, int age, int daysAdmitted) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public void displayInfo() {
        System.out.println(getSummary() + ", Days Admitted: " + daysAdmitted);
    }
}

// OutPatient class (Inheritance)
class OutPatient extends Patient {
    private String appointmentDate;

    public OutPatient(int id, String name, int age, String appointmentDate) {
        super(id, name, age);
        this.appointmentDate = appointmentDate;
    }

    @Override
    public void displayInfo() {
        System.out.println(getSummary() + ", Appointment: " + appointmentDate);
    }
}

// Doctor class
class Doctor {
    private int doctorId;
    private String name;
    private String specialization;

    public Doctor(int doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }

    // Polymorphism
    public void displayInfo() {
        System.out.println("Doctor ID: " + doctorId +
                ", Name: " + name +
                ", Specialization: " + specialization);
    }
}

// Bill class (Interface + Operators)
class Bill implements Payable {
    private double consultationFee;
    private double medicineCost;
    private double discountRate; // e.g., 0.10 = 10%
    private double taxRate;      // e.g., 0.05 = 5%

    public Bill(double consultationFee, double medicineCost,
                double discountRate, double taxRate) {
        this.consultationFee = consultationFee;
        this.medicineCost = medicineCost;
        this.discountRate = discountRate;
        this.taxRate = taxRate;
    }

    @Override
    public double calculatePayment() {
        double subtotal = consultationFee + medicineCost; // +
        double discount = subtotal * discountRate;        // *
        double taxedAmount = (subtotal - discount) * taxRate;
        return subtotal - discount + taxedAmount;
    }
}

// Main class (Single runnable file)
public class HospitalManagementSystem {
    public static void main(String[] args) {

        // Patients
        Patient p1 = new InPatient(101, "Arjun", 30, 5);
        Patient p2 = new OutPatient(102, "Meera", 25, "12-Aug-2026");

        // Doctor
        Doctor d1 = new Doctor(201, "Dr. Sharma", "Cardiology");

        // Display Info (Polymorphism)
        p1.displayInfo();
        p2.displayInfo();
        d1.displayInfo();

        // Billing
        Bill bill = new Bill(500, 1500, 0.10, 0.05);
        System.out.println("Total Bill Amount: ₹" + bill.calculatePayment());
    }
}
