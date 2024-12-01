package basics.task4;

import java.util.Scanner;

/*Q5. Write a program to check if a number is prime or not.*/

public class Solution5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number");
		int num=sc.nextInt();
		int count =0;
		
		for(int i=2;i<num;i++)
		{
			if(num%i==0)
			{
				count++;
			}
		}
		if(count==0)
		{
			System.out.println("The number is Prime");
		}
		else
		{
			System.out.println("The number is Prime");
		}

	}

}
