<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

<h1 >welcome to Mortage</h1>
Hello users  ${user}
<FIELDSET><LEGEND><strong>Register</strong></LEGEND>
	<form action="registeruser" method="post">
	
		<table align ="center">
			<tr>
				<td>Name :</td>
				<td> <input type="text" name="name" required="required">  </td>
			</tr>
			<tr>
				<td> UserName:</td>
				<td> <input type="text" name="username" required="required">  </td>
			</tr>
			<tr>
				<td>Password :</td>
				<td> <input type="password" name="password" required="required">  </td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td> <input type="password" name="confirmpassword" required="required">  </td>
			</tr>
			<tr>
				<td>email:</td>
				<td> <input type="email" name="email" required="required">  </td>
			</tr>
			
			<tr>
				<td>Mobile Number:</td>
				<td> <input type="number" name="mobilenumber"required="required">  </td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Register" /></td>
			</tr>
			
			</form>
			</table>
			</FIELDSET>
			<table>
			<tr>
				<td><a href="login"><button>login</button></a></td>
			</tr>
		</table>
		
		
		
		</FIELDSET>
</body>
</html>