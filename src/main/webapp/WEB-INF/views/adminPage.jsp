<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Restricted admin page</title>

<link href="<c:url value="/resources/css/global.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/admin.css" />" rel="stylesheet"
	type="text/css">

</head>
<body>

	<div id="container">

		<h1>This is admin page</h1>
		<h2>Welcome ${adminName}</h2>
		<p>
			<a href='<spring:url value="/main" />'>Go back to main page</a>
		</p>
		<h3>List of authorized users:</h3>
		<div id=tableDiv>
			<table>
				<tr><th>Username</th><th>Authority</th></tr>
				<c:forEach items="${usersList}" var="user">
					<tr>
						<td>${user.userName}</td>
						<td>${user.userRole}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>



</body>
</html>
