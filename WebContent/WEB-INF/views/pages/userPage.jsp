<%@page import="models.NoParkingZone"%>
<%@page import="java.util.List"%>
<%@ page import="models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%  User user = (User) session.getAttribute("sessionUser"); %>
<%  List<NoParkingZone> noParkingZoneList = (List<NoParkingZone>) request.getAttribute("noParkingZoneList"); %>
<%  List<String> listOfAllUserCars = (List<String>) request.getAttribute("listOfAllUserCars"); %>


<!doctype html>
<html>
	<head>
		<%@include file="../components/__head.jsp"%>
		<title>User Page</title>
		
		<script src = "https://maps.googleapis.com/maps/api/js?language=en"></script>
		
		<script type="text/javascript">
			
		function getLocation() {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(loadMap);
            } else {
                alert("Geolocation is not supported by this browser.");
            }
        }

        function loadMap(position) {
            //map position
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;
            
            //map settings
            var mapOptions = {
                   	center:new google.maps.LatLng(latitude, longitude), 
                    zoom:15, 
                    mapTypeId:google.maps.MapTypeId.ROADMAP
            };
            
            //loading map in the divs
            var map = new google.maps.Map(document.getElementById("sample"),mapOptions);
            
			//Marker where you are
			var marker = new google.maps.Marker({
				position: new google.maps.LatLng(latitude, longitude),
				map: map,
				label:"You",
				});
			
			//Markers No Parking
            <% for (int i = 0; i < noParkingZoneList.size(); i++) { %>
				<% if (noParkingZoneList.get(i).getType() == 1) { %> 
					<% String[] latLong = noParkingZoneList.get(i).getLoc().split(","); %>
						 var marker = new google.maps.Marker({
                			 position: new google.maps.LatLng(<%= latLong[0] %>, <%= latLong[1] %>),
                			 map: map,
                			 label:"FH",
				         });
				<% } %>
				<% if (noParkingZoneList.get(i).getType() == 2) { %>
					<% String[] latLong = noParkingZoneList.get(i).getLoc().split(","); %>
						 var noParking = new google.maps.Polyline({
							 path:[
							 	new google.maps.LatLng(<%= latLong[0] %>, <%= latLong[1] %>),
			                 	new google.maps.LatLng(<%= latLong[2] %>, <%= latLong[3] %>)
			             	],
			               
			                 strokeColor:"#ff0000",
			                 strokeOpacity:0.6,
			                 strokeWeight:2
						 });
						 
						 noParking.setMap(map);
				<% }%>
				<% if (noParkingZoneList.get(i).getType() == 3) { %> 
					<% String[] latLong = noParkingZoneList.get(i).getLoc().split(","); %>
						 var marker = new google.maps.Marker({
                			 position: new google.maps.LatLng(<%= latLong[0] %>, <%= latLong[1] %>),
                			 map: map,
                			 label:"NP",
				         });
				<% } %>
				<% if (noParkingZoneList.get(i).getType() == 4) { %>
				<% String[] latLong = noParkingZoneList.get(i).getLoc().split(","); %>
					 var noParking = new google.maps.Polyline({
						 path:[
						 	new google.maps.LatLng(<%= latLong[0] %>, <%= latLong[1] %>),
		                 	new google.maps.LatLng(<%= latLong[2] %>, <%= latLong[3] %>)
		             	 ],
		             	 
		               
		                 strokeColor:"#000000",
		                 strokeOpacity:0.6,
		                 strokeWeight:2
					 });
					 
					 noParking.setMap(map);
				<% }%>
			<% } %>
			
			//your parked car
			<% if (user.getLocation() != null) { %>
				<% String[] latLong = user.getLocation().split(","); %>
					var marker = new google.maps.Marker({
	   					position: new google.maps.LatLng(<%= latLong[0] %>, <%= latLong[1] %>),
	   					map: map,
	   					label:"PC",
		        	});
			<% } else {}%>
			
			//Markers other cars
			<% for (int l = 0; l < listOfAllUserCars.size(); l++) { %>
				<% if (listOfAllUserCars.get(l) != null) { %>
					<% String[] latLongCars = listOfAllUserCars.get(l).split(","); %> 
					var marker = new google.maps.Marker({
	           			position: new google.maps.LatLng(<%= latLongCars[0] %>, <%= latLongCars[1] %>),
	       				map: map,
	       				label:"Cars",
			        });
				<% } else { %>
				<% } %>
			<% } %>
			
        }
        
        function setPosition(){
        	navigator.geolocation.getCurrentPosition(setLocation);
        }
        
        function setLocation(position) {
        	var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;
        	
        	document.getElementById("capture").value = latitude.toString() + "," + longitude.toString();
        }
			
		</script>
		
	</head>
	
	<body onload="getLocation()">
		<header>
			<jsp:include page="../components/__loggedInHeader.jsp" />
		</header>
		
		<div id="sample" style="width:1500px; height:700px; margin:0px auto;"></div>
	
		<div class="main">
				
			<div class="section-body">
					
				<div onmouseover="setPosition()">
					<jsp:include page="../components/__floatingCaptureButton.jsp"></jsp:include>
				</div>
					
				<jsp:include page="../components/__floatingReleaseButton.jsp"></jsp:include>
					
			</div>
		</div>
	</body>
</html>