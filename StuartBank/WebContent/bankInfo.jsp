<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.stuartbank.BankVaultInfo"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Info</title>
</head>
<body>
<h1>Bank Info</h1>

<%String name=(String) session.getAttribute("name");
out.println("Welcome "+name); %>
<br/>
<%String bancode=(String) session.getAttribute("bankcode");
out.println("BankCode "+bancode); %>

<%BankVaultInfo bvi =(BankVaultInfo)request.getAttribute("bankVaultInfo");%>
<h4>Number Of Customers:</h4><%=bvi.getNumberOfCustomers()%>
<br/>
<h4>Number Of Accounts:</h4><%=bvi.getNumberOfAccounts()%>
<br/>
<h4>Total Balance:</h4><%=bvi.getBankBalance()%>
<br/>
<form action="/BankAccountInfo" method="get">
<a href="/CustomerBankAccountInfo">AccountInfo</a><br/>
</form>
</body>
</html>