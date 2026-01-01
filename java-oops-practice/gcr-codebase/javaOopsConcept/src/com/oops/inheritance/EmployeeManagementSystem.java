package com.oops.inheritance;
class Employee{
	String id;
	String name;
	int age;
	
	void employeeDetail() {
		System.out.println("details of the employee");
	}
}
class Manager extends Employee{
	void employeeDetail() {
		System.out.println("details of the manager");
	}
}

class Developer extends Employee{
	void employeeDetails() {
		System.out.println("details of the developer");
	}
}

class Intern extends Employee{
	void employeeDetails() {
		System.out.println("details of the intern");
	}
}
public class EmployeeManagementSystem {
	public static void main(String[] args) {
		Manager manager=new Manager();
		Developer developer=new Developer();
		Intern intern=new Intern();
		
		manager.employeeDetail();
		developer.employeeDetail();
		intern.employeeDetail();
		
	}

}
