package com.bharath.udemy.interservletcommunication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Vivasva@20");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user where email='"+ userName +"' and password='"+ password +"' ");
			
//			Login Success code
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeServlet");
			
			if (resultSet.next()) {
				request.setAttribute("message", "Welcome to Inter Servlet Communication " + userName);
				requestDispatcher.forward(request, response);
			}

//			Login failure code
			else {
				requestDispatcher =  request.getRequestDispatcher("login.html");
				requestDispatcher.include(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
