import java.util.Scanner;

public class ParkingSlot{
    public static void main(String [] args){
	   Scanner sc=new Scanner(System.in);
	   
	   int totalslots=10;
	   int occupiedslots=0;
	   int choice;
	   
	   do{
	      System.out.println("    parking gate system   ");
		  System.out.println("   1.parking the vehicle   ");
	      System.out.println("   2.exit vehicle   ");
	      System.out.println("   3.show occupacy   ");
	      System.out.println("   4.exit   ");
		  
		  choice=sc.nextInt();
		  
		  switch (choice){
		  
		    case 1:
			  if(occupiedslots < totalslots){
			    occupiedslots++;
				System.out.println("vehicle parked");
			  }
			  else{
			    System.out.println("parking space is full");
			  }
			
            case 2: 
              if(occupiedslots>0){
               occupiedslots--;
			   System.out.println("vehicle exited successfully");
			  }			  
            case 3: 
			  System.out.println("total number of slots" + totalslots);
			  System.out.println("total number of occupied slots" + occupiedslots);
			  System.out.println("total number of slots empty" + (totalslots-occupiedslots));
              break;
			  
			case 4:
			  System.out.println("thanks for using parking facilities");
			  break;
			  
			default:
			 System.out.println("invalid choice");
			}	
        }while (choice!=4);
    }
}	