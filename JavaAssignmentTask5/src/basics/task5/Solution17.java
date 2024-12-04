package basics.task5;

import java.util.Scanner;

//Write a Program to calculate largest of three numbers
public class Solution17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the three numbers");
		Integer a=sc.nextInt();
		Integer b=sc.nextInt();		
		Integer c=sc.nextInt();
		
		if(a>b && a>c)
		{
			System.out.println("a is largest number");
		}
		else if(b>a && b>c)
		{
			System.out.println("b is largest number");
		}
		else if(c>a && c>b)
		{
			System.out.println("c is largest number");
		}
		else
			
		{
			System.out.println("All three numbers are equal");
		}

	}

}
