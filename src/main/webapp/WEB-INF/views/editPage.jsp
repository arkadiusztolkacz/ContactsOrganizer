<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Details</title>

<link href="<c:url value="/resources/css/global.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/edit.css" />" rel="stylesheet"
	type="text/css">

</head>
<body>

	<header>

		<ul>
			<li>Contact's profile</li>
			<li><a href="/contactsOrganizer/main/edit/goBack">Back to
					main page</a></li>
		</ul>
	</header>

	<figure>
		<div id="profilePic"></div>
		<figcaption>profile picture</figcaption>
	</figure>

	<section id="labels" class="contactInfo">
		<ul>
			<li>First name</li>
			<li>Last name</li>
			<li>Company</li>
			<li>E-mail</li>
			<li>Phone</li>
		</ul>
	</section>
	<section id="details" class="contactInfo">
		<ul>
			<li>${originalContact.name}</li>
			<li>${originalContact.surname}</li>
			<li>${originalContact.company}</li>
			<li>${originalContact.email}</li>
			<li>${originalContact.phone}</li>
		</ul>
	</section>
	<div class="clearfix"></div>
	<nav>
		<ul>
			<li>Update contact's info</li>
			<li>Update profile pic</li>
			<li>Delete contact</li>
		</ul>
	</nav>
	<div class="clearfix"></div>
	<section id="contactForm" class="tabContent">
	<div id="contact">
		<form action="/contactsOrganizer/main/edit/update" method="post">
			<input type="hidden" name="id" value="${contact.id}">
			<table>
				<tr>
					<td>Contact's Name:</td>
					<td><input type="text" name="name" value="${contact.name}"
						placeholder="${originalContact.name}"></td>
					<td class="errors"><form:errors path="contact.name" /></td>

				</tr>
				<tr>
					<td>Contact's Surname:</td>
					<td><input type="text" name="surname"
						value="${contact.surname}"
						placeholder="${originalContact.surname}"></td>
					<td class="errors"><form:errors path="contact.surname" /></td>
				</tr>
				<tr>
					<td>Contact's Company:</td>
					<td><input type="text" name="company"
						value="${contact.company}"
						placeholder="${originalContact.company}"></td>
					<td class="errors"><form:errors path="contact.company" /></td>
				</tr>
				<tr>
					<td>Contact's E-mail:</td>
					<td><input type="text" name="email" value="${contact.email}"
						placeholder="${originalContact.email}"></td>
					<td class="errors"><form:errors path="contact.email" /></td>
				</tr>
				<tr>
					<td>Contact's Phone:</td>
					<td><input type="text" name="phone" value="${contact.phone}"
						placeholder="${originalContact.phone}"></td>
					<td class="errors"><form:errors path="contact.phone" /></td>
				</tr>
			</table>

			<input type="submit" value="Submit changes">

		</form>

		
	</div>
	</section>
	<section id="contactPic" class="tabContent">
		<h1>Under construction</h1>
	</section>
	<section id="contactDelete" class="tabContent">
		<form action="/contactsOrganizer/main/edit/delete" method="post">
			<input type="hidden" name="id" value="${contact.id}"> <input
				type="submit" value="Delete contact">
		</form>
	</section>
</body>
</html>
