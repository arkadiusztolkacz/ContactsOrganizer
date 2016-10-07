<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
			<li><a href='<spring:url value="/main" />'>Back to main page</a></li>
		</ul>
	</header>

	<figure>
		<img id="profilePic" src='<c:url value="/resources/images/${originalContact.id}.png"/>' alt="Pic" />
		<figcaption>${originalContact.firstName} ${originalContact.lastName}</figcaption>
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
			<li>${originalContact.firstName}</li>
			<li>${originalContact.lastName}</li>
			<li>${originalContact.company}</li>
			<li>${originalContact.email}</li>
			<li>${originalContact.phone}</li>
		</ul>
	</section>
	<div class="clearfix"></div>
	<nav>
		<ul>
			<li class="tabLinks active"
				onclick="openOption(event, 'contactForm')">Update contact's
				info</li>
			<li class="tabLinks" onclick="openOption(event, 'contactPic')">Update
				profile pic</li>
			<li class="tabLinks" onclick="openOption(event, 'contactDelete')">Delete
				contact</li>
		</ul>
	</nav>
	<div class="clearfix"></div>
	<section id="contactForm" class="tabContent">
		<div id="contactEditForm">
			<form:errors path="contact.*" class="error" />
			<form action='<spring:url value="/main/contact/update" />' method="post">
				<input type="hidden" name="id" value="${contact.id}">
				<table>
					<tr>
						<td><input type="text" name="firstName"
							value="${contact.firstName}"
							placeholder="${originalContact.firstName}"></td>
						<td class="errors"><form:errors path="contact.firstName" /></td>

					</tr>
					<tr>
						<td><input type="text" name="lastName"
							value="${contact.lastName}"
							placeholder="${originalContact.lastName}"></td>
						<td class="errors"><form:errors path="contact.lastName" /></td>
					</tr>
					<tr>
						<td><input type="text" name="company"
							value="${contact.company}"
							placeholder="${originalContact.company}"></td>
						<td class="errors"><form:errors path="contact.company" /></td>
					</tr>
					<tr>
						<td><input type="text" name="email" value="${contact.email}"
							placeholder="${originalContact.email}"></td>
						<td class="errors"><form:errors path="contact.email" /></td>
					</tr>
					<tr>
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
		<h2>Choose an image from your files.</h2>
		<form action='<spring:url value="/main/contact/uploadPic" />' method="post" enctype="multipart/form-data">
		    <input type="hidden" name="id" value="${contact.id}">
		    <input name="profilePic" type="file" />
		    <input type="submit" value="Upload">
		</form>
		<h3>If the picture does not load immediately, try refreshing the page.</h3>
	</section>
	<section id="contactDelete" class="tabContent">
		<div class="alert">
			<strong>Danger!</strong> You cannot undone this action.
		</div>
		<form action='<spring:url value="/main/contact/delete"></spring:url>' method="post">
			<input type="hidden" name="id" value="${contact.id}"> <input
				type="submit" value="Delete contact" class="btn-danger">
		</form>
	</section>
	
	<script src=<c:url value="/resources/js/detailsOption.js" />></script>

</body>
</html>
