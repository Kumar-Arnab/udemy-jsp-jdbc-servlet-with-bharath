package com.bharath.udemy.servlets.sm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TargetServet
 */
@WebServlet("/targetServlet")
public class TargetServet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("User name is: " + userName);
	
	}
}
