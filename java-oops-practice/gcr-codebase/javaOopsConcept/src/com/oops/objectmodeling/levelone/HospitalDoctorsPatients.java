package com.oops.objectmodeling.levelone;

import java.util.*;

//Doctor class
class Doctor {
 private String name;
 private List<Patient> patients;

 public Doctor(String name) {
     this.name = name;
     this.patients = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 // Association + Communication
 public void consult(Patient patient) {
     if (!patients.contains(patient)) {
         patients.add(patient);
         patient.addDoctor(this);
     }
     System.out.println("Doctor " + name + " is consulting Patient " + patient.getName());
 }

 public void showPatients() {
     System.out.println("Patients of Doctor " + name + ":");
     for (Patient p : patients) {
         System.out.println("  " + p.getName());
     }
 }
}

//Patient class
class Patient {
 private String name;
 private List<Doctor> doctors;

 public Patient(String name) {
     this.name = name;
     this.doctors = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 // Association support method
 public void addDoctor(Doctor doctor) {
     if (!doctors.contains(doctor)) {
         doctors.add(doctor);
     }
 }

 public void showDoctors() {
     System.out.println("Doctors consulted by Patient " + name + ":");
     for (Doctor d : doctors) {
         System.out.println("  " + d.getName());
     }
 }
}

//Hospital class
class Hospital {
 private String hospitalName;
 private List<Doctor> doctors;
 private List<Patient> patients;

 public Hospital(String hospitalName) {
     this.hospitalName = hospitalName;
     this.doctors = new ArrayList<>();
     this.patients = new ArrayList<>();
 }

 public void addDoctor(Doctor doctor) {
     doctors.add(doctor);
 }

 public void addPatient(Patient patient) {
     patients.add(patient);
 }

 public void showHospitalDetails() {
     System.out.println("Hospital: " + hospitalName);

     System.out.println("Doctors:");
     for (Doctor d : doctors) {
         System.out.println("  " + d.getName());
     }

     System.out.println("Patients:");
     for (Patient p : patients) {
         System.out.println("  " + p.getName());
     }
 }
}

//Main class
public class HospitalDoctorsPatients {
 public static void main(String[] args) {

     Hospital hospital = new Hospital("City Hospital");

     Doctor d1 = new Doctor("Dr. Smith");
     Doctor d2 = new Doctor("Dr. Adams");

     Patient p1 = new Patient("Alice");
     Patient p2 = new Patient("Bob");

     hospital.addDoctor(d1);
     hospital.addDoctor(d2);

     hospital.addPatient(p1);
     hospital.addPatient(p2);

     // Consultations (communication)
     d1.consult(p1);
     d1.consult(p2);
     d2.consult(p1);

     System.out.println();
     d1.showPatients();
     d2.showPatients();

     System.out.println();
     p1.showDoctors();
     p2.showDoctors();
 }
}
