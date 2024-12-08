package task6.oops;

/*1. Create a class called "Person" with attributes "name" and "age". 
 * Also create a constructor and getter methods for the attributes.*/

public class Person {
	
	String name;
	int age;
	
	Person(String name, int age)	
	{
		this.name=name;
		this.age=age;
		
		System.out.println("Name: "+name );
		System.out.println("Age: "+age);
	}
	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
	
	public static void main(String[] args) 
	{
		Person obj=new Person("Divya", 27);
		System.out.println(obj.getName());
		System.out.println(obj.getAge());
		
	}

}
