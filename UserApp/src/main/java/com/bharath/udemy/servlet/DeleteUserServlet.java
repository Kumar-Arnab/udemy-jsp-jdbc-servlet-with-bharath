package com.bharath.udemy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/deleteServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	
	public void init() {
		
//		Create a db connection
		try {
			Class.forName("com.mysql.jdbc.Driver"); // This is required only for tomcat cause tomcat doesnt work with service provider mechanism
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Vivasva@20");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("delete from user where email='"+email+"';");
			
			PrintWriter out = response.getWriter();
			
			if (result > 0) out.print("<h1>User Deleted</h1>");
			else out.print("<h1>Error deleting the user</h1>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void destroy() {
		
//		Close the connection
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
