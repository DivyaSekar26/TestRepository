package task6.oops;

import java.util.Scanner;

/*Create a class Account class with all necessary parameters as data member. 
 * Create two constructors (no argument, and two arguments) and methods to withdraw 
 * and deposit balance & check balance.*/

public class Account {
	double totamt;
	double amt;
	double balance;

	Account() {
		System.out.println("In default Constructor");
	}

	Account(double totamt, double amt) {
		this.totamt = totamt;
		this.amt = amt;

	}

	public double withdrawBalance() {
		balance = totamt - amt;
		return balance;
	}

	public double depositBalance() {
		balance = totamt + amt;
		return balance;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to withdraw amount");
		System.out.println("Enter 2 to Deposit amount");
		int num = sc.nextInt(); // Getting input from user to decide they are going to deposit or withdraw
		Account obj = new Account(10000, 2000);

		switch (num) {
		case 1:
			System.out.println("Withdraw processed successfully");
			System.out.println("Balance Amount after withdraw: " + obj.withdrawBalance());
			break;
		case 2:
			System.out.println("Deposit processed successfully");
			System.out.println("Balance Amount after withdraw: " + obj.depositBalance());
			break;

		}

	}

}
