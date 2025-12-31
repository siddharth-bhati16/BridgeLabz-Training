import java.util.Scanner;
public class Luckydraw{
    public static int selectedNumber(int number){
        if(number%3==0 && number%5==0){
            System.out.println("  congratulation you wonn the lucky draw ");
        }else{
            System.out.println("---Better luck next time---");
        }
        return 0;
    }

    public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      System.out.println("-----Welcome to the festival lucky draw-----");
      System.out.println("Ente your token number :");
      int number =sc.nextInt();
      System.out.print("Lucky draw"+ selectedNumber(number));
    }
}