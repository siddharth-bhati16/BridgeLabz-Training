import java.util.Scanner;
 public class SideOFSquare{
 
  public static void main (String []args){
  Scanner sc=new Scanner(System.in);
   
   System.out.println("perimeter of square is  ");
   double perimeter=sc.nextDouble();

   double side=perimeter/4;
   System.out.println("side of the square is  "+ side);
}
}