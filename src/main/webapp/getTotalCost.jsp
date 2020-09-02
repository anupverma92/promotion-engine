<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Customer</title>
</head>
<body>
<form action="getCustomer" method="post" >


The Customer details are:  ${products}

<input type="text" name="cid"><br>
<input type="submit" value="Get Customer"><br>
</form>

</body>
</html>