package task6.oops;

/*Create a class circle with radius as data member
 Create two constructors (no argument, and two arguments)
  and a method to calculate Circumference. */
public class Circle {
	
	int radius;
    float pi;
	
	Circle()
	{
		System.out.println("In Default Constructor");
	}
	
	Circle(int radius , float pi)
	{
		this.radius=radius;
		this.pi=pi;
	}
	
	public float circumference()
	{
		float circum= 2*radius*pi;
		return circum;
	}
	
	
	public static void main(String[] args) {
		Circle obj=new Circle(2, 3.14f);
		System.out.println("Total Circumference Value: "+obj.circumference());

	}

}
