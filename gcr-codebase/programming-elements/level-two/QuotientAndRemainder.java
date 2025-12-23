import java.util.Scanner;
 public class QuotientAndRemainder{
 
   public static void main (String []args){
   Scanner sc=new Scanner(System.in);
   
   System.out.println("enter the first number  ");
   double firstnumber=sc.nextDouble();

   System.out.println("enter the second number  ");
   double secondnumber=sc.nextDouble();

   double quotient=firstnumber/secondnumber;
   System.out.println("quotient is  "+ quotient);
    
   double remainder=firstnumber%secondnumber;
   System.out.println("remainder is  "+ remainder);
}
}