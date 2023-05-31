<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Declaration block -->
<%!
	Connection connection;
	PreparedStatement ps;

	//Overriding jspinit and jspdestroy
	public void jspInit() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Vivasva@20");
			ps = connection.prepareStatement("insert into account values(?,?,?,?)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void jspDestroy() {
		try {
			ps.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
%>    


<!-- Scriptlet Block -->
<%
int accNo = Integer.parseInt(request.getParameter("accno"));
String lastName = request.getParameter("lastname");
String firstName = request.getParameter("firstname");
int balance = Integer.parseInt(request.getParameter("bal"));

ps.setInt(1, accNo);
ps.setString(2, lastName);
ps.setString(3, firstName);
ps.setInt(4, balance);

ps.executeUpdate();

%>


<!-- to redirect the page to openaccount.html every time after submit -->
<%@ include file="openaccount.html" %>