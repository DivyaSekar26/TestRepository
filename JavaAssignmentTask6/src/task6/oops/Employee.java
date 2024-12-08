package task6.oops;

public class Employee {

	int id;
	String firstName;
	String lastName;
	int salary;

	Employee(int id, String firstName, String lastName, int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public int getID() {
		return id;

	}

	public String getFirstName() {
		return firstName;

	}

	public String getLastName() {
		return lastName;

	}

	public String getName() {
		String name = firstName + " " + lastName;
		return name;

	}

	public int getSalary() {
		return salary;
	}

	public void setSalary() {
		this.salary = salary;
	}

	public int getAnnualSalary() {
		int annualSal = 12 * salary;
		return annualSal;
	}

	public int raiseSalary() {
		int salRaise = (120 * (getAnnualSalary())) / 100;
		return salRaise;
	}

	public void show() {
		System.out.println("Employee's Annual Salaray: "+getAnnualSalary());
		System.out.println("Employee's new Salary "+raiseSalary());
	}

	public static void main(String[] args) {
		Employee obj = new Employee(123, "Divya", "Sekar", 20000);
		obj.show();
	}

}
