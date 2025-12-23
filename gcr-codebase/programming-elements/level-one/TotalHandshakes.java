import java.util.Scanner;
 public class TotalHandshakes{
 
  public static void main (String []args){
  Scanner sc=new Scanner(System.in);
   
   System.out.println("total number of people");
   double totalpeople=sc.nextDouble();
   

   double totalhandshakes=(totalpeople*(totalpeople-1))/2;
   System.out.println("total number of handshakes is  "+ totalhandshakes);
}
}