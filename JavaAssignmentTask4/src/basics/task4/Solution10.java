package basics.task4;

import java.util.Scanner;

/*Q10. Write a program to Count Number of Digits in an Integer.*/
public class Solution10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number ");
		int num =sc.nextInt(); //234
		int count=1;
		while(num/10!=0)
		{
			num=num/10;
			count++;
		}
        
		System.out.println("The number of digits in the Number is "+ count);
	}

}

/*
 * Output: Enter the number 3465789
 * The number of digits in the Number is 7
 */
