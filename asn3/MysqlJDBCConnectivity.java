package asn3;

/**
 * Java Course 3, Module 3 -  Assignment 3
 * 
 * _MySQL_JDBC_Connectivity
 *
 * @author John Josue Vendanillo
 */

import java.sql.*;

public class MysqlJDBCConnectivity {

	public static void main(String[] args) {
		try {
			// Establishing connection to Norima database and logged in using user & pw .
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Norima","root", "Password123!");
			System.out.println("Database connection successful!");
		
			
			//prepared an statement to access The JDBCStatement, CallableStatement, and PreparedStatement interfaces
			Statement stmt = conn.createStatement();
			
			
			String strSelectAll = " select * FROM user_policy ";
			System.out.println("The SQL statement is: " + strSelectAll + "\n");
			
		
					
			// execute the query from MYSQL and to retrieve data from the database 
			ResultSet rsetAll = stmt.executeQuery(strSelectAll);
				
		
			System.out.println("User Policy All table contents are: ");	
			
			
			System.out.format("%6s %10s %16s %16s","policy no", "user id","date registered","policy type id\n");
			while(rsetAll.next()) {	
			 String policy_no = rsetAll.getString("policy_no");
			 int user_id = rsetAll.getInt("user_id");
			 String date_registered = rsetAll.getString("date_registered");
			 String policy_type_id = rsetAll.getString("policy_type_id");
						
			 System.out.format("%5s %12s %14s %12s", policy_no , user_id , date_registered,policy_type_id + "\n");	
			}	
			
			
			System.out.println("============================================================================================");
			
			
			String strSelectbyDate = " select * FROM user_policy WHERE date_registered < '2012-01-01' ";
			System.out.println("The SQL statement is: " + strSelectbyDate + "\n");
			
			ResultSet rsetDate = stmt.executeQuery(strSelectbyDate);	
			
			
			
			System.out.println("User Policy table contents that less than 2012-01-01 ");	
			
			//display the user policies data from the database
			System.out.format("%6s %10s %16s %16s","policy no", "user id","date registered","policy type id\n");
			while(rsetDate.next()) {	
			 String policy_no = rsetDate.getString("policy_no");
			 int user_id = rsetDate.getInt("user_id");
			 String date_registered = rsetDate.getString("date_registered");
			 String policy_type_id = rsetDate.getString("policy_type_id");
						
			 System.out.format("%5s %12s %14s %12s", policy_no , user_id , date_registered,policy_type_id + "\n");	
			}	
			
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}



/*
 * "policy no", 	"user id",       "date registered",		"policy type id
 * 	'689314',	  	  1111,				'1994-4-19',			'6896'				<--- must be shown only because date registered is less than 2012-01-01
	'689316',	 	  1111,				'2012-5-18',			'6895'
	'689317',	  	  1111,				'2012-6-20',			'6894'
	'689318',  	  	  2222,				'2012-6-21',			'6894'
	'689317',	  	  3333,				'2012-6-18',			'6894'
	'689420',	  	  4444,				'2012-4-09',			'6896'
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */



