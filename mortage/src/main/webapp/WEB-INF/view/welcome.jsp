<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
</head>
<body>
	<c:forEach var="user" items="${userdetails }">
		<table>

			<tr>
				<td>UserName:</td>
				<td>${user.getName()}</td>
			</tr>
			<tr>
				<td>Email :</td>
				<td>${user.getEmail()}</td>
			</tr>
			<tr>
				<td>Mobile Number :</td>
				<td>${user.getMobileNumber()}</td>
			</tr>
		</table>
	</c:forEach>
	<h1>Please Enter Below Details</h1>
	<table>
		<form action="detailsofloan" method="post">
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" required="required" placeholder="name">
			</td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td><input type="radio" name="gender" value="male" checked="checked">male</td>
			<td><input type="radio" name="gender" value="female" >female</td>
		</tr>
		<tr>
			<td>Pan:</td>
			<td><input type="text" name="pancard" required="required">
			</td>
		</tr>
		<tr>
			<td>Salary:</td>
			<td><input type="number" name="salary" required="required" placeholder="20000">
			</td>
		</tr>
			<tr>
			<td>Second Source Income:</td>
			<td><input type="number" name="secondsourceincome" required="required" placeholder="9999">
			</td>
		</tr>
		</table>
		<h1>Property Details</h1>
		<table>
		<tr>
			<td>Loan Name:</td>
			<td><input type="text" name="loanname" required="required" >
			</td>
		</tr>
		
		<tr>
			<td>address:</td>
			<td><input type="text" name="address" required="required">
			</td>
		</tr>
		<tr>
			<td>Area:(In Sq Feet)</td>
			<td><input type="number" name="area"  required="required" placeholder="1234">
			</td>
		</tr>
		<tr>
			<td>PinCode:</td>
			<td><input type="number" name="pincode" required="required" placeholder="5600">
			</td>
		</tr>
		
	
		
		<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="ApplyLoan" /></td>
			</tr>


</table>

</form>


		
</body>
</html>