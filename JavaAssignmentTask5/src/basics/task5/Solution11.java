package basics.task5;

import java.util.Scanner;

/*Write a program to check whether a given string is a palindrome or not
 *  using for loop and if-else statement.*/

public class Solution11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the input String");
		String str=sc.next();
		String chk="";
		
		for(int i=str.length()-1;i>=0;i--)
		{
			chk=chk+str.charAt(i);
		}
		
		if(chk.equals(str))
		{
			System.out.println("The entered String is Palindrome");
		}
		else
		{
			System.out.println("The entered String is not a Palindrome");
		}
		
	}

}

/*
 * Output: Enter the input String madam The entered String is Palindrome
 */

/*
 * Enter the input String Success The entered String is not a Palindrome
 */

