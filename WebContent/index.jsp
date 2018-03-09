<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/includes/mdl.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; UTF-8">
    <link type="text/css" rel="stylesheet" href="styles.css" />
	<title>BlablaFlop</title>
</head>
<body>
   	<c:import url="/WEB-INF/menu/menu.jsp" />
	<div>
		<div id="map"></div>
		<div id="positionning">
			<span>Calcul de la position en cours</span>
			<div class="mdl-progress mdl-js-progress mdl-progress__indeterminate"></div>
		</div>
	    <script>
	      	
	      function initMap() {
	        var map = new google.maps.Map(document.getElementById('map'), {
	          center: {lat: 43.624992299999995, lng: 1.4319450999999999},
	          zoom: 14
	        });
	        var infoWindow = new google.maps.InfoWindow({map: map});
	
	        // Try HTML5 geolocation.
	        if (navigator.geolocation) {
	          navigator.geolocation.getCurrentPosition(function(position) {
        	    $('#positionning').fadeOut(400);
	            var pos = {
	              lat: position.coords.latitude,
	              lng: position.coords.longitude
	            };
	
	            infoWindow.setPosition(pos);
	            infoWindow.setContent('Vous êtes ici');
	            map.setCenter(pos);
	          }, function() {
	            handleLocationError(true, infoWindow, map.getCenter());
	          });
	        } else {
	          // Browser doesn't support Geolocation
	          handleLocationError(false, infoWindow, map.getCenter());
	        }
	      }
	
	      function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	        infoWindow.setPosition(pos);
	        infoWindow.setContent(browserHasGeolocation ?
	            'Error: The Geolocation service failed.' :
	            'Error: Your browser doesn\'t support geolocation.');
	      }
	    </script>
	    <script async defer
	    	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDwFMR2GJYYdWHWGx-NZya4aJvUWS061VM&callback=initMap">
	    </script>
	</div>
</body>
</html>
