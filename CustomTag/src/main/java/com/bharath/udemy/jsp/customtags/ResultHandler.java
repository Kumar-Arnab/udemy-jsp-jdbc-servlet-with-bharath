package com.bharath.udemy.jsp.customtags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ResultHandler extends TagSupport {

	Connection connection;
	PreparedStatement statement;
	
	public ResultHandler() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Vivasva@20");
			statement = connection.prepareStatement("select * from user where email=?");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int doStartTag() throws JspException {
		ServletRequest request = pageContext.getRequest();
		
		String email = request.getParameter("email");
		try {
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			JspWriter out = pageContext.getOut();
			if (rs.next()) {
				out.println("User details are:");
				out.println("First Name:" + rs.getString(1));
				out.println("Last Name:" + rs.getString(2));
			} else {
				out.print("Invalid email entered");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		skip the tag body
		return Tag.SKIP_BODY;
	
	}
	
	@Override
	public void release() {

		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
