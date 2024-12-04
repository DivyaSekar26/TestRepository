package basics.task5;

import java.util.Scanner;

/*Write a program that reads in a string from the user and uses a loop to reverse the order 
 * of the characters in the string. Then, output the reversed string.*/
public class Solution12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the input String");
		String str=sc.next();
		String rev="";
		
		for(int i=str.length()-1;i>=0;i--)
		{
		rev=rev+str.charAt(i);
		}
		
		System.out.println("The reversed String is "+ rev);
	}

}
/*
 * Output: Enter the input String character The reversed String is retcarahc
 */