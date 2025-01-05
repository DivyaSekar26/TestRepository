package exceptions.handling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Write a program to convert List to Array.*/

public class Program7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		List<Integer> list=new ArrayList<Integer>();
		list.add(sc.nextInt());
		list.add(sc.nextInt());
		list.add(sc.nextInt());
		list.add(sc.nextInt());
		list.add(sc.nextInt());
		System.out.println("Printing List: "+list);
		
       Integer[] arr= list.toArray(new Integer[0]);
       System.out.println("Printing Array: "+list);
    
		


	}

}
