<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style type="text/css">
label {
	display: inline-block;
	width: 200px margin:5px 5px 5px 5px;
	text-align: left;
}

input[type=text], select {
	width: 200px;
}

button {
	margin: 5px 5px 5px 5px;
	padding: 5px;
}

table {
	border-spacing: 15px;
}

.text-danger {
	color: red;
	font-weight: bold;
}
</style>

</head>
<body>
	<div style="text-align: left; padding: 5px 0;">
		<a href="${pageContext.request.contextPath}/register?lang=en"> Login
			English</a> &nbsp;&nbsp; <a
			href="${pageContext.request.contextPath}/register?lang=fr">Login
			French</a>
	</div>

	<div align="center">
		<h1>
			<s:message code="label.registration_title" />
		</h1>
		<br>
		<form:form action="register" method="post" modelAttribute="employee">
			<table>
				<tr>
					
					<td><form:label path="firstName">
							<s:message code="label.firstName" /> : </form:label></td>
					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName" cssClass="text-danger" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">
							<s:message code="label.lastName" /> : </form:label></td>
					<td><form:input path="lastName" /></td>
					<td>
					<form:errors path="lastName" cssClass="text-danger" /></td>
				</tr>
				<tr>
					<td><form:label path="title">
							<s:message code="label.title" /> : </form:label></td>
					<td><form:select path="title" >					
						<form:option value="NONE" label = "-- choose a title --"></form:option>
						<form:option value="Head Teller"></form:option>
						<form:option value="Teller"></form:option>
						<form:option value="Developper"></form:option>
						<form:option value="Manager"></form:option>
						<form:option value="Accountant"></form:option>
					</form:select>
					</td>
					<td><form:errors path="title" cssClass="text-danger" /></td>
				</tr>
				<tr>
					<td><form:label path="startDate">
							<s:message code="label.startDate" /> : </form:label></td>
					<td><form:input path="startDate" /></td>
					<td><form:errors path="startDate" cssClass="text-danger" /></td>
				</tr>
				<tr>
					<td><form:label path="email">
							<s:message code="label.email" />  :</form:label></td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="text-danger" /></td>
				</tr>
				<tr>
					<td><form:label path="gender">
							<s:message code="label.gender" /> :</form:label></td>
					<td><form:radiobutton path="gender" value="Male" />
						<s:message code="label.male" />
						<form:radiobutton path="gender" value="Female" />
						<s:message code="label.female" /></td>
					<td><form:errors path="gender" cssClass="text-danger" /></td>
				</tr>
				<tr>
					<td><form:label path="married">
							<s:message code="label.married" />? :</form:label></td>
					<td><form:checkbox path="married" /></td>
				</tr>

				<tr>
					<td><form:button>
							<s:message code="label.register" />
						</form:button></td>
				</tr>
			</table>
		</form:form>


	</div>

</body>
</html>