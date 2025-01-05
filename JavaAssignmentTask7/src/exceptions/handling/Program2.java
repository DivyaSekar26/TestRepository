package exceptions.handling;

import java.util.Scanner;

/*Write the code of ArrayIndexOutOfBoundsException& StringIndexOutOfBoundsException?*/

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int a[]=new int[5];
		a[0]=sc.nextInt();
		a[1]=sc.nextInt();
		a[2]=sc.nextInt();
		a[3]=sc.nextInt();
		a[4]=sc.nextInt();
		try {
			
		
		System.out.println("The element at index 5: "+ a[5]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Enter String Input");
		String b=sc.next();
		try {
		System.out.println("Character at index 10"+ b.charAt(10));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}
	
	/*
	 * output for Arrayindex: 1 3 4 4 5 Exception in thread "main"
	 * java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
	 * at exceptions.handling.Program2.main(Program2.java:20)
	 */
	
	/*
	 * Output for String Index: Enter String Input hello Exception in thread "main"
	 * java.lang.StringIndexOutOfBoundsException: String index out of range: 10 at
	 * java.base/java.lang.StringLatin1.charAt(StringLatin1.java:48) at
	 * java.base/java.lang.String.charAt(String.java:1517) at
	 * exceptions.handling.Program2.main(Program2.java:23)
	 */

}
