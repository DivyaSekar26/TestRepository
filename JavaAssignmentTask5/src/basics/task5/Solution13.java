package basics.task5;

import java.util.Scanner;

/*3. Write a program to print the given below pattern.

Sample Input:

4

Sample Output:

1

23

456

7 8 9 10*/

//number of values in each row is equal to nth row - underlying logic

public class Solution13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the input");
		int a=sc.nextInt();
		int num =1;
		for(int i=1;i<=4;i++)
		{
			for(int j=1; j<=i;j++)
			{
				System.out.print(num+ " ");
				num++;
			}
			System.out.println();
		}

	}

}

/*
 * Output: Enter the input 4
 *  1 
 *  2 3 
 *  4 5 6 
 *  7 8 9 10
 */
