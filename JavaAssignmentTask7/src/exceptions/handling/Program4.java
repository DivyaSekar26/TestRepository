package exceptions.handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*4. Implement exception handling in a Java program that reads data from a file. 
If the file does not exist, throw a "FileNotFoundException" and
display an error message to the user.*/

public class Program4 {
	public static void main(String[] args) {

		String filePath = "example.txt";

		try {

			File file = new File(filePath);
			Scanner scanner = new Scanner(file);

			System.out.println("File contents:");
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}

			scanner.close();
		} catch (FileNotFoundException e) {

			System.out.println("Error: The file '" + filePath + "' does not exist.");
		}

	}
}
