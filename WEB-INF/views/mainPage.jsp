<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

<link href="<c:url value="/resources/css/global.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"
	type="text/css">

<script src=<c:url value="/resources/js/timer.js" />
	type="text/javascript"></script>


</head>
<body onload="countdown();">

	<div id=container>
		<div id="header">
			<div id="welcome">
				<span class="vertical">Welcome</span>
			</div>
			<div id="logout">
				<a href="<c:url value="/j_spring_security_logout" />"><span
					class="vertical">Logout</span></a>
			</div>
			<div id="admin">
				<c:choose>
					<c:when test="${isUserAdmin eq true}">
						<a href="/contactsOrganizer/main/admin"><span class="vertical">Go
								to admin page:</span></a>
					</c:when>
					<c:otherwise>
						<a href="/contactsOrganizer/main"><span class="vertical">Restricted access</span></a>
					</c:otherwise>
				</c:choose>


			</div>

		</div>
		<div style="clear: both;"></div>
		<div id="contactForm">
			<h1>Contacts:</h1>

			<form action="/contactsOrganizer/main/submitNewContact" method="post">
				<table>
					<tr>
						<td><input type="text" name="name" placeholder="name"
							onfocus="this.placeholder=''" onblur="this.placeholder='name'"></td>
						<td class="errors"><form:errors path="contact.name" /></td>
					</tr>

					<tr>
						<td><input type="text" name="surname" placeholder="surname"
							onfocus="this.placeholder=''" onblur="this.placeholder='surname'"></td>
						<td class="errors"><form:errors path="contact.surname" /></td>
					</tr>

					<tr>
						<td><input type="text" name="company" placeholder="company"
							onfocus="this.placeholder=''" onblur="this.placeholder='company'"></td>
						<td class="errors"><form:errors path="contact.company" /></td>
					</tr>

					<tr>
						<td><input type="text" name="email" placeholder="email"
							onfocus="this.placeholder=''" onblur="this.placeholder='email'"></td>
						<td class="errors"><form:errors path="contact.email" /></td>
					</tr>

					<tr>
						<td><input type="text" name="phone" placeholder="phone"
							onfocus="this.placeholder=''" onblur="this.placeholder='phone'"></td>
						<td class="errors"><form:errors path="contact.phone" /></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit"
							value="Add a new contact"></td>
					</tr>
				</table>
			</form>



		</div>
		<div id="rightPanel">
			<div id="clockPanel"></div>
			<div id="contactsList">
				<table id="contacts">
					<c:forEach items="${list}" var="oneContact">
						<tr>
							<td>${oneContact.name}</td>
							<td>${oneContact.surname}</td>
							<td>${oneContact.company}</td>
							<td>${oneContact.email}</td>
							<td>${oneContact.phone}</td>
							<td><a href="/contactsOrganizer/main/edit/${oneContact.id}">Edit</a></td>
						</tr>

					</c:forEach>
				</table>
			</div>
		</div>

	</div>
</body>
</html>
