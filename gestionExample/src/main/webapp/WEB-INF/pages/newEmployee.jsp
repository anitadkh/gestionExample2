<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: left; padding: 5px 0;">
		<a href="${pageContext.request.contextPath}/newEmployee?lang=en">
			Login English</a> &nbsp;&nbsp; <a
			href="${pageContext.request.contextPath}/newEmployee?lang=fr">Login
			French</a>
	</div>

	<h1>
		<s:message code="label.registered" />
		!
	</h1>

	<table>
		<tr>
			<td><s:message code="label.firstName" /> :</td>
			<td>${employee.firstName}</td>
		</tr>
		<tr>
			<td><s:message code="label.lastName" /> :</td>
			<td>${employee.lastName}</td>
		</tr>
		<tr>
			<td><s:message code="label.title" /> :</td>
			<td>${employee.title}</td>
		</tr>
		<tr>
			<td><s:message code="label.startDate" /> :</td>
			<td>${employee.startDate}</td>
		</tr>
		<tr>
			<td><s:message code="label.email" /> :</td>
			<td>${employee.email}</td>
		</tr>
		<tr>
			<td><s:message code="label.gender" /> :</td>
			<td>${employee.gender}</td>
		</tr>
		<tr>
			<td><s:message code="label.married" />? :</td>
			<td>${employee.married}</td>
		</tr>
	</table>

</body>
</html>