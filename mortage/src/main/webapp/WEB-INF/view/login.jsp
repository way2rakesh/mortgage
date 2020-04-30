<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1 >welcome to Mortage</h1>
Hello users  ${user}
<FIELDSET><LEGEND><strong>Login</strong></LEGEND>
	<form action="checkuser" method="post">
	
		<table align = "center" >
			
			<tr>
				<td> UserName:</td>
				<td> <input type="text" name="username" required="required">  </td>
			</tr>
			<tr>
				<td>Password :</td>
				<td> <input type="password" name="password" required="required">  </td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="login" /></td>
			</tr>
			
			</form>
			</table>
			
		</FIELDSET>
			<table>
			<tr>
				
				<td><a href="register"><button>Register</button></a></td>
			</tr>
		</table>
		
		
		
		
</body>
</html>