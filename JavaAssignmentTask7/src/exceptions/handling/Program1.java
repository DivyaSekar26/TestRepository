package exceptions.handling;

import java.util.Scanner;

/*Write a Java program that reads user input for two integers and performs division. 
Handle the exception that is thrown when the second number is zero,
and display an error message to the user.*/

class InvalidIntegerException extends Exception{
	public InvalidIntegerException(String message)
	{
		System.out.println(message);
	}
}

public class Program1 {

	public static void main(String[] args) throws InvalidIntegerException {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		ValidateDivision(a, b);

	}

	  private static void ValidateDivision(int a, int b) throws InvalidIntegerException {
		// TODO Auto-generated method stub
		  
		  if(b==0)
		  {
			  throw new InvalidIntegerException("The Number can not be divided by Zero");
		  }
		  else
		  {
			  System.out.println("The division result is : "+ (a/b));
		  }
	}

}

/*
 * Output: 2 0 The Number can not be divided by Zero Exception in thread "main"
 * exceptions.handling.InvalidIntegerException at
 * exceptions.handling.Program1.ValidateDivision(Program1.java:33) at
 * exceptions.handling.Program1.main(Program1.java:24)
 */
