<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>

<jsp:useBean id="productBean" class="com.bharath.udemy.jsp.Product">
	<!-- Everything coming from HTML will be set to Product Bean class -->
	<jsp:setProperty name="productBean" property="*"/>
</jsp:useBean>

Product Details
<br />Id: <jsp:getProperty property="id" name="productBean"/>
<br />Name: <jsp:getProperty property="name" name="productBean"/>
<br />Description: <jsp:getProperty property="description" name="productBean"/>
<br />Price: <jsp:getProperty property="price" name="productBean"/>

</body>
</html>