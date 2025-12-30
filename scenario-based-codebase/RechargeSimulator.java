//phone recharge simulator

import java.util.*;
public class RechargeSimulator
{
	public static void main (String args[])
	{
		System.out.println("How many plans do you prefer to recharge recharge");
		Scanner sc = new Scanner (System.in);
		
		int repeat = sc.nextInt();
		
		System.out.println("Recharge options that we have are 249, 399, 199, 99 ");
		
		//variable for storing data and calling
		int rechargeArray[] = new int[2];
		rechargeArray[0] =0;
		rechargeArray[1] = 0;
		
		//taking inputs 
		for( int i=1; i<=repeat; i++)
		{
			System.out.println("Enter the amount");
			int amount = sc.nextInt();
			
			
			
			System.out.println(displayOffer(amount));
			
			rechargeArray = updatebalance(amount, rechargeArray[0], rechargeArray[1] );
			
			System.out.println("updated balance is: \n data "+rechargeArray[0] +" talktime: " + rechargeArray[1]);
		}
		
	}
	
	//method for diplaying the offer
	
	public static String displayOffer(int amount)
	{
		String result ="";
		
		switch (amount)
		{
			case 249:
			result ="This plan has 45 Gb data and 150 rs talktime";
			break;
			
			case 399:
			result ="This plan has 80 Gb data and 300 rs talktime";
			break;
			
			case 99:
			result =" 90 rs talktime";
			break;
			
			case 199:
			result ="This plan has 50 Gb data";
			break;
			
			default:
			result = "Choose a valid plan";
			
		}
		return result;
	}
	
	//method to do the recharge and update the balance
	public static int [] updatebalance(int amount, int data, int calling)
	{
		int arr[]= new int[2];
		
		switch (amount)
		{
			case 249:
			data += 45;
			calling += 150;
			break;
			
			case 399:
			data += 80;
			calling += 300;
			break;
			
			case 99:
			calling += 90;
			break;
			
			case 199:
			data += 50;
			break;
			
			default:
			data+=0;
			
		}
		arr[0] = data;
		arr[1] = calling;
		return arr;
		
	}
}