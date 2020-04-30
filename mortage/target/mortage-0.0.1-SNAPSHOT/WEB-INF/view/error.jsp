<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>error page</title>
</head>
<body>
<fieldset>
<legend>error</legend>
<table align ="center">
Hello users<br>  ${error}<br>

<tr><td><a href="viewuserdetails">click here for welcomepage</a></td></tr>
<tr><td><a href="logout"><button>Logout</button></a></td></tr>
</table>
</fieldset>
</body>
</html>