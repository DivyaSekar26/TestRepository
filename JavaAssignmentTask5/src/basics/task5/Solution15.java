package basics.task5;

import java.util.Scanner;

/*Write a program to solve the given problem. The grades for marks 100-S, 90-99 is A,
80-89 is B, 70-79 is C, 60-69 is D, 50-59 is E and less than 50 is F.*/

public class Solution15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the Score:");
		Scanner sc=new Scanner(System.in);
		Integer score=sc.nextInt();
		
		if(score>100)
		{
			System.out.println("Invalid Input");
			
		}
        
		if(score<=100)
		{
			if(score == 100)
			{
				System.out.println("S");
			}
			else if(score>=90 && score<=99)
			{
				System.out.println("A");
				
			}
			else if(score>=80 && score>=89)
			{
				System.out.println("B");
			}
			else if(score>=70 && score<=79)
			{
				System.out.println("C");
			}
			else if(score>=60 && score<=69)
			{
				System.out.println("D");
			}
			else if(score>=50 && score<=59)
			{
				System.out.println("E");
			}
			else
			{
				System.out.println("F");
			}
		}
	}

}
