package basics.task4;

import java.util.Scanner;

/*Q4.Write a java program to get 2 numbers from the user and 
 * swap their values without any loss of data. You can make use of additional 
 * variable for swapping. Print the corresponding swapped values of the 
 * two numbers as output in the console.*/

public class Solution4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the two Numbers");
		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println("The numbers before swapping : a= " + a + " b= " + b);

		int temp;
		temp = a;
		a = b;
		b = temp;

		System.out.println("The numbers after swapping : a= " + a + " b= " + b);

	}

}
/*
 * Output: Enter the two Numbers 1 2 The numbers before swapping : a= 1 b= 2 The
 * numbers after swapping : a= 2 b= 1
 */
