package basics.task4;

import java.util.Scanner;

/*Q1. Write a Java program that declares four integer variables: 
 * a, b, c, and d. Then, write an if statement that checks 
 * whether the sum of a and b is greater than the sum of c and d. 
 * If the condition is true, the program should output a message 
 * indicating that the sum of a and b is greater than the sum of c and d.*/

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub3
		
     
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first input");
		int a=sc.nextInt();
		System.out.println("Enter second input");
		int b=sc.nextInt();
		System.out.println("Enter third input");
		int c=sc.nextInt();
		System.out.println("Enter fourth input");
		int d=sc.nextInt();
		
		if((a+b)> (c+d))
		{
			System.out.println("Sum of a and b is greater than sum of c and d");
		}
				
	}

}

/*
 * Output: Enter first input 3 
 * Enter second input 4 
 * Enter third input 1 Enter
 * fourth input 2 Sum of a and b is greater than sum of c and d
 */
	
