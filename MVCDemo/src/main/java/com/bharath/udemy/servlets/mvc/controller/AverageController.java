package com.bharath.udemy.servlets.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bharath.udemy.servlets.mvc.model.AverageCalculator;

/**
 * Servlet implementation class AverageController
 */
@WebServlet("/averageController")
public class AverageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num1 = Integer.parseInt(request.getParameter("number1"));
		int num2 = Integer.parseInt(request.getParameter("number2"));
		
		AverageCalculator model = new AverageCalculator();
		int result = model.calculate(num1, num2);
		
		request.setAttribute("result", result);
//		Interconnecting servlet to JSP
		RequestDispatcher out = request.getRequestDispatcher("result.jsp");
		out.forward(request, response);
	
	}

}
