package employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDaoImpl {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root" , "Root123@");
		
		Statement stmt =con.createStatement();
		
		  String
		  createquery="CREATE TABLE EMP_DETAILS (EMPCODE INT ,EMPNAME VARCHAR(250), EMPAGE INT , ESALARY INT)" ;
		  
		  stmt.execute(createquery);
		 
		
		String insertquery="INSERT INTO EMP_DETAILS VALUES (101 , 'Jenny',25, 10000),(102, 'Jacky' ,30, 20000), (103, 'Joe', 20, 40000), "
				+ "(104 , 'John', 40, 80000),(105 , 'Shameer', 25, 90000)";
		
		stmt.execute(insertquery);
	}

}
