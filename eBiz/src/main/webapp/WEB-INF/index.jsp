<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome To My Spring Boot Playground!</title>
<link href="<%= request.getContextPath() %>/style/myStyle.css" rel="stylesheet"/>
</head>
<body>
	<h1>Welcome To My Spring Boot Playground!</h1>
	<p>Current Time us : <%= SimpleDateFormat.getInstance().format(new Date()) %></p>
	<a href="hello">Hello</a>|
	<a href="student">Add Student</a>|
	<a href="listStudent">All Student</a>
	<a href="spa/index.html">SPA Demo</a>
</body>
</html>