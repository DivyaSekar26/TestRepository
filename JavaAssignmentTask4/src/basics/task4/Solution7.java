package basics.task4;

import java.util.Scanner;

/*Q7. Write a program to print the length of the given string - String msg="Guvi Geek"*/
public class Solution7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String Value");
		String str=sc.nextLine();
		
		int length=str.length();
		System.out.println("Length of the String is : "+ length);
	}

}

/*
 * Output: Enter the String Value Guvi Geek 
 * Length of the String is : 9
 */
