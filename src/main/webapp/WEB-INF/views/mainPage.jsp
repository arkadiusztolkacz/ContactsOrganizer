<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="pl">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>

<link href="<c:url value="/resources/css/global.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"
	type="text/css">

</head>
<body>
	<header>
		<ul>
			<li>Welcome</li>
			<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
			<li><a href="#" id="toggle">Add a new contact</a></li>
			<c:choose>
				<c:when test="${isUserAdmin eq true}">
					<li><a href='<spring:url value="/main/admin" />'>Admin
							page:</a></li>
				</c:when>
			</c:choose>
		</ul>
	</header>



	<div id="modalBox"
		<c:choose>
				<c:when test="${Visible eq true}">style="display:block"</c:when>
			</c:choose>>
		<div id="contactForm">
			<span id="closeForm">×</span>
			<h2>New contact</h2>
			<form:errors path="contact.*" class="error" />

			<form action='<spring:url value="/main/submitNewContact" />' method="post">
				<table>
					<tr>
						<td><input type="text" name="firstName" placeholder="first name"
							onfocus="this.placeholder=''" onblur="this.placeholder='first name'"></td>
						<td class="errors"><form:errors path="contact.firstName" /></td>
					</tr>

					<tr>
						<td><input type="text" name="lastName" placeholder="last name"
							onfocus="this.placeholder=''" onblur="this.placeholder='last name'"></td>
						<td class="errors"><form:errors path="contact.lastName" /></td>
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
						<td><input type="submit" value="Add a new contact"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="clockPanel"></div>

	<main> <input type="text" id="nameInput" onkeyup="filterNames()"
		class="searchInput" placeholder="Search for names..."
		title="Type in a name"> <br />
	<input type="text" id="companyInput" onkeyup="filterCompanies()"
		class="searchInput" placeholder="Search for companies..."
		title="Type in a company">
	
	<span id="tooltip">Click profile picture to go to profile's details.</span>
	
	<table id="contacts">
		<tr>
			<th>Name</th>
			<th>Company</th>
			<th>Phone number</th>
			<th>Details</th>
		</tr>
		<c:forEach items="${list}" var="oneContact">
			<tr>
				<td>${oneContact.firstName} ${oneContact.lastName}</td>
				<td>${oneContact.company}</td>
				<td>${oneContact.phone}</td>
				<td class="editCell"><a
					href='<spring:url value="/main/contact?id=${oneContact.id}" />'>
					<img src='<c:url value="/resources/images/${oneContact.id}.png"/>' alt="profile" />
					</a></td>
			</tr>

		</c:forEach>
	</table>
	</main>

	<script src=<c:url value="/resources/js/timer.js" />></script>
	<script src=<c:url value="/resources/js/formToggle.js" />></script>
	<script src=<c:url value="/resources/js/filterTable.js" />></script>

</body>
</html>
