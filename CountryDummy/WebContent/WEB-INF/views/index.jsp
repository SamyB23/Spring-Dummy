<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country Manager Home Page</title>
</head>
<body>
	<div align="center">
		<h1>Country List</h1>
		<h3><a href="newCountry"> New Country</a></h3>
		<table border = "1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Action</th>
			</tr>
			<c:forEach items = "${countryList}" var="country" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${country.name}</td>
				<td>
					<a href="edit?id=${country.id}">Edit</a>
					<a href="delete?id=${country.id}">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>