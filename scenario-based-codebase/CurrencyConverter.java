import java.util.Scanner;

public class CurrencyConverter{

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char choice = 'y';

        do{
        System.out.println("---Enter the indian rupees to be converted : ---");
        int inr = sc.nextInt();
 
        System.out.println("Select the currency in which amount is to be converted ");
        System.out.println("1. USD:");
        System.out.println("2. EURO:");
        System.out.println("3. TAKA:");
        System.out.println("4. PESO:");

        System.out.println("select one of the above currency(1-4) :");
        int currency=sc.nextInt();

        double convertedAmount=0;

        switch(currency) {

            case 1:
                convertedAmount=inr*80;
                System.out.println("amount converted in USD is: "+ convertedAmount);
                break;

            case 2:
                convertedAmount=inr*50;
                System.out.println("amount converted in EURO is:"+ convertedAmount);
                break;
                
            case 3:
                convertedAmount=inr*0.5;
                System.out.println("amount converted in TAKA is : "+ convertedAmount);
                break;
                
            case 4: 
                convertedAmount=inr*1.5;
                System.out.println("amount converted in PESO is :" + convertedAmount);
                break;

            default:
                System.out.println("Invalid currency choice ");
				break;
          
        }
		System.out.println("you wanna continue : y/n : ");
            choice  = sc.next().charAt(0);
        }while(choice == 'y' || choice == 'Y');

        System.out.println("Thank you for using currency converter:");
		sc.close();

    }
}