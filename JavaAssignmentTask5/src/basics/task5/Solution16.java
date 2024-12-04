package basics.task5;

import java.util.Scanner;

/*
Write a program to calculate the hotel tariff. The room rent is 20% high during peak seasons
[April-June, November-December]. Note: Use the switch construct*/

public class Solution16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the month");
		Integer month=sc.nextInt();
		if(month>12)
		{
			System.out.println("Invalid Month Input");
		}
		if(month<=12)
		{
		System.out.println("Enter the room rent per day");
		float rent=sc.nextFloat();
		System.out.println("Enter the no of days");
		Integer days=sc.nextInt();
		
		
		switch(month)
		{
		
		case 1: 
		{
			System.out.println("The total tariff is "+ (rent*days));
			break;
		}
			
		case 2:
		{
			System.out.println("The total tariff is "+ (rent*days));
			break;
		}
		case 3: 
		{
			System.out.println("The total tariff is "+ (rent*days));
			break;
		}	
		case 4:
		{
			System.out.println("The total tariff is "+ ((6*rent*days)/5));
			break;
		}
		case 5:
		{
			System.out.println("The total tariff is "+ ((6*rent*days)/5));
			break;
		}
		case 6:
		{
			System.out.println("The total tariff is "+ ((6*rent*days)/5));
			break;
		}
		case 7: 
		{
			System.out.println("The total tariff is "+ (rent*days));
			break;
		}	
		case 8:
		{
			System.out.println("The total tariff is "+ (rent*days));
			break;
		}
		case 9: 
		{
			System.out.println("The total tariff is "+ (rent*days));
			break;
		}
		case 10:
		{
			System.out.println("The total tariff is "+ (rent*days));
			break;
		}
		case 11:
		{
			System.out.println("The total tariff is "+ ((6*rent*days)/5));
			break;
		}
			
		case 12: 
		{
			System.out.println("The total tariff is "+ ((6*rent*days)/5));
			break;
		}
			
		
		}
		}

	}

}
