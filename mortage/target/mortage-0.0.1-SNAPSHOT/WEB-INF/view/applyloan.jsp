<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Details</title>
</head>
<body>
<table border="2" width="70%" cellpadding="2">  
<tr><th>loan_id</th><th>amount</th><th>intrest_rate</th><th>year</th><th> emi</th><th>applyloan</th></tr>  
<c:forEach var="loan" items="${fetchLoanDetail }">
 

 

   <tr>  
   <td>${loan.getLoan_id()}</td>  
   <td>${loan.getAmount()}</td>  
   <td>${loan.getIntrest_rate()}</td>  
   <td>${loan.getYear()}</td>  
   <td>${loan.getEmi()}</td> 
    <td><input type="radio" name="applyloan" ><a href="loansuccess?id=${loan.getLoan_id()}">Applyloan</td> 
    
  
   </tr>  
   </c:forEach>
   </table>
   <a href="logout"><button>Logout</button></a>
</body>
</html>