package com.bharath.udemy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
//@WebServlet("/readServlet")
public class ReadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	
	public void init(ServletConfig config) {
		ServletContext context = config.getServletContext();
		
//		Create a db connection
		try {
			Class.forName("com.mysql.jdbc.Driver"); // This is required only for tomcat cause tomcat doesnt work with service provider mechanism
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), context.getInitParameter("dbUser"), context.getInitParameter("dbPassword"));
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user;");
			
			PrintWriter out = response.getWriter();
			out.print("<table>");
			out.print("<tr>");
			
			out.print("<th>");
			out.print("First Name");
			out.print("</th>");
			
			out.print("<th>");
			out.print("Last Name");
			out.print("</th>");
			
			out.print("<th>");
			out.print("Email");
			out.print("</th>");
			
			out.print("</tr>");
			
//			generating dynamic HTML
			while (resultSet.next()) {
				
				out.println("<tr>");
				
				out.println("<td>");
				out.println(resultSet.getString(1));
				out.println("</td>");
				
				out.println("<td>");
				out.println(resultSet.getString(2));
				out.println("</td>");
				
				out.println("<td>");
				out.println(resultSet.getString(3));
				out.println("</td>");
				
				out.println("</tr>");
				
			}
			
			out.print("</table>");
			
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
