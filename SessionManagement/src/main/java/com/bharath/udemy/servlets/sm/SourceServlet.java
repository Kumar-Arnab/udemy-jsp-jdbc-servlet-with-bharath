package com.bharath.udemy.servlets.sm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SourceServlet
 */
@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sessionId = "";
//		setting a cookie
		response.addCookie(new Cookie("securityToken", "12345"));
		
//		retrieving the cookies
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie c: cookies) {
				System.out.println(c.getName() + "    " + c.getValue());
				if (c.getName().equals("JSESSIONID")) sessionId = c.getValue();
			}

		String userName = request.getParameter("userName");
		
		HttpSession session = request.getSession();
		session.setAttribute("user", userName);// for the next servlet
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
//		URL rewriting
		String url = "targetServlet?sessionId=" + sessionId;
//		out.println("<a href='targetServlet'>Click here to get the User Name</a>"); without url rewriting
		
//		with url rewriting
		out.println("<a href='"+ url +"'>Click here to get the User Name</a>");
		
	}

}
