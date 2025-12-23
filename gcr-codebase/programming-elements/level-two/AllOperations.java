import java.util.Scanner;
 public class AllOperations{
 
  public static void main (String []args){
  Scanner sc=new Scanner(System.in);
     
	 System.out.println("enter the firsr number ");
     double firstnumber=sc.nextDouble();
    
     System.out.println("enter the second number ");
     double secondnumber=sc.nextDouble();
   
     double addition=firstnumber+secondnumber;
     System.out.println("addition of number is   "+addition );
	 
	 double subtraction=firstnumber-secondnumber;
     System.out.println("subtraction  of number is   "+subtraction );
	 
	 double multiplication=firstnumber*secondnumber;
     System.out.println("multiplication of number is   "+multiplication );
	 
	 double division=firstnumber/secondnumber;
     System.out.println("division  of number is   "+division );
}
}