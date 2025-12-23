import java.util.Scanner;
 public class TotalCost{
 
  public static void main (String []args){
  Scanner sc=new Scanner(System.in);
   
   System.out.println("unit price of an item  ");
   double unitprice=sc.nextDouble();
   
   System.out.println("number of quantity  ");
   double quantity=sc.nextDouble();

   double totalamount=unitprice*quantity;
   System.out.println("total cost is equal to  "+ totalamount);
}
}