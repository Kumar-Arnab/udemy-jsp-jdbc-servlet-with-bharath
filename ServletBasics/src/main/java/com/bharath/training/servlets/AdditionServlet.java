package com.bharath.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/addition")
public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		if (req.getParameter("number1") != null && req.getParameter("number2") != null) {
			Long num1 = Long.parseLong(req.getParameter("number1"));
			Long num2 = Long.parseLong(req.getParameter("number2"));
		
		PrintWriter out = res.getWriter();
		out.println("The Sum is: " + (num1 + num2));
		}
	}

}
