<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    	<%@ include file="/includes/mdl.jsp" %>
        <title>Inscription | BlablaFlop</title>
        <link type="text/css" rel="stylesheet" href="style/main.css" />
    </head>
    <body>
    	<c:import url="/WEB-INF/menu/menu.jsp" />
		<br>
		<c:import url="/WEB-INF/user/form.jsp" />
        <br />
	    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBH0tjh8m9W5tnOAE1IogA6fTrXXTAzRAc&libraries=places"></script>
    	<script>
    		var auto = new google.maps.places.Autocomplete(document.getElementById('autocomplete'), {types: ['geocode']});
    	</script>
    </body>
</html>
