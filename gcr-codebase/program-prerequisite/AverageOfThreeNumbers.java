import java.util.Scanner;
public class AverageOfThreeNumbers{
public static void main (String []args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the firstnumber");
double firstnumber= sc.nextDouble();
System.out.println("Enter the secondnumber");
double secondnumber= sc.nextDouble();
System.out.println("Enter the thirdnumber");
double thirdnumber=sc.nextDouble();
double AverageOfThreeNumbers= (firstnumber+secondnumber+thirdnumber)/3;
System.out.println("average of number is  "+ AverageOfThreeNumbers);
}
}