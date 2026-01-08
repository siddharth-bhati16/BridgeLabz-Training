package com.oops.scenariobased;

interface IApprovable {
 boolean approveLoan();
 double calculateEMI();
}

class Applicant {
 private String name;
 private int creditScore; 
 private double income;
 private double loanAmount;

 public Applicant(String name, int creditScore, double income, double loanAmount) {
     this.name = name;
     this.creditScore = creditScore;
     this.income = income;
     this.loanAmount = loanAmount;
 }

 public String getName() {
     return name;
 }

 int getCreditScore() { 
     return creditScore;
 }

 public double getIncome() {
     return income;
 }

 public double getLoanAmount() {
     return loanAmount;
 }
}

abstract class LoanApplication implements IApprovable {

 protected Applicant applicant;
 protected int termInYears;
 protected double interestRate;
 protected String loanType;

 private String loanStatus = "PENDING"; 

 public LoanApplication(Applicant applicant, int termInYears, double interestRate, String loanType) {
     this.applicant = applicant;
     this.termInYears = termInYears;
     this.interestRate = interestRate;
     this.loanType = loanType;
 }

 protected double calculateStandardEMI(double rateMultiplier) {
     double P = applicant.getLoanAmount();
     double R = (interestRate * rateMultiplier) / (12 * 100);
     int N = termInYears * 12;

     return (P * R * Math.pow(1 + R, N)) /
            (Math.pow(1 + R, N) - 1);
 }

 public boolean approveLoan() {
     if (applicant.getCreditScore() >= 650 &&
         applicant.getIncome() >= applicant.getLoanAmount() / 5) {
         setLoanStatus("APPROVED");
         return true;
     }
     setLoanStatus("REJECTED");
     return false;
 }

 protected void setLoanStatus(String status) {
     this.loanStatus = status;
 }

 public String getLoanStatus() {
     return loanStatus;
 }
}

class HomeLoan extends LoanApplication {

 public HomeLoan(Applicant applicant, int termInYears) {
     super(applicant, termInYears, 8.5, "Home Loan");
 }

 @Override
 public double calculateEMI() {
     return calculateStandardEMI(0.9);
 }
}

class AutoLoan extends LoanApplication {

 public AutoLoan(Applicant applicant, int termInYears) {
     super(applicant, termInYears, 10.5, "Auto Loan");
 }

 @Override
 public double calculateEMI() {
     return calculateStandardEMI(1.1);
 }
}

public class LoanBuddy {

 public static void main(String[] args) {

     Applicant applicant = new Applicant(
             "Rahul Sharma",
             720,
             75000,
             500000
     );

     LoanApplication loan = new HomeLoan(applicant, 20);

     System.out.println("Applicant: " + applicant.getName());
     System.out.println("Loan Type: Home Loan");

     if (loan.approveLoan()) {
         System.out.println("Loan Status: " + loan.getLoanStatus());
         System.out.println("Monthly EMI: ₹" + String.format("%.2f", loan.calculateEMI()));
     } else {
         System.out.println("Loan Status: " + loan.getLoanStatus());
     }
 }
}

