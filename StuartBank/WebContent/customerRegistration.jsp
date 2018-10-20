<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CustomerRegistration</title>
</head>
<body>
<%String name=(String) session.getAttribute("name");
out.println("Welcome "+name); %>
<form action="Customerinfo" method="get">
CustomerFirstName: <input type="text" name="FisrtName"/><br/>
CustomerLastName: <input type="text" name="LastName"/> <br/>
Age: <input type="text" name="age"/> <br/>
DateOfBirth: <input type="text" name="DateOfBirth"/> <br/>
City: <input type="text" name="City"/> <br/>
State: <input type="text" name="State"/> <br/>
Country: <input type="text" name="Country"/> <br/>
ZIPCode: <input type="text" name="ZIPCode"/> <br/>
<input type="submit" value="Submit">
</form>

</body>
</html>