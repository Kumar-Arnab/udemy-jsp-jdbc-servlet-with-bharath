package com.arnab.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {
	
	public static void main(String[] args) {
		
		try {
			
//			Step 1: Establish the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Vivasva@20");
			
			System.out.println("Connection: " + connection);
			
//			Step 2: Create the statement object
			Statement statement = connection.createStatement();
//			int result = statement.executeUpdate("INSERT INTO account VALUES(1, 'Arnab', 'Kumar', 2000)");
			
//			System.out.println(result + " Rows got inserted");
			
//			int result = statement.executeUpdate("UPDATE account SET bal=10000 where accno=1;");
//			System.out.println(result + " Rows got updated");
			
//			int result = statement.executeUpdate("DELETE FROM account where accno=1;");
//			System.out.println(result + " Rows got deleted");
			
//			Step 3: Submit the SQL query to DBMS
			ResultSet rs = statement.executeQuery("select * from account");
			
			while (rs.next()) {
				System.out.println("Index: " + rs.getString(1));
				System.out.println("Name: " + rs.getString(3) + " " + rs.getString(2));
				System.out.println("Balance: " + rs.getString(4));
			}
			
			rs.close();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}

}
