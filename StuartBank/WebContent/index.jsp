<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Date" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page contentType="text/html; charset=ISO-8859-1" %>
<% out.println("Welcome");%>  //scriptlet tags
<%! int i =0; %> // declatrion tags
<%= i%> // expression tags
<%@ page %>  //page directives // errorpage, flush, out, req, response, printewrtiters
<%-- <%@taglib %> // JSTL, custom tags
<%@include %> // include directive, // it will include one jsp into another jsp at complie time
 --%>
implicit objects - 9 objects
- request, response, out, config,session, application, page,exception, pagecontext 
</body>
</html>