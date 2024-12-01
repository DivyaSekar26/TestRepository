package basics.task4;

import java.util.Scanner;

/*Q9. Write a program to check whether the person is a senior citizen or not.*/
public class Solution9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the age ");
		int age = sc.nextInt();
		
		if(age>=60)
		{
			System.out.println("Person is a senior citizen");
		}
		else
		{
			System.out.println("Person is not a senior citizen");
		}

	}

}

/*
 * output1: Enter the age 61 Person is a senior citizen
 */

/* output2:
 * Enter the age 
30
Person is not a senior citizen */
	
