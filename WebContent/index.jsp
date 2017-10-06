<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OnlineSales</title>
<link href="assets/css/StyleSheet.css" rel="stylesheet" type="text/css" />
<script src="js/prefixfree.min.js"></script>
</head>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>Login</div>
		<br>
	</div>
	<form action="ServletAutenticar.do" method="POST">
		<div class="login">
			<input type="text" placeholder="username" name="txtUsuario"
				required="true"><br> <input type="password"
				placeholder="password" name="txtPassword" required="true"><br>
			<input type="submit" name="btnAgregar" value="Login"><br>
			<div class="estado">${estado}</div>
		</div>
	</form>
	<script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
</body>
</html>