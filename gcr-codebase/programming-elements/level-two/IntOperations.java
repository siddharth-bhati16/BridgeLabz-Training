import java.util.Scanner;
 public class IntOperations{
 
   public static void main (String []args){
   Scanner sc=new Scanner(System.in);
   
   System.out.println("enter the value of a  ");
   double a=sc.nextDouble();

   System.out.println("enter the value of b  ");
   double b=sc.nextDouble();
   
   System.out.println("enter the value of c ");
   double c=sc.nextDouble();

   double firstoperation=a+(b*c);
   System.out.println("solution of first operation  is  "+ firstoperation );
   
   double secondoperation=(a*b)+c;
   System.out.println("solution of second operation  is  "+ secondoperation );
   
   double thirdoperation=c+(a/b);
   System.out.println("solution of third operation  is  "+ thirdoperation);
    
   double fourthoperation=c+(a/b);
   System.out.println("solution of fourth operation  is  "+ fourthoperation);	
   
}
}