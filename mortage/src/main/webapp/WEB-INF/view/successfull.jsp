<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>successfully_applied</title>
</head>
<body>
<h3>Thank You for applying loan </h3><br>
User Name:	<%=session.getAttribute("userName") %> <br>
		User Id:	<%=session.getAttribute("userId") %> <br>
<table border="2" width="70%" cellpadding="2"> 

	
<tr><th>loan_id</th><th>amount</th><th>intrest_rate</th><th>year</th><th> emi</th></tr>  
<c:forEach var="loan" items="${loanid }">
 
   <tr>  
   <td>${loan.getLoan_id()}</td>  
   <td>${loan.getAmount()}</td>  
   <td>${loan.getIntrest_rate()}</td>  
   <td>${loan.getYear()}</td>  
   <td>${loan.getEmi()}</td> 
   </tr>  
   </c:forEach>
 </table>
 <h5>please check for details is correct or not</h5>
 <a href="logout"><button>Logout</button></a>
</body>
</html>