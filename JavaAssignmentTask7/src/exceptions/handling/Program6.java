package exceptions.handling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*Write a Java program to create a TreeMap of employee IDs and names. 
Then, print out the names of all the employees in alphabetical order.*/

public class Program6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
      Map<Integer , String> map=new TreeMap();
      System.out.println("Adding Entries in Map");
      map.put(sc.nextInt(), sc.next());
      map.put(sc.nextInt(), sc.next());
      map.put(sc.nextInt(), sc.next());
      map.put(sc.nextInt(), sc.next());
      map.put(sc.nextInt(), sc.next());
      
      System.out.println("Printing Map: "+ map);
      
      ArrayList<String> arr=new ArrayList(map.values());
      Collections.sort(arr);
      System.out.println("Sorted Employee names :" +arr);
     
	}

}

/*
 * Output: 1 Divya 2 Ramya 3 Kavya 4 Priya 5 Bavya Printing Map: {1=Divya,
 * 2=Ramya, 3=Kavya, 4=Priya, 5=Bavya} Sorted Employee names :[Bavya, Divya,
 * Kavya, Priya, Ramya]
 */
