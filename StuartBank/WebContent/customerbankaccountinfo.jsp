<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.stuartbank.AccountInfo"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%>
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

<br/>
<%String bancode=(String) session.getAttribute("bankcode");
out.println("BankCode "+bancode); %>


  <h1>Displaying CustomerBankAccountInfo</h1> 
      <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>CustomerId</b></th> 
          <th><b>CustBankAccountNo</b></th> 
          <th><b>BankCode</b></th> 
           <th><b>CustAcntBalance</b></th> 
          <th><b>LastUpDatedStaffId</b></th> 
          <th><b>LastUsedTransactionDate</b></th> 
           <th><b>CustomerAccountType</b></th>
         </tr> 
        <%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
        --%> 
<%--         <%CustomerBankAccountInfo s =(CustomerBankAccountInfo)request.getAttribute("bankacntInfo");%>
 --%>        
 		 <%List<AccountInfo> std =  
            (ArrayList<AccountInfo>)request.getAttribute("bankacntInfo"); 
        for(AccountInfo cbai:std){%>  
        
            <tr> 
                 <td><%=cbai.getCustomerId()%></td> 
                <td><%=cbai.getCustomerBankAccountNo()%></td> 
                <td><%=cbai.getBankCode()%></td> 
                 <td><%=cbai.getCustomerAccounttBalance()%></td> 
                 <td><%=cbai.getLastUpDatedStaffId()%></td>
                <td><%=cbai.getLastUsedTransactionDate()%></td> 
                <td><%=cbai.getCustomerAccountType()%></td> 
                <tD><input type="button" name="edit" value="Edit" onClick="javascript:window.location='deleteData.jsp';"style="background-color:#ff0000;font-weight:bold;color:#ffffff;"></td>
                <tD><input type="button" name="delete" value="Delete" onClick="javascript:window.location='deleteData.jsp';"style="background-color:#ff0000;font-weight:bold;color:#ffffff;"></td>
                
            </tr> 
           <%}%> 
        </table>  
        <hr/> 
</body>
</html>