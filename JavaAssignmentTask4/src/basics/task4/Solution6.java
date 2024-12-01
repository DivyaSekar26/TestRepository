package basics.task4;

import java.util.Scanner;

/*Write a program to print the factorial of a given number.*/

public class Solution6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int a=sc.nextInt();
		int result=a;
		
		//Factorial Logic 5*4*3*2*1
		for(int i=(a-1);i>=1;i--)
		{
			 result =result*i;
		}
		
		System.out.println("The factorial of number is "+result);

	}

}

/*
 * Output: Enter the number 6 The factorial of number is 720
 */

