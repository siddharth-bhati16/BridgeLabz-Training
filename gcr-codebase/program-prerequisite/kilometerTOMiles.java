import java.util.Scanner;
public class kilometerTOMiles{
public static void main (String []args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the kilometer");
double kilometer= sc.nextDouble();
double kilometerTOMiles= kilometer*0.631371;
System.out.println("value of kilometer in miles is  "+ kilometerTOMiles);
}
}