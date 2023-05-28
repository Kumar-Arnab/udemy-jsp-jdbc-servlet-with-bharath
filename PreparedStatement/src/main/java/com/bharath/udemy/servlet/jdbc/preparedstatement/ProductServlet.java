package com.bharath.udemy.servlet.jdbc.preparedstatement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	PreparedStatement statement;
	
	public void init() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Vivasva@20");
			statement = connection.prepareStatement("insert into product values(?,?,?,?)");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		
		System.out.println(id + "  " + name + "   " + description + "   " + price);
		System.out.println(statement);
		
		try {
			// Parameter Binding to insert statement
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, description);
			statement.setInt(4, price);
			
			int result = statement.executeUpdate(); // We don't pass the sql statement here as compilation happens only once and statement is already pre-compiled 
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<b>" + result + " Products Created" + "</b>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void destroy() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
