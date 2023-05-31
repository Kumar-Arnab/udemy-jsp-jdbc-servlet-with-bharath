<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>

<%
int result =(Integer) request.getAttribute("result");
out.print("<b>The average is: " + result + "</b>");
%>

</body>
</html>