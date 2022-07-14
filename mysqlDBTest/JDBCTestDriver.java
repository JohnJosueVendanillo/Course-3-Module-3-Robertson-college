package mysqlDBTest;

import java.sql.*;

public class JDBCTestDriver {

	public static void main(String[] args) {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Norima","root", "Password123!");
			System.out.println("Database connection successful!");
		
			Statement stmt = conn.createStatement();
			
			String strSelect = " select distinct FirstName from person ";
			System.out.println("The SQL statement is: " + strSelect + "\n");
					
			ResultSet rset = stmt.executeQuery(strSelect);		
		
			System.out.println("Person table contents are: ");			
			while(rset.next()) {
				
				String  firstname = rset.getString("FirstName");			
				System.out.println(": " + firstname);	
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
