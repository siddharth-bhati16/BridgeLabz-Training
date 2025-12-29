//write a java program to print the prime numbers between 13 to 27

import java.util.Scanner;

public class FindingPrimeNumber{

  public static void main(String[] args){
  
  for(int i=13;i<=27;i++){
    if(i%2==0 || i%3==0|| i%4==0 || i%5==0 ||i%6==0 || i%7==0 ||i%8==0 ||i%9==0 || i%10==0|| i%11==0 || i%12==0 ||i%13==0  ){
	System.out.println("not a prime number");
   }
  }
}
}	  
