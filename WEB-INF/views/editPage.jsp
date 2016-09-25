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
<title>Edit</title>

<link href="<c:url value="/resources/css/global.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/edit.css" />" rel="stylesheet"
	type="text/css">

</head>
<body>

	<div id="container">

		<div id="header">
			<div id="label">
				<span class="vertical">Edit the contact</span>
			</div>
			<div id="back">
				<a href="/contactsOrganizer/main/edit/goBack" /><span
					class="vertical">Back to main page</span></a>
			</div>
			<div style="clear: both;"></div>
		</div>

		<div id="contact">
			<form action="/contactsOrganizer/main/edit/update" method="post">
				<input type="hidden" name="id" value="${contact.id}">
				<table>
					<tr>
						<td>Contact's Name:</td>
						<td><input type="text" name="name" value="${contact.firstName}"
							placeholder="${originalContact.name}"></td>
						<td class="errors"><form:errors path="contact.firstName" /></td>

					</tr>
					<tr>
						<td>Contact's Surname:</td>
						<td><input type="text" name="surname"
							value="${contact.surname}"
							placeholder="${originalContact.lastName}"></td>
						<td class="errors"><form:errors path="contact.lastName" /></td>
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

			<form action="/contactsOrganizer/main/edit/delete" method="post">
				<input type="hidden" name="id" value="${contact.id}"> <input
					type="submit" value="Delete contact">
			</form>
		</div>
	</div>
</body>
</html>
