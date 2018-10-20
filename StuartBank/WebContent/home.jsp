<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="HomeInfo" method="get">
<a href="Customerregistration">Customer registration</a><br/>
<a href="bankaccountInfo"> Bank Account Info</a><br/>
<a href="bankInfo"> Bank Info</a><br/>
<a href="transfer"> Transfer</a><br/>
</form>
<%=session.getAttribute("name")%>
<% out.println("name");%> 
</body>
</html>