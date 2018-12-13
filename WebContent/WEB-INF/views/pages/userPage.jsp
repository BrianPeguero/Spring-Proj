<%@page import="models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% User user = (User) request.getAttribute("user"); %>

<!DOCTYPE html>
	<html>
		<head>
		<jsp:include page="../components/__head.jsp" />
		<title>User Page</title>
	</head>
	<body>
		<header>
			<jsp:include page="../components/__loggedInHeader.jsp"/>
		</header>
		
		<div class="main">
			<div class="container">
				<h1><%= user.getEmail() %></h1>
			</div>
		</div>
	</body>
</html>