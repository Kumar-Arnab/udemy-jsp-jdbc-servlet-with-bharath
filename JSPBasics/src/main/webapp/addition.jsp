<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add 2 numbers</title>
</head>
<body>

	<!-- Adding a scriptlet -->
	<%
		int num1 = Integer.parseInt(request.getParameter("number1"));
		int num2 = Integer.parseInt(request.getParameter("number2"));
		
		int result = num1 + num2;
	%>
	<h1>Sum Of <%=num1 %> and <%=num2 %> is <%=result %></h1>

</body>
</html>