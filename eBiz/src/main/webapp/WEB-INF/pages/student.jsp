<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Form Handling</title>
<link href="<%= request.getContextPath() %>/style/myStyle.css" rel="stylesheet"/>
</head>
<body>
	<h2>Student Information</h2>
	<form:form action="/eBiz/addStudent" method="POST">
		<table style="margin: auto; text-align: left">
			<tbody>
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td><form:label path="age">Age</form:label></td>
					<td><form:input path="age"/></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="新增"></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<a href="index.jsp">Go Home</a>
</body>
</html>