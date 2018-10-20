<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Account Info</title>
</head>
<body>
<h1>BankBalanceInfo</h1>
<%String name=(String) session.getAttribute("name");
out.println("Welcome "+name); %>
<form action="customerbankInfo" method="get">
Bank Code : <input type="text" name="bankcode"/><br/>
Account Balance: <input type="text" name="balance"/> <br/>
<select name="AccountType" >
     <option value ="credit">Credit Card</option>
     <option value ="Savings">Savings Account</option>
     <option value = "current">Current Account</option>
     <option value = "loan">Loan</option>
</select> 
<input type="submit" value="Submit">
</form>
</body>
</html>