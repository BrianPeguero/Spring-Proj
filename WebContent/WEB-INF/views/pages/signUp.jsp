<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="../components/__head.jsp" />
		<title>SignUp</title>
	</head>
	<body>
		<header class="nav">
			<jsp:include page="../components/__header.jsp"/>
		</header>
		
		<div class="main">
			<div class="container">
				<h1>Sign Up</h1>
				<jsp:include page="../components/__signUpForm.jsp"/>
			</div>
		</div>
		
		<footer class="footer">
		</footer>
	</body>
</html>