<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Welcome to contacts organizer</title>

<link href="<c:url value="/resources/css/global.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet"
	type="text/css">

<style>
</style>
</head>
<body>
	<header>
		Welcome! <br /> Please login with Username and Password
	</header>

	<main>
	<form name='f' action="<c:url value='j_spring_security_check' />"
		method="post">
		<input type="text" name="j_username" placeholder="username"
			onfocus="this.placeholder=''" onblur="this.placeholder='username'"
			required autofocus>
			 <input type="password" name="j_password"
			placeholder="password" onfocus="this.placeholder=''"
			onblur="this.placeholder='password'" required> <input
			name="submit" type="submit" value="Login">
	</form>

	<span id="error"> <c:if test="${error eq true}">
		<spring:message code="AuthenticationProvider.badCredentials"/>
			</c:if>
	</span> </main>
</body>
</html>
