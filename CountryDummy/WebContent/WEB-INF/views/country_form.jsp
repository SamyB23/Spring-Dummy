<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New/Edit Country</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Country</h1>
		<form:form action = "save" method = "post" modelAttribute ="country">
		<table cellpadding="5">
			<form:hidden path="id" />
			<tr>
				<td>Name:</td>
				<td><form:input path = "name" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type = "submit" value="Save"/></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>