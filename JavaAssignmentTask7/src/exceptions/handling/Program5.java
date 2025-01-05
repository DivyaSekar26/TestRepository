package exceptions.handling;

import java.util.ArrayList;
import java.util.Scanner;

/*Write a Java program to create an ArrayList of strings and then remove all the elements from 
the ArrayList.*/

public class Program5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ArrayList list=new ArrayList();
		list.add(sc.next());
		list.add(sc.next());
		list.add(sc.next());
		list.add(sc.next());
		list.add(sc.next());
		System.out.println("The list after adding elements "+ list);
		list.removeAll(list);
		System.out.println("The list after removing elements "+ list);

	}

}

/*
 * Output: divya priya kavya' ramya soumya The list after adding elements
 * [divya, priya, kavya', ramya, soumya] The list after removing elements []
 */
