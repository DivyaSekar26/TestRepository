package exceptions.handling;
/*Create a custom exception in Java called "InvalidAgeException" that is thrown 
when the user enters an age less than 18. Implement exception handling in a Java program
to catch the "InvalidAgeException"
and display an error message*/

import java.util.Scanner;



class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
      System.out.println(message);
	}
}

public class Program3 {

	int age;

	public static void validateAge(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("The age can't be less than 18!");
		} else {
			System.out.println("Entered age is : " + age);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the age: ");
		int age = sc.nextInt();
		try {
			validateAge(age);
		} catch (InvalidAgeException e) {
			e.printStackTrace();
		}
	}
}
