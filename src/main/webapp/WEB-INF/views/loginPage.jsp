<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<link href="<c:url value="/resources/css/global.css" />" rel="stylesheet"
	type="text/css">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet"
	type="text/css">

<style>
</style>
</head>
<body>
	<div id="header">
		Welcome! <br /> Please login with Username and Password
	</div>

	<div id="container">
		<form name='f' action="<c:url value='j_spring_security_check' />"
			method="post">
			<input type="text" name="j_username" placeholder="username"
				onfocus="this.placeholder=''" onblur="this.placeholder='username'">
			<input type="password" name="j_password" placeholder="password"
				onfocus="this.placeholder=''" onblur="this.placeholder='password'">

			<input name="submit" type="submit" value="Login">
		</form>

		<div id="error">
			<c:if test="${error eq true}">
		Your username or password was incorrect
			</c:if>
		</div>
	</div>
</body>
</html>
