<%@page import="models.NoParkingZone"%>
<%@page import="java.util.List"%>
<%@ page import="models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  User user = (User) request.getAttribute("user"); %>
<%  List<NoParkingZone> noParkingZoneList = (List<NoParkingZone>) request.getAttribute("noParkingZoneList"); %>

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
				<div class="section_header">
					<h1>You Are Here!</h1>
				</div>				
				<div class="section-body">
					<h3>These are where you can't park</h3>
					<% for (int i = 0; i < noParkingZoneList.size(); i++) { %>
						<h5> <%= noParkingZoneList.get(i).getId() + " " + noParkingZoneList.get(i).getLoc() %> </h5>
					<% } %>
				</div>
			</div>
		</div>
	</body>
</html>