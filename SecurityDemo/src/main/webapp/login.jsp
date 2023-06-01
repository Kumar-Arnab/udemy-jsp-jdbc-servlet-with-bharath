<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login JSP</title>
</head>
<body>

	<form action="j_security_check" method="post">
		User Name: <input name="j_username" /><br/>
		Password: <input type="password" name="j_password" /><br />
		<input type="submit" value="submit" />
	</form>

</body>
</html>