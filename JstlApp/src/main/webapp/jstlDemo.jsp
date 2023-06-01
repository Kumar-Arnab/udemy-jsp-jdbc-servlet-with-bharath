<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cout Demo</title>
</head>
<body>

<c:out value="The sum is ${10 + 9}" /> <br/>
<c:set var="testScore" value="${ 80 }" scope="session" />
<c:out value="Test Score is ${testScore}"/><br />
<c:if test="${ testScore >= 80 }">
	<p>Your score is okish</p>
</c:if>

<c:choose>
	<c:when test="${ testScore >= 80 }">A Grade</c:when>
	<c:when test="${ testScore >= 60 }">B Grade</c:when>
	<c:when test="${ testScore >= 40 }">C Grade</c:when>
	<c:when test="${ testScore < 40 }">F Grade</c:when>
</c:choose>
<br/>

<c:forEach var="i" begin="1" end="10">
	<c:out value="${ i }" /><br/>
</c:forEach>

<!-- We generally use c:forEach to iterate on a collection -->
<%
List<String> l = new ArrayList<>();
l.add("chutki");
l.add("jhuli");
l.add("hoppon");
l.add("kali");

request.setAttribute("biralNames", l);
%>

<c:forEach var="biral" items="${ biralNames }">
	<c:out value="${ biral }" /><br/>
</c:forEach>

<c:remove var="testScore"/>
<c:out value="Test Score after removal is ${testScore}"/><br />


<!-- Formatting starts here -->
<c:set var="accountBalance" value="123.456" />

<fmt:parseNumber var="i" type="number" value="${ accountBalance }" />
<p>Amount is<c:out value="${ i }"/></p>

<c:set var="accountBalance" value="777777.455678" />
<p>Formatted Number 1: <fmt:formatNumber value="${ accountBalance }" type="currency" /></p>
<p>Formatted Number 2: <fmt:formatNumber value="${ accountBalance }" type="number" maxFractionDigits="4" /></p>
<p>Formatted Number 3: <fmt:formatNumber value="${ accountBalance }" type="number" maxIntegerDigits="2" /></p>
<p>Formatted Number 4: <fmt:formatNumber value="${ accountBalance }" type="percent" /></p>
<p>Formatted Number 5: <fmt:formatNumber value="${ accountBalance }" type="number" pattern="####.##$" /></p>

<c:set var="myDate" value="12-05-2023" />
<p>Formatted Date: <fmt:parseDate var="parsedDate" value="${ myDate }" pattern="dd-mm-yyyy" />
<c:out value="${ parsedDate }"></c:out>
</p>

</body>
</html>